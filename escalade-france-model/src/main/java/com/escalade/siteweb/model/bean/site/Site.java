package com.escalade.siteweb.model.bean.site;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.escalade.siteweb.model.bean.photo.Photo;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;


public class Site implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut nomSite doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nomSite ne doit pas comporter plus de 100 caractères")
	private String nomSite;

	private String descriptif;

	private String commentairePersonnel;

	@NotEmpty (message="Model - L'attribut topoDisponible doit être renseigné")
	private Boolean topoDisponible;

	private Date dateDeDebut;

	private Date dateDeFin;

	private Date dateAjoutSite;

	private Date dateMajSite;
	
	@NotEmpty (message="Model - L'attribut utilisateur doit être renseigné")
	private Utilisateur utilisateur;
	
	@NotEmpty (message="Model - L'attribut pays doit être renseigné")
	private Pays pays;
	
	@NotEmpty (message="Model - L'attribut region doit être renseigné")
	private Region region;
	
	@NotEmpty (message="Model - L'attribut departement doit être renseigné")
	private Departement departement;
	
	private Photo photoSite;
	
	private List<Photo> listPhotoAllSecteur;
	
	private List<Commentaire> listCommentaire;
	
	private List<Secteur> listSecteur;

	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Site() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Site(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomSite() {
		return nomSite;
	}


	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}


	public String getDescriptif() {
		return descriptif;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}


	public String getCommentairePersonnel() {
		return commentairePersonnel;
	}


	public void setCommentairePersonnel(String commentairePersonnel) {
		this.commentairePersonnel = commentairePersonnel;
	}


	public Boolean getTopoDisponible() {
		return topoDisponible;
	}


	public void setTopoDisponible(Boolean topoDisponible) {
		this.topoDisponible = topoDisponible;
	}


	public Date getDateDeDebut() {
		return dateDeDebut;
	}


	public void setDateDeDebut(Date dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}


	public Date getDateDeFin() {
		return dateDeFin;
	}


	public void setDateDeFin(Date dateDeFin) {
		this.dateDeFin = dateDeFin;
	}


	public Date getDateAjoutSite() {
		return dateAjoutSite;
	}


	public void setDateAjoutSite(Date dateAjoutSite) {
		this.dateAjoutSite = dateAjoutSite;
	}


	public Date getDateMajSite() {
		return dateMajSite;
	}


	public void setDateMajSite(Date dateMajSite) {
		this.dateMajSite = dateMajSite;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Pays getPays() {
		return pays;
	}


	public void setPays(Pays pays) {
		this.pays = pays;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public Photo getPhotoSite() {
		return photoSite;
	}


	public void setPhotoSite(Photo photoSite) {
		this.photoSite = photoSite;
	}
	

	public List<Photo> getListPhotoAllSecteur() {
		return listPhotoAllSecteur;
	}


	public void setListPhotoAllSecteur(List<Photo> listPhotoAllSecteur) {
		this.listPhotoAllSecteur = listPhotoAllSecteur;
	}
	
	public List<Commentaire> getListCommentaire() {
		return listCommentaire;
	}


	public void setListCommentaire(List<Commentaire> listCommentaire) {
		this.listCommentaire = listCommentaire;
	}
	
	public List<Secteur> getListSecteur() {
		return listSecteur;
	}


	public void setListSecteur(List<Secteur> listSecteur) {
		this.listSecteur = listSecteur;
	}

	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomSite=\"").append(nomSite).append('"')
		.append(vSeparateur).append("descriptif=\"").append(descriptif).append('"')
		.append(vSeparateur).append("commentairePersonnel=\"").append(commentairePersonnel).append('"')
		.append(vSeparateur).append("topoDisponible=\"").append(topoDisponible).append('"')
		.append(vSeparateur).append("dateDeDebut=\"").append(dateDeDebut).append('"')
		.append(vSeparateur).append("dateDeFin=\"").append(dateDeFin).append('"')
		.append(vSeparateur).append("dateAjoutSite=\"").append(dateAjoutSite).append('"')
		.append(vSeparateur).append("dateMajSite=\"").append(dateMajSite).append('"')
		.append(vSeparateur).append("utilisateur=\"").append(utilisateur.getPseudo()).append('"')
		.append(vSeparateur).append("pays=\"").append(pays.getNomPays()).append('"')
		.append(vSeparateur).append("region=\"").append(region.getNomRegion()).append('"')
		.append(vSeparateur).append("departement=\"").append(departement.getNomDepartement()).append('"')
		.append(vSeparateur).append("photoSite=\"").append(photoSite).append('"')
		.append(vSeparateur).append("listPhotoAllSecteur=\"").append(listPhotoAllSecteur).append('"')
		.append(vSeparateur).append("listCommentaire=\"").append(listCommentaire).append('"')
		.append(vSeparateur).append("listSecteur=\"").append(listSecteur).append('"')
		.append("}");
		return vStB.toString();
	}

}
