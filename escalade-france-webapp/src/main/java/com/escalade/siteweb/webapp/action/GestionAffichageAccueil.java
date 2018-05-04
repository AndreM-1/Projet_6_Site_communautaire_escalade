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

public class GestionAffichageAccueil extends ActionSupport {
	// ===================== Attributs =====================

	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres en entrée


	// ----- Eléments en sortie
	private List<Pays> listPays;
	private List<Region> listRegion;
	private List<Departement> listDepartement;
	private List<Site> listSite;
	private List<Secteur> listSecteur;
	private List<Voie> listVoie;
	private List<Commentaire> listCommentaire;
	private List <Utilisateur> listUtilisateur;
	private List <FormulaireContact> listFormulaireContact;
	private List <Photo> listPhoto;
	private String imageAccueil="assets/images/fondEcran1.jpg";


	// ===================== Getters/Setters ===============	
	public List<Pays> getListPays() {
		return listPays;
	}

	public void setListPays(List<Pays> listPays) {
		this.listPays = listPays;
	}

	public List<Region> getListRegion() {
		return listRegion;
	}

	public void setListRegion(List<Region> listRegion) {
		this.listRegion = listRegion;
	}

	public List<Departement> getListDepartement() {
		return listDepartement;
	}

	public void setListDepartement(List<Departement> listDepartement) {
		this.listDepartement = listDepartement;
	}

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
	
	public String getImageAccueil() {
		return imageAccueil;
	}

	public void setImageAccueil(String imageAccueil) {
		this.imageAccueil = imageAccueil;
	}

	// ===================== Méthodes ======================
	public String execute() {
		return SUCCESS;
	}

	public String doList() {
		listPays = managerFactory.getPaysManager().getListPays();
		listRegion = managerFactory.getRegionManager().getListRegion();
		listDepartement = managerFactory.getDepartementManager().getListDepartement();
		listSite=managerFactory.getSiteManager().getListSite();
		listSecteur=managerFactory.getSecteurManager().getListSecteur();
		listVoie=managerFactory.getVoieManager().getListVoie();
		listCommentaire=managerFactory.getCommentaireManager().getListCommentaire();
		listUtilisateur=managerFactory.getUtilisateurManager().getListUtilisateur();
		listFormulaireContact=managerFactory.getFormulaireContactManager().getListFormulaireContact();
		listPhoto=managerFactory.getPhotoManager().getListPhoto();
		System.out.println("Liste des pays :");
		System.out.println(listPays);
		System.out.println("Liste des régions :");
		System.out.println(listRegion);
		System.out.println("Liste des départements :");
		System.out.println(listDepartement);
		System.out.println(imageAccueil);

		return ActionSupport.SUCCESS;
	}

}
