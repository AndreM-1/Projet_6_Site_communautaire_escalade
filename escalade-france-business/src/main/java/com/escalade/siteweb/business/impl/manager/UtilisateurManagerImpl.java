package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Named;
import javax.validation.ConstraintViolation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.escalade.siteweb.business.contract.manager.UtilisateurManager;
import com.escalade.siteweb.business.passwordutils.PasswordUtils;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	private List<Utilisateur> listUtilisateur = new ArrayList<>();
	private Utilisateur utilisateur;
	private static final int SALT_LENGTH = 30;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(UtilisateurManagerImpl.class);

	@Override
	public List<Utilisateur> getListUtilisateur() {
		listUtilisateur=getDaoFactory().getUtilisateurDao().getListUtilisateur();
		return this.listUtilisateur;
	}	

	@Override
	public Utilisateur getUtilisateur(String adresseMail, String motDePasse) throws NotFoundException {
		LOGGER.info("Adresse Mail : "+adresseMail);
		try {
			utilisateur=getDaoFactory().getUtilisateurDao().getUtilisateur(adresseMail);
		} catch (NotFoundException e1) {
			LOGGER.info(e1.getMessage());
			throw new NotFoundException("Business - Aucun utilisateur correspondant à l'adresse mail demandée.");
		}
		LOGGER.info("Business - Méthode getUtilisateur - Utilisateur"+utilisateur);
		LOGGER.info("Business - Méthode getUtilisateur - Mot de passe non sécurisé : "+motDePasse);
		LOGGER.info("Business - Méthode getUtilisateur - Salt : "+utilisateur.getSalt());
		LOGGER.info("Business - Méthode getUtilisateur - Mot de passe sécurisé : "+utilisateur.getMotDePasseSecurise());
		
		boolean passwordMatch=PasswordUtils.verifyUserPassword(motDePasse,utilisateur.getMotDePasseSecurise(), utilisateur.getSalt());
		
		if (passwordMatch) {
			return utilisateur;
		}else {
			LOGGER.info("Business - Aucun utilisateur correspondant au password fourni.");
			throw new NotFoundException("Business - Aucun utilisateur correspondant au password fourni.");	
		}
	}

	@Override
	public Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException {
		try {
			utilisateur=getDaoFactory().getUtilisateurDao().getUtilisateur(utilisateurId);
			return utilisateur;
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - Aucun utilisateur ne correspond à l'ID demandé.");
		}
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws FunctionalException {
		
		//On lève une exception si la validation de bean échoue.
		Set<ConstraintViolation<Utilisateur>> vViolations = getConstraintValidator().validate(utilisateur);

		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<Utilisateur> violation : vViolations) {
				LOGGER.info((violation.getMessage())); 
			}
			throw new FunctionalException("Certains paramètres ne sont pas renseignés ou pas renseignés correctement.");
		}

		//Utilisation d'un TransactionStatus. On a besoin de lever une FunctionalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			getDaoFactory().getUtilisateurDao().updateUtilisateur(utilisateur);
		} catch (FunctionalException e) {
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new FunctionalException("Le pseudo ou l'adresse mail existe déjà.");
		}	
		getPlatformTransactionManager().commit(vTransactionStatus);
	}

	@Override
	public void updateMdp (Utilisateur utilisateur) throws FunctionalException{
		
		//On lève une exception si la validation de bean échoue.
		LOGGER.info("Business - Méthode updateMdp : "+utilisateur);
		Set<ConstraintViolation<Utilisateur>> vViolations = getConstraintValidator().validate(utilisateur);

		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<Utilisateur> violation : vViolations) {
				LOGGER.info((violation.getMessage())); 
			}
			throw new FunctionalException("Le nouveau mot de passe n'est pas renseigné correctement.");
		}
		
		//Utilisation d'un TransactionStatus. On a besoin de lever une FunctionalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		
		LOGGER.info("Business - Méthode updateMdp - Mot de passe non sécurisé : "+utilisateur.getMotDePasse());
		//Cryptage Mot de passe.
		String salt=PasswordUtils.getSalt(SALT_LENGTH);
		String mySecurePassword=PasswordUtils.generateSecurePassword(utilisateur.getMotDePasse(), salt);
		LOGGER.info("Business - Méthode updateMdp - Nouveau Salt :"+salt);
		LOGGER.info("Business - Méthode updateMdp - Nouveau Mot de passe sécurisé : "+mySecurePassword);
		utilisateur.setSalt(salt);
		utilisateur.setMotDePasseSecurise(mySecurePassword);
		getDaoFactory().getUtilisateurDao().updateMdp(utilisateur);
		
		getPlatformTransactionManager().commit(vTransactionStatus);
		
	}

	@Override
	public void insertUtilisateur (Utilisateur utilisateur) throws FunctionalException {
		
		//On lève une exception si la validation de bean échoue.
		Set<ConstraintViolation<Utilisateur>> vViolations = getConstraintValidator().validate(utilisateur);

		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<Utilisateur> violation : vViolations) {
				LOGGER.info((violation.getMessage())); 
			}
			throw new FunctionalException("Certains paramètres ne sont pas renseignés correctement.");
		}
		
		//Utilisation d'un TransactionStatus. On a besoin de lever une FunctionalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			LOGGER.info("Business - Méthode insertUtilisateur - Mot de passe non sécurisé : "+utilisateur.getMotDePasse());
			//Cryptage Mot de passe.
			String salt=PasswordUtils.getSalt(SALT_LENGTH);
			String mySecurePassword=PasswordUtils.generateSecurePassword(utilisateur.getMotDePasse(), salt);
			LOGGER.info("Business - Méthode insertUtilisateur - Salt :"+salt);
			LOGGER.info("Business - Méthode insertUtilisateur - Mot de passe sécurisé : "+mySecurePassword);
			utilisateur.setSalt(salt);
			utilisateur.setMotDePasseSecurise(mySecurePassword);
			getDaoFactory().getUtilisateurDao().insertUtilisateur(utilisateur);
		} catch (FunctionalException vEx) {
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new FunctionalException("Le pseudo ou l'adresse mail existe déjà.");
		}
		getPlatformTransactionManager().commit(vTransactionStatus);

	}
}