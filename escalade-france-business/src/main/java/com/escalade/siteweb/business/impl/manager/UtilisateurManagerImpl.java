package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Named;
import javax.validation.ConstraintViolation;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.escalade.siteweb.business.contract.manager.UtilisateurManager;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	private List<Utilisateur> listUtilisateur = new ArrayList<>();
	private Utilisateur utilisateur;

	@Override
	public List<Utilisateur> getListUtilisateur() {
		listUtilisateur=getDaoFactory().getUtilisateurDao().getListUtilisateur();
		return this.listUtilisateur;
	}	

	@Override
	public Utilisateur getUtilisateur(String adresseMail, String motDePasse) throws NotFoundException {

		try {
			utilisateur=getDaoFactory().getUtilisateurDao().getUtilisateur(adresseMail,motDePasse);
			return utilisateur;
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			throw new NotFoundException("Business - Aucun utilisateur correspondant au couple login/password fourni.");
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
				System.out.println((violation.getMessage())); 
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
		Set<ConstraintViolation<Utilisateur>> vViolations = getConstraintValidator().validate(utilisateur);

		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<Utilisateur> violation : vViolations) {
				System.out.println((violation.getMessage())); 
			}
			throw new FunctionalException("Le nouveau mot de passe n'est pas renseigné correctement.");
		}
		
		//Utilisation d'un TransactionTemplate.
		TransactionTemplate vTransactionTemplate=new TransactionTemplate(getPlatformTransactionManager());
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
				getDaoFactory().getUtilisateurDao().updateMdp(utilisateur);	
			}   
		});
	}

	@Override
	public void insertUtilisateur (Utilisateur utilisateur) throws FunctionalException {
		
		//On lève une exception si la validation de bean échoue.
		Set<ConstraintViolation<Utilisateur>> vViolations = getConstraintValidator().validate(utilisateur);

		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<Utilisateur> violation : vViolations) {
				System.out.println((violation.getMessage())); 
			}
			throw new FunctionalException("Certains paramètres ne sont pas renseignés correctement.");
		}
		
		//Utilisation d'un TransactionStatus. On a besoin de lever une FunctionalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			getDaoFactory().getUtilisateurDao().insertUtilisateur(utilisateur);
		} catch (FunctionalException vEx) {
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new FunctionalException("Le pseudo ou l'adresse mail existe déjà.");
		}
		getPlatformTransactionManager().commit(vTransactionStatus);

	}
}