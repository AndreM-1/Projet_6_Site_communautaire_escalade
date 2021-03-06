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

/**
 * Classe d'action permettant d'afficher le détail d'un site,
 * de gérer l'ajout de commentaires et la réservation de topo.
 * @author André Monnier
 */
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
	 * Méthode affichant les détails d'un {@link Site}
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
	 * Méthode permettant d'ajouter un {@link Commentaire}
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

	/**
	 * Méthode permettant de gérer la réservation
	 * de topo pour un site donné.
	 * @return input / success / error
	 */
	public String doReservationTopo(){
		
		String vResult=ActionSupport.INPUT;
		
		if(site.getId()!=null) {
			try {
				site.setListReservationTopo(managerFactory.getReservationTopoManager().getListReservationTopo(site.getId()));
			} catch (NotFoundException e) {
				LOGGER.info("Pas de réservation de topo pour ce site");
			}
		}else {
			this.addActionError("L'id du site est manquant.");
			vResult="error";
		}
				
		if(reservationTopo!=null) {
			if(reservationTopo.getDateDeDebut()!=null && reservationTopo.getDateDeFin()!=null) {
				vResult=ActionSupport.SUCCESS;
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
					vResult=ActionSupport.INPUT;

				} catch(TechnicalException tEx) {
					LOGGER.info(tEx.getMessage());
					this.addActionError(tEx.getMessage());
					vResult="error";
				}
			} else {
				LOGGER.info("Veuillez renseigner les champs date de début et date de fin.");
				this.addActionError("Veuillez renseigner les champs date de début et date de fin.");
			}
		}
		return vResult;
	}

}