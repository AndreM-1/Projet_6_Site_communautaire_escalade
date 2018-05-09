package com.escalade.siteweb.webapp.action;

import java.util.List;

import javax.inject.Inject;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.photo.Photo;
import com.escalade.siteweb.model.bean.site.Commentaire;
import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.bean.site.Voie;
import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	// ===================== Attributs =====================
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;
	
	private List<Site> listSite;
	private List<Secteur> listSecteur;
	private List<Voie> listVoie;
	private List<Commentaire> listCommentaire;
	private List <Utilisateur> listUtilisateur;
	private List <FormulaireContact> listFormulaireContact;
	private List <Photo> listPhoto;
	private Pays pays;
	private Region region;
	private Departement departement;

	// ===================== Getters/Setters ===============
	public List<Site> getListSite() {
		return listSite;
	}
	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	public List<Secteur> getListSecteur() {
		return listSecteur;
	}
	public void setListSecteur(List<Secteur> listSecteur) {
		this.listSecteur = listSecteur;
	}
	public List<Voie> getListVoie() {
		return listVoie;
	}
	public void setListVoie(List<Voie> listVoie) {
		this.listVoie = listVoie;
	}
	public List<Commentaire> getListCommentaire() {
		return listCommentaire;
	}
	public void setListCommentaire(List<Commentaire> listCommentaire) {
		this.listCommentaire = listCommentaire;
	}
	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}
	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}
	public List<FormulaireContact> getListFormulaireContact() {
		return listFormulaireContact;
	}
	public void setListFormulaireContact(List<FormulaireContact> listFormulaireContact) {
		this.listFormulaireContact = listFormulaireContact;
	}
	public List<Photo> getListPhoto() {
		return listPhoto;
	}
	public void setListPhoto(List<Photo> listPhoto) {
		this.listPhoto = listPhoto;
	}
	
	
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	public String doTest() {
		
		listSite=managerFactory.getSiteManager().getListSite();
		listSecteur=managerFactory.getSecteurManager().getListSecteur();
		listVoie=managerFactory.getVoieManager().getListVoie();
		listCommentaire=managerFactory.getCommentaireManager().getListCommentaire();
		listUtilisateur=managerFactory.getUtilisateurManager().getListUtilisateur();
		listFormulaireContact=managerFactory.getFormulaireContactManager().getListFormulaireContact();
		listPhoto=managerFactory.getPhotoManager().getListPhoto();
		System.out.println("Classe TestAction - Pays :"+pays);
		System.out.println("Classe TestAction - Region :"+region);
		System.out.println("Classe TestAction - Departement :"+departement);
		return ActionSupport.SUCCESS;
		
	}

}
