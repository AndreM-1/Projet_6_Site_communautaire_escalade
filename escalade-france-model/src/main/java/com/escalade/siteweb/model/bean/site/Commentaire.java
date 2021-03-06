package com.escalade.siteweb.model.bean.site;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;

/**
 * Classe du modèle lié au bean Commentaire.
 * @author André Monnier
 */
public class Commentaire implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut commentaire doit être renseigné")
	private String commentaire;

	private Date dateCommentaire;
	
	private Utilisateur utilisateur;


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
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
		.append(vSeparateur).append("utilisateur=\"").append(utilisateur).append('"')
		.append("}");
		return vStB.toString();
	}
}