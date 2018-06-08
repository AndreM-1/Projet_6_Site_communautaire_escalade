package com.escalade.siteweb.model.bean.site;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Classe du modèle lié au bean Region.
 * @author André Monnier
 */
public class Region implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut nomRegion doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nomRegion ne doit pas comporter plus de 100 caractères")
	private String nomRegion;

	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Region() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Region(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomRegion() {
		return nomRegion;
	}


	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomRegion=\"").append(nomRegion).append('"')
		.append("}");
		return vStB.toString();
	}
}
