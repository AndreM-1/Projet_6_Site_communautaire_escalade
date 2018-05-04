package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.UtilisateurManager;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	private List<Utilisateur> listUtilisateur = new ArrayList<>();

	@Override
	public List<Utilisateur> getListUtilisateur() {
		listUtilisateur=getDaoFactory().getUtilisateurDao().getListUtilisateur();
		return this.listUtilisateur;
	}	
}