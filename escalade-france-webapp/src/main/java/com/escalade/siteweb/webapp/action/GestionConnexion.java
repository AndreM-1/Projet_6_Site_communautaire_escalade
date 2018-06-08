package com.escalade.siteweb.webapp.action;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer la connexion
 * et la déconnexion d'un {@link Utilisateur}
 * @author André Monnier
 */
public class GestionConnexion extends ActionSupport implements SessionAware, ServletRequestAware{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	
	// ----- Paramètres
	private String adresseMail;
	private String motDePasse;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionConnexion.class);
	
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
	 * Méthode permettant la connexion d'un utilisateur. Le but est de ressortir de cette méthode
	 * avec un objet de type {@link Utilisateur} en session
	 * @return input / success
	 */
	public String doLogin() {
		String vResult = ActionSupport.INPUT;
		LOGGER.info("Adresse mail :"+adresseMail);
		LOGGER.info("Mot de Passe :"+motDePasse);
	
		if (!StringUtils.isAllEmpty(adresseMail, motDePasse)) {
			try {
				Utilisateur vUtilisateur= managerFactory.getUtilisateurManager().getUtilisateur(adresseMail, motDePasse);

				// Ajout de l'utilisateur en session
				this.session.put("user", vUtilisateur);

				vResult = ActionSupport.SUCCESS;
			} catch (NotFoundException pEx) {
				LOGGER.info(pEx.getMessage());
				this.addActionError("Identifiant ou mot de passe invalide !");
			}
		}
		return vResult;
	}
	
	/**
	 * Méthode permettant la déconnexion d'un utilisateur
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
