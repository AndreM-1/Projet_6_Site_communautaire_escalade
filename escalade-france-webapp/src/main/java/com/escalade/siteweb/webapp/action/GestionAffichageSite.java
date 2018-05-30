package com.escalade.siteweb.webapp.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Commentaire;
import com.escalade.siteweb.model.bean.site.ReservationTopo;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;
import com.opensymphony.xwork2.ActionSupport;

public class GestionAffichageSite extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres en entrée
	private Integer id;
	private Commentaire commentaire;
	private Date dateDeDebut;
	private Date dateDeFin;
	private String heureDeDebut;
	private String heureDeFin;
	private ReservationTopo reservationTopo;


	// ----- Eléments en entrée et sortie
	private Site site;

	// ----- Eléments Struts
	private Map<String, Object> session;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAffichageSite.class);


	// ===================== Getters/Setters ===============
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
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
	
	public ReservationTopo getReservationTopo() {
		return reservationTopo;
	}

	public void setReservationTopo(ReservationTopo reservationTopo) {
		this.reservationTopo = reservationTopo;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;

	}

	// ===================== Méthodes ======================

	/**
	 * Action affichant les détails d'un {@link Site}
	 * @return success / error
	 */
	public String doDetailSite() {
		if (id == null) {
			this.addActionError("L'id du site est manquant.");
		} else {
			try {
				site=managerFactory.getSiteManager().getSite(id);
			} catch (NotFoundException pEx) {
				this.addActionError("Site non trouvé. ID= "+id);
			}
		}
		return (this.hasErrors())?ActionSupport.ERROR:ActionSupport.SUCCESS;
	}

	/**
	 * Action permettant d'ajouter un {@link Commentaire}
	 * @return success
	 */
	public String doAjoutCommentaire() {
		String vResult = ActionSupport.SUCCESS;
		Utilisateur utilisateur=(Utilisateur)session.get("user");
		commentaire.setDateCommentaire(new Date());
		LOGGER.info("Pseudo :"+ utilisateur.getPseudo());
		LOGGER.info("Commentaire :"+commentaire.getCommentaire());
		LOGGER.info("Utilisateur_id :"+ utilisateur.getId());
		LOGGER.info("Site.id :"+site.getId());

		if(commentaire.getCommentaire().trim().length()!=0)
			managerFactory.getCommentaireManager().insertCommentaire(commentaire.getCommentaire(),utilisateur.getId(),site.getId(), commentaire.getDateCommentaire());

		return vResult;

	}

	public String doReservationTopo(){
		String vResult=ActionSupport.SUCCESS;
		if(reservationTopo.getDateDeDebut()!=null && reservationTopo.getDateDeFin()!=null) {
			Utilisateur utilisateur=(Utilisateur)session.get("user");
			SimpleDateFormat formater=new SimpleDateFormat("dd-MM-yyyy");
			LOGGER.info("Méthode doReservationTopo - Date de début (format par défaut) : "+reservationTopo.getDateDeDebut());
			LOGGER.info("Méthode doReservationTopo - Date de fin (format par défaut) : "+reservationTopo.getDateDeFin());
			LOGGER.info("Méthode doReservationTopo - Date de début (format personnalisé) : "+formater.format(reservationTopo.getDateDeDebut()));
			LOGGER.info("Méthode doReservationTopo - Date de fin (format personnalisé) : "+formater.format(reservationTopo.getDateDeFin()));
			LOGGER.info("Méthode doReservationTopo - Heure de début : "+reservationTopo.getHeureDeDebut());
			LOGGER.info("Méthode doReservationTopo - Heure de fin : "+reservationTopo.getHeureDeFin());
			LOGGER.info("Méthode doReservationTopo - Utilisateur Id en session (celui qui réserve la topo) :"+utilisateur.getId());
			reservationTopo.setDateReservation(new Date());
			LOGGER.info("Méthode doReservationTopo - Site Id :"+site.getId());
			try {
				managerFactory.getReservationTopoManager().insertReservationTopo(reservationTopo.getDateDeDebut(),reservationTopo.getHeureDeDebut(),reservationTopo.getDateDeFin(),
						reservationTopo.getHeureDeFin(),utilisateur.getId(),site.getId(),reservationTopo.getDateReservation());
			} catch (FunctionalException fEx) {
				LOGGER.info(fEx.getMessage());
				this.addActionError(fEx.getMessage());
				
			} catch(TechnicalException tEx) {
				LOGGER.info(tEx.getMessage());
				this.addActionError(tEx.getMessage());
				vResult="error";
			}
		} else {
			LOGGER.info("Veuillez renseigner les champs date de début et date de fin.");
			this.addActionError("Veuillez renseigner les champs date de début et date de fin.");
		}
		return vResult;
	}

}