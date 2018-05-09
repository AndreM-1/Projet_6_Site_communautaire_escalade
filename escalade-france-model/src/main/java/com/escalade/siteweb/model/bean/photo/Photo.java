package com.escalade.siteweb.model.bean.photo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Photo {
	
	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut nomPhoto doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nomPhoto ne doit pas comporter plus de 100 caractères")
	private String nomPhoto;
	private String cheminImage="jsp/assets/images/";

	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Photo() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Photo(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomPhoto() {
		return nomPhoto;
	}


	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = cheminImage+nomPhoto+".jpg";
	}
	

	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomPhoto=\"").append(nomPhoto).append('"')
		.append("}");
		return vStB.toString();
	}

}
