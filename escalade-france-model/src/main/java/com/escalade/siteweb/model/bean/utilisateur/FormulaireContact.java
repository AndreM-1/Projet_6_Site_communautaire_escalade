package com.escalade.siteweb.model.bean.utilisateur;


import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Classe du modèle lié au bean FormulaireContact.
 * @author André Monnier
 */
public class FormulaireContact implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut nomNa doit être renseigné")
	@NotBlank(message="Model - L'attribut nomNa doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nomNa ne doit pas comporter plus de 100 caractères")
	private String nomNa;

	@NotEmpty (message="Model - L'attribut adresseMailNa doit être renseigné")
	@NotBlank(message="Model - L'attribut adresseMailNa doit être renseigné")
	@Email(message="Model - Le format d'adresse mail n'est pas valide")
	@Size (min=1,max=100,message="Model - L'attribut adresseMailNa ne doit pas comporter plus de 100 caractères")
	private String adresseMailNa;

	@NotEmpty (message="Model - L'attribut objet doit être renseigné")
	@NotBlank(message="Model - L'attribut objet doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut objet ne doit pas comporter plus de 100 caractères")
	private String objet;

	@NotEmpty (message="Model - L'attribut message doit être renseigné")
	@NotBlank (message="Model - L'attribut message doit être renseigné")
	private String message;

	private Utilisateur utilisateur;
	
	private Date dateFormContact;


	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public FormulaireContact() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public FormulaireContact(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomNa() {
		return nomNa;
	}


	public void setNomNa(String nomNa) {
		this.nomNa = nomNa;
	}


	public String getAdresseMailNa() {
		return adresseMailNa;
	}


	public void setAdresseMailNa(String adresseMailNa) {
		this.adresseMailNa = adresseMailNa;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Date getDateFormContact() {
		return dateFormContact;
	}


	public void setDateFormContact(Date dateFormContact) {
		this.dateFormContact = dateFormContact;
	}


	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomNa=\"").append(nomNa).append('"')
		.append(vSeparateur).append("adresseMailNa=\"").append(adresseMailNa).append('"')
		.append(vSeparateur).append("objet=\"").append(objet).append('"')
		.append(vSeparateur).append("message=\"").append(message).append('"')
		.append(vSeparateur).append("utilisateur=\"").append(utilisateur.getId()).append('"')
		.append(vSeparateur).append("dateFormContact=\"").append(dateFormContact).append('"')
		.append("}");
		return vStB.toString();
	}

}
