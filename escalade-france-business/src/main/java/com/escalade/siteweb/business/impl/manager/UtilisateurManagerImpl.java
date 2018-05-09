package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;


import com.escalade.siteweb.business.contract.manager.UtilisateurManager;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
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
}