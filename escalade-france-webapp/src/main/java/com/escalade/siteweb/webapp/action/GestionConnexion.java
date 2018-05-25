package com.escalade.siteweb.webapp.action;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;

public class GestionConnexion extends ActionSupport implements SessionAware, ServletRequestAware{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres en entrée
	
	// ----- Eléments en sortie
	private String adresseMail;
	private String motDePasse;
	private Boolean seSouvenirDeMoi;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;
	
	// ===================== Getters/Setters ===============
	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getSeSouvenirDeMoi() {
		return seSouvenirDeMoi;
	}

	public void setSeSouvenirDeMoi(Boolean seSouvenirDeMoi) {
		this.seSouvenirDeMoi = seSouvenirDeMoi;
	}
	
	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;
		
	}
	
	@Override
	public void setServletRequest(HttpServletRequest pRequest) {
		this.servletRequest=pRequest;
		
	}
	
	// ===================== Méthodes ======================
	/**
	 * Action permettant la connexion d'un utilisateur. Le but est de ressortir de cette méthode
	 * avec un objet de type Utilisateur en session
	 * @return input / success
	 */
	public String doLogin() {
		String vResult = ActionSupport.INPUT;
		System.out.println("Adresse mail :"+adresseMail);
		System.out.println("Mot de Passe :"+motDePasse);
		System.out.println("Se souvenir de moi:"+seSouvenirDeMoi);
	
		if (!StringUtils.isAllEmpty(adresseMail, motDePasse)) {
			try {
				Utilisateur vUtilisateur= managerFactory.getUtilisateurManager().getUtilisateur(adresseMail, motDePasse);

				// Ajout de l'utilisateur en session
				this.session.put("user", vUtilisateur);

				vResult = ActionSupport.SUCCESS;
			} catch (NotFoundException pEx) {
				System.out.println(pEx.getMessage());
				this.addActionError("Identifiant ou mot de passe invalide !");
			}
		}
		return vResult;
	}
	
	/**
	 * Action de déconnexion d'un utilisateur
	 * @return success
	 */
	public String doLogout() {
		//Suppression de l'utilisateur en session
		//this.session.remove("user");

		//Invalidation de la session
		this.servletRequest.getSession().invalidate();

		return ActionSupport.SUCCESS;
	}

}
