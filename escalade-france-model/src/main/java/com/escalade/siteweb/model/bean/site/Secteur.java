package com.escalade.siteweb.model.bean.site;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.escalade.siteweb.model.bean.photo.Photo;

public class Secteur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut nomSecteur doit être renseigné")
	@NotBlank(message="Model - L'attribut nomSecteur doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nomSecteur ne doit pas comporter plus de 100 caractères")
	private String nomSecteur;
	
	private List<Photo> listPhotoSecteur;
	
	private List<Voie> listVoie;

	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Secteur() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Secteur(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomSecteur() {
		return nomSecteur;
	}


	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}
	
	public List<Photo> getListPhotoSecteur() {
		return listPhotoSecteur;
	}


	public void setListPhotoSecteur(List<Photo> listPhotoSecteur) {
		this.listPhotoSecteur = listPhotoSecteur;
	}


	public List<Voie> getListVoie() {
		return listVoie;
	}


	public void setListVoie(List<Voie> listVoie) {
		this.listVoie = listVoie;
	}

	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomSecteur=\"").append(nomSecteur).append('"')
		.append(vSeparateur).append("listPhotoSecteur=\"").append(listPhotoSecteur).append('"')
		.append(vSeparateur).append("listVoie=\"").append(listVoie).append('"')
		.append("}");
		return vStB.toString();
	}
}