package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.CommentaireDao;
import com.escalade.siteweb.consumer.contract.dao.DepartementDao;
import com.escalade.siteweb.consumer.contract.dao.PaysDao;
import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.RegionDao;
import com.escalade.siteweb.consumer.contract.dao.ReservationTopoDao;
import com.escalade.siteweb.consumer.contract.dao.SecteurDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.NotFoundException;

public class SiteRM implements RowMapper<Site> {
	
	private UtilisateurDao utilisateurDao;
	private PaysDao paysDao;
	private RegionDao regionDao;
	private DepartementDao departementDao;
	private PhotoDao photoDao;
	private CommentaireDao commentaireDao;
	private SecteurDao secteurDao;
	private ReservationTopoDao reservationTopoDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SiteRM.class);
	
	public SiteRM(UtilisateurDao utilisateurDao, PaysDao paysDao, RegionDao regionDao, DepartementDao departementDao,PhotoDao photoDao,
			CommentaireDao commentaireDao,SecteurDao secteurDao,ReservationTopoDao reservationTopoDao) {
		this.utilisateurDao=utilisateurDao;
		this.paysDao=paysDao;
		this.regionDao=regionDao;
		this.departementDao=departementDao;
		this.photoDao=photoDao;
		this.commentaireDao=commentaireDao;
		this.secteurDao=secteurDao;
		this.reservationTopoDao=reservationTopoDao;
	}

	@Override
	public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Site vSite = new Site(pRS.getInt("id"));
		vSite.setNomSite(pRS.getString("nom_site"));
		vSite.setDescriptif(pRS.getString("descriptif"));
		vSite.setCommentairePersonnel(pRS.getString("commentaire_personnel"));
		vSite.setTopoDisponible(pRS.getBoolean("topo_disponible"));
		vSite.setDateAjoutSite(pRS.getTimestamp("date_ajout_site"));
		vSite.setDateMajSite(pRS.getTimestamp("date_maj_site"));
		try {
			vSite.setUtilisateur(utilisateurDao.getUtilisateur(pRS.getInt("utilisateur_id")));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			vSite.setPays(paysDao.getPays(pRS.getInt("pays_id")));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			vSite.setRegion(regionDao.getRegion(pRS.getInt("region_id")));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			vSite.setDepartement(departementDao.getDepartement(pRS.getInt("departement_id")));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
		if(photoDao.getPhotoSite(pRS.getInt("id"))!=null)
			vSite.setPhotoSite(photoDao.getPhotoSite(pRS.getInt("id")));
		
		if(photoDao.getListPhotoAllSecteur(pRS.getInt("id"))!=null)
			vSite.setListPhotoAllSecteur(photoDao.getListPhotoAllSecteur(pRS.getInt("id")));
		
		if(commentaireDao.getListCommentaire(pRS.getInt("id"))!=null)
			vSite.setListCommentaire(commentaireDao.getListCommentaire(pRS.getInt("id")));
		
		try {
			vSite.setListSecteur(secteurDao.getListSecteur(pRS.getInt("id")));
		} catch (NotFoundException e1) {
			LOGGER.info(e1.getMessage());
		}
		
		try {
			vSite.setListReservationTopo(reservationTopoDao.getListReservationTopo(pRS.getInt("id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		return vSite;
	}
}