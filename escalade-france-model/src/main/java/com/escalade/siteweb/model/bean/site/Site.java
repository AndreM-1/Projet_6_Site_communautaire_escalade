package com.escalade.siteweb.model.bean.site;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Site {


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

	@NotEmpty (message="Model - L'attribut dateAjoutSite doit être renseigné")
	private Date dateAjoutSite;

	@NotEmpty (message="Model - L'attribut dateMajSite doit être renseigné")
	private Date dateMajSite;

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
		.append("}");
		return vStB.toString();
	}

}
