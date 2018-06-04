package com.escalade.siteweb.webapp.action;

import javax.inject.Inject;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.opensymphony.xwork2.ActionSupport;

public class GestionPageGenerique extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ManagerFactory managerFactory;

	// ----- Eléments en sortie
	private Utilisateur utilisateur;
	
	// ===================== Getters/Setters ===============	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	// ===================== Méthodes ======================
	public String execute() {
		return SUCCESS;
	}
	
	public String doDetailUtilisateurAdmin() {
		utilisateur=managerFactory.getUtilisateurManager().getListUtilisateur().get(0);
		return SUCCESS;
	}

}
