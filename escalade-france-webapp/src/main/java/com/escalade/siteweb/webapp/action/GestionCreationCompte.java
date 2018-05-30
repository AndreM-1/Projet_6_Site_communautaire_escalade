package com.escalade.siteweb.webapp.action;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Action permettant de créer un compte utilisateur
 * @author André Monnier
 *
 */
public class GestionCreationCompte extends ActionSupport implements SessionAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----- Eléments en entrée
	private Utilisateur utilisateur;
	private Boolean conditionsUtilisation;

	@Inject
	private ManagerFactory managerFactory;


	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionCreationCompte.class);

	// ===================== Getters/Setters =====================
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Boolean getConditionsUtilisation() {
		return conditionsUtilisation;
	}


	public void setConditionsUtilisation(Boolean conditionsUtilisation) {
		this.conditionsUtilisation = conditionsUtilisation;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;

	}

	@Override
	public void setServletRequest(HttpServletRequest pRequest) {
		this.servletRequest=pRequest;

	}


	// ===================== Méthodes =====================
	/**
	 * Action permettant la création d'un compte utilisateur
	 * @return error/input/success
	 */
	public String doCreationCompte() {
		// Si (this.utilisateur == null) c'est que l'on entre dans le formulaire de création de compte utilisateur
		// Sinon, c'est que l'on vient de valider le formulaire de création de compte

		// Par défaut, le result est "input
		String vResult = ActionSupport.INPUT;

		//Validation du formulaire (utilisateur != null)
		if(utilisateur!=null) {
			if(conditionsUtilisation) {
				utilisateur.setAdministrateur(false);

				try {
					LOGGER.info("utilisateur :"+utilisateur);
					managerFactory.getUtilisateurManager().insertUtilisateur(utilisateur);

					try {
						utilisateur.setId(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getAdresseMail(), utilisateur.getMotDePasse()).getId());
					} catch (NotFoundException e) {
						this.addActionError("Utilisateur non trouvé.");
						vResult="error";
					}

					// Ajout de l'utilisateur en session
					this.session.put("user", utilisateur);
					vResult=ActionSupport.SUCCESS;
				} catch (FunctionalException e) {
					this.addActionError(e.getMessage());
				}
			}else {
				this.addActionError("Veuillez accepter les conditions d'utilisation.");
			}
		}
		return vResult;
	}

}
