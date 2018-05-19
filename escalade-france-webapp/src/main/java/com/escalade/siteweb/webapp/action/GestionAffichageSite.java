package com.escalade.siteweb.webapp.action;

import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Commentaire;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;

public class GestionAffichageSite extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres en entrée
	private Integer id;
	private Commentaire commentaire;

	// ----- Eléments en entrée et sortie
	private Site site;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	

	// ===================== Getters/Setters ===============
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;
		
	}
	
	// ===================== Méthodes ======================

	/**
	 * Action affichant les détails d'un {@link Site}
	 * @return success / error
	 */
	public String doDetailSite() {
		if (id == null) {
			this.addActionError("L'id du site est manquant.");
		} else {
			try {
				site=managerFactory.getSiteManager().getSite(id);
			} catch (NotFoundException pEx) {
				this.addActionError("Site non trouvé. ID= "+id);
			}
		}
		return (this.hasErrors())?ActionSupport.ERROR:ActionSupport.SUCCESS;
	}
	
	/**
	 * Action permettant d'ajouter un {@link Commentaire}
	 * @return success
	 */
	public String doAjoutCommentaire() {
		String vResult = ActionSupport.SUCCESS;
		Utilisateur utilisateur=(Utilisateur)session.get("user");
		commentaire.setDateCommentaire(new Date());
		System.out.println("Pseudo :"+ utilisateur.getPseudo());
		System.out.println("Commentaire :"+commentaire.getCommentaire());
		System.out.println("Utilisateur_id :"+ utilisateur.getId());
		System.out.println("Site.id :"+site.getId());
		
		if(commentaire.getCommentaire().trim().length()!=0)
			managerFactory.getCommentaireManager().insertCommentaire(commentaire.getCommentaire(),utilisateur.getId(),site.getId(), commentaire.getDateCommentaire());

		return vResult;
		
	}
	
}