package com.escalade.siteweb.model.bean.site;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Secteur {

	// ==================== Attributs ====================
	private Integer id;

	@NotEmpty (message="Model - L'attribut nomSecteur doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nomSecteur ne doit pas comporter plus de 100 caractères")
	private String nomSecteur;

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


	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("nomSecteur=\"").append(nomSecteur).append('"')
		.append("}");
		return vStB.toString();
	}
}