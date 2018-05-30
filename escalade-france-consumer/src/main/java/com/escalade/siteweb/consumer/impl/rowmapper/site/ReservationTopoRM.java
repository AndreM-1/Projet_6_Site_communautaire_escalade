package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.model.bean.site.ReservationTopo;
import com.escalade.siteweb.model.exception.NotFoundException;

public class ReservationTopoRM implements RowMapper<ReservationTopo>{

	private UtilisateurDao utilisateurDao;
	
	public ReservationTopoRM(UtilisateurDao utilisateurDao) {
		this.utilisateurDao=utilisateurDao;
	}

	@Override
	public ReservationTopo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		ReservationTopo vReservationTopo = new ReservationTopo(pRS.getInt("id"));
		vReservationTopo.setDateDeDebut(pRS.getDate("date_de_debut"));
		vReservationTopo.setHeureDeDebut(pRS.getString("heure_de_debut"));
		vReservationTopo.setDateDeFin(pRS.getDate("date_de_fin"));
		vReservationTopo.setHeureDeFin(pRS.getString("heure_de_fin"));
		try {
			vReservationTopo.setUtilisateur(utilisateurDao.getUtilisateur(pRS.getInt("utilisateur_id")));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		vReservationTopo.setDateReservation(pRS.getTimestamp("date_reservation"));
		return vReservationTopo;
	}
}
