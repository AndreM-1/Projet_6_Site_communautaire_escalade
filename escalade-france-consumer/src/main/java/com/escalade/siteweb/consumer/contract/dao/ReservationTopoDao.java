package com.escalade.siteweb.consumer.contract.dao;

import java.util.Date;
import java.util.List;

import com.escalade.siteweb.model.bean.site.ReservationTopo;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface ReservationTopoDao {

	void insertReservationTopo(Date dateDeDebut, String heureDeDebut, Date dateDeFin, String heureDeFin, int utilisateurId, int siteId,
			Date dateReservation);

	List<ReservationTopo> getListReservationTopo();

	List<ReservationTopo> getListReservationTopo(int siteId) throws NotFoundException;
}