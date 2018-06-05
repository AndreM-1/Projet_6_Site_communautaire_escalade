package com.escalade.siteweb.model.bean.site;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Voie implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut nomVoie doit être renseigné")
	@NotBlank(message="Model - L'attribut nomVoie doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nomVoie ne doit pas comporter plus de 100 caractères")
	private String nomVoie;
	
	@NotEmpty (message="Model - L'attribut cotation doit être renseigné")
	@NotBlank(message="Model - L'attribut cotation doit être renseigné")
	@Size (min=0,max=100,message="Model - L'attribut cotation ne doit pas comporter plus de 100 caractères")
	private String cotation;
	
	@NotEmpty (message="Model - L'attribut hauteur doit être renseigné")
	@NotBlank(message="Model - L'attribut hauteur doit être renseigné")
	@Size (min=0,max=100,message="Model - L'attribut hauteur ne doit pas comporter plus de 100 caractères")
	private String hauteur;
	
	@NotEmpty (message="Model - L'attribut nbPoints doit être renseigné")
	@NotBlank(message="Model - L'attribut nbPoints doit être renseigné")
	@Size (min=0,max=100,message="Model - L'attribut nbPoints ne doit pas comporter plus de 100 caractères")
	private String nbPoints;
	
	@NotEmpty (message="Model - L'attribut duree doit être renseigné")
	@NotBlank(message="Model - L'attribut duree doit être renseigné")
	@Size (min=0,max=100,message="Model - L'attribut duree ne doit pas comporter plus de 100 caractères")
	private String duree;

	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Voie() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Voie(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomVoie() {
		return nomVoie;
	}


	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}


	public String getCotation() {
		return cotation;
	}


	public void setCotation(String cotation) {
		this.cotation = cotation;
	}


	public String getHauteur() {
		return hauteur;
	}


	public void setHauteur(String hauteur) {
		this.hauteur = hauteur;
	}


	public String getNbPoints() {
		return nbPoints;
	}


	public void setNbPoints(String nbPoints) {
		this.nbPoints = nbPoints;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
	}


	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomVoie=\"").append(nomVoie).append('"')
		.append(vSeparateur).append("cotation=\"").append(cotation).append('"')
		.append(vSeparateur).append("hauteur=\"").append(hauteur).append('"')
		.append(vSeparateur).append("nbPoints=\"").append(nbPoints).append('"')
		.append(vSeparateur).append("duree=\"").append(duree).append('"')
		.append("}");
		return vStB.toString();
	}
}
