package com.escalade.siteweb.model.bean.site;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Classe du modèle lié au bean Pays.
 * @author André Monnier
 */
public class Pays implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
	private Integer id;
	
	@NotEmpty (message="Model - L'attribut nomPays doit être renseigné")
	@Size (min=1,max=20,message="Model - L'attribut nomPays ne doit pas comporter plus de 20 caractères")
	private String nomPays;

	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Pays() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Pays(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomPays() {
		return nomPays;
	}


	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}


	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomPays=\"").append(nomPays).append('"')
		.append("}");
		return vStB.toString();
	}
}
