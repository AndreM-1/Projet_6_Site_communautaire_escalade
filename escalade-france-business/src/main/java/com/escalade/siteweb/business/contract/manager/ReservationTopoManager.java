package com.escalade.siteweb.business.contract.manager;

import java.util.Date;
import java.util.List;

import com.escalade.siteweb.model.bean.site.ReservationTopo;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

public interface ReservationTopoManager {

	void insertReservationTopo(Date dateDeDebut, String heureDeDebut, Date dateDeFin, String heureDeFin, int utilisateurId, int siteId,
			Date dateReservation) throws FunctionalException,TechnicalException;

	List<ReservationTopo> getListReservationTopo();

	List<ReservationTopo> getListReservationTopo(int siteId) throws NotFoundException;
}