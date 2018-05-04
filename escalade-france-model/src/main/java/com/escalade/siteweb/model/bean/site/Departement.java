package com.escalade.siteweb.model.bean.site;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Departement {

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut nomDepartement doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nomDepartement ne doit pas comporter plus de 100 caractères")
	private String nomDepartement;


	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Departement() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Departement(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomDepartement() {
		return nomDepartement;
	}


	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}


	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomDepartement=\"").append(nomDepartement).append('"')
		.append("}");
		return vStB.toString();
	}

}
