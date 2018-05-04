package com.escalade.siteweb.model.bean.utilisateur;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormulaireContact {

	// ==================== Attributs ====================
	private Integer id;

	@Size (min=0,max=100,message="Model - L'attribut nomNa ne doit pas comporter plus de 100 caractères")
	private String nomNa;

	@Email(message="Model - Le format d'adresse mail n'est pas valide")
	@Size (min=0,max=100,message="Model - L'attribut adresseMailNa ne doit pas comporter plus de 100 caractères")
	private String adresseMailNa;

	@NotEmpty (message="Model - L'attribut objet doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut objet ne doit pas comporter plus de 100 caractères")
	private String objet;

	@NotEmpty (message="Model - L'attribut message doit être renseigné")
	private String message;



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
		.append("}");
		return vStB.toString();
	}

}
