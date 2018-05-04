package com.escalade.siteweb.model.bean.site;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class Commentaire {

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut commentaire doit être renseigné")
	private String commentaire;

	@NotEmpty (message="Model - L'attribut dateCommentaire doit être renseigné")
	private Date dateCommentaire;

	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Commentaire() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Commentaire(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Date getDateCommentaire() {
		return dateCommentaire;
	}


	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}


	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("commentaire=\"").append(commentaire).append('"')
		.append(vSeparateur).append("dateCommentaire=\"").append(dateCommentaire).append('"')
		.append("}");
		return vStB.toString();
	}
}