package com.escalade.siteweb.model.bean.site;

import java.util.Date;

import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;

/**
 * Classe du modèle lié au bean ReservationTopo.
 * @author André Monnier
 */
public class ReservationTopo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
	private Integer id;

	private Date dateDeDebut;
	
	private String heureDeDebut;
	
	private Date dateDeFin;
	
	private String heureDeFin;
	
	private Utilisateur utilisateur;
	
	private Date dateReservation;


	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public ReservationTopo() {
	}


	/**
	 * Constructeur.
	 *
	 * @param pId -
	 */
	public ReservationTopo(Integer pId) {
		id = pId;
	}


	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDateDeDebut() {
		return dateDeDebut;
	}


	public void setDateDeDebut(Date dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}


	public String getHeureDeDebut() {
		return heureDeDebut;
	}


	public void setHeureDeDebut(String heureDeDebut) {
		this.heureDeDebut = heureDeDebut;
	}


	public Date getDateDeFin() {
		return dateDeFin;
	}


	public void setDateDeFin(Date dateDeFin) {
		this.dateDeFin = dateDeFin;
	}


	public String getHeureDeFin() {
		return heureDeFin;
	}


	public void setHeureDeFin(String heureDeFin) {
		this.heureDeFin = heureDeFin;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Date getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	

	// ==================== Méthodes ====================
	@Override
	public String toString() {
		final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
		final String vSeparateur = ", ";
		vStB.append(" {")
		.append("id=").append(id)
		.append(vSeparateur).append("dateDeDebut=\"").append(dateDeDebut).append('"')
		.append(vSeparateur).append("heureDeDebut=\"").append(heureDeDebut).append('"')
		.append(vSeparateur).append("dateDeFin=\"").append(dateDeFin).append('"')
		.append(vSeparateur).append("heureDeFin=\"").append(heureDeFin).append('"')
		.append(vSeparateur).append("utilisateurId=\"").append(utilisateur.getId()).append('"')
		.append(vSeparateur).append("dateReservation=\"").append(dateReservation).append('"')
		.append("}");
		return vStB.toString();
	}


	
}
