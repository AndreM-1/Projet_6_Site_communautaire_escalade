package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Named;
import javax.validation.ConstraintViolation;

import org.springframework.transaction.TransactionStatus;
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

		Set<ConstraintViolation<Utilisateur>> vViolations = getConstraintValidator().validate(utilisateur);

		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<Utilisateur> violation : vViolations) {
				System.out.println((violation.getMessage())); 
			}
			throw new FunctionalException("Certains paramètres ne sont pas renseignés ou pas renseignés correctement.");
		}

		TransactionTemplate vTransactionTemplate=new TransactionTemplate(getPlatformTransactionManager());
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
				getDaoFactory().getUtilisateurDao().updateUtilisateur(utilisateur);	
			}   
		});
	}
	
	@Override
	public void updateMdp (Utilisateur utilisateur) throws FunctionalException{
		Set<ConstraintViolation<Utilisateur>> vViolations = getConstraintValidator().validate(utilisateur);

		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<Utilisateur> violation : vViolations) {
				System.out.println((violation.getMessage())); 
			}
			throw new FunctionalException("Le nouveau mot de passe n'est pas renseigné correctement.");
		}
		
		TransactionTemplate vTransactionTemplate=new TransactionTemplate(getPlatformTransactionManager());
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
				getDaoFactory().getUtilisateurDao().updateMdp(utilisateur);	
			}   
		});
	}
}