package com.escalade.siteweb.consumer.contract.dao;

import java.util.Date;
import java.util.List;

import com.escalade.siteweb.model.bean.site.ReservationTopo;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

/**
 * Dao du package « ReservationTopo »
 * @author André Monnier
 */
public interface ReservationTopoDao {

	/**
	 * Méthode permettant d'enregistrer une réservation de topo d'un utilisateur pour un site donné en BDD.
	 * @param dateDeDebut : Date de début de la réservation
	 * @param heureDeDebut : Heure de début de la réservation
	 * @param dateDeFin : Date de fin de la réservation
	 * @param heureDeFin : Heure de fin de la réservation
	 * @param utilisateurId : Identifiant de l'utilisateur
	 * @param siteId : Identifiant du site
	 * @param dateReservation : Date à laquelle la réservation a été effectuée
	 * @throws FunctionalException
	 * @throws TechnicalException
	 */
	void insertReservationTopo(Date dateDeDebut, String heureDeDebut, Date dateDeFin, String heureDeFin, int utilisateurId, int siteId,
			Date dateReservation);

	/**
	 * Méthode permettant de renvoyer la liste des réservations de topo.
	 * @return List
	 */
	List<ReservationTopo> getListReservationTopo();

	/**
	 * Méthode permettant de renvoyer la liste des réservations de topo pour un site donné.
	 * @param siteId : L'identifiant du site
	 * @return List
	 * @throws NotFoundException
	 */
	List<ReservationTopo> getListReservationTopo(int siteId) throws NotFoundException;
}