package com.escalade.siteweb.model.bean.utilisateur;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Utilisateur {

	// ==================== Attributs ====================
	private Integer id;
	
	@NotEmpty (message="Model - L'attribut civilite doit être renseigné")
	@Size (min=1,max=8,message="Model - L'attribut civilite ne doit pas comporter plus de 8 caractères")
	private String civilite;
	
	@NotEmpty (message="Model - L'attribut nom doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut nom ne doit pas comporter plus de 100 caractères")
	private String nom;
	
	@NotEmpty (message="Model - L'attribut prenom doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut prenom ne doit pas comporter plus de 100 caractères")
	private String prenom;
	
	@NotEmpty (message="Model - L'attribut pseudo doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut pseudo ne doit pas comporter plus de 100 caractères")
	private String pseudo;
	
	@NotEmpty (message="Model - L'attribut adresseMail doit être renseigné")
	@Email   (message="Model - Le format d'adresse mail n'est pas valide")
	@Size (min=1,max=100,message="Model - L'attribut adresseMail ne doit pas comporter plus de 100 caractères")
	private String adresseMail;
	
	@NotEmpty (message="Model - L'attribut motDePasse doit être renseigné")
	@Size (min=1,max=100,message="Model - L'attribut motDePasse ne doit pas comporter plus de 100 caractères")
	private String motDePasse;
	
	@Size(min=14, max=14, message="Model - L'attribut téléphone doit comporter 14 caractères")
	private String telephone;
	
	@Past(message="La date de naissance doit être située dans le passé")
	private Date dateNaissance;
	
	@Size (min=0,max=100,message="Model - L'attribut adresse ne doit pas comporter plus de 100 caractères")
	private String adresse;
	
	@Size (min=0,max=10,message="Model - L'attribut codePostal ne doit pas comporter plus de 10 caractères")
	private String codePostal;
	
	@Size (min=0,max=100,message="Model - L'attribut ville ne doit pas comporter plus de 100 caractères")
	private String ville;
	
	@Size (min=0,max=20,message="Model - L'attribut pays ne doit pas comporter plus de 20 caractères")
	private String pays;
	
	@NotEmpty (message="Model - L'attribut administrateur doit être renseigné")
	private Boolean administrateur;

	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public Utilisateur() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public Utilisateur(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public Boolean getAdministrateur() {
		return administrateur;
	}


	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}


	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("civilite=\"").append(civilite).append('"')
		.append(vSeparateur).append("nom=\"").append(nom).append('"')
		.append(vSeparateur).append("prenom=\"").append(prenom).append('"')
		.append(vSeparateur).append("pseudo=\"").append(pseudo).append('"')
		.append(vSeparateur).append("adresseMail=\"").append(adresseMail).append('"')
		.append(vSeparateur).append("motDePasse=\"").append(motDePasse).append('"')
		.append(vSeparateur).append("telephone=\"").append(telephone).append('"')
		.append(vSeparateur).append("dateNaissance=\"").append(dateNaissance).append('"')
		.append(vSeparateur).append("adresse=\"").append(adresse).append('"')
		.append(vSeparateur).append("codePostal=\"").append(codePostal).append('"')
		.append(vSeparateur).append("ville=\"").append(ville).append('"')
		.append(vSeparateur).append("pays=\"").append(pays).append('"')
		.append(vSeparateur).append("administrateur=\"").append(administrateur).append('"')
		.append("}");
		return vStB.toString();
	}
}