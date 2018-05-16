package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.CommentaireDao;
import com.escalade.siteweb.consumer.contract.dao.DepartementDao;
import com.escalade.siteweb.consumer.contract.dao.PaysDao;
import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.RegionDao;
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
	
	public SiteRM(UtilisateurDao utilisateurDao, PaysDao paysDao, RegionDao regionDao, DepartementDao departementDao,PhotoDao photoDao,
			CommentaireDao commentaireDao,SecteurDao secteurDao) {
		this.utilisateurDao=utilisateurDao;
		this.paysDao=paysDao;
		this.regionDao=regionDao;
		this.departementDao=departementDao;
		this.photoDao=photoDao;
		this.commentaireDao=commentaireDao;
		this.secteurDao=secteurDao;
	}

	@Override
	public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Site vSite = new Site(pRS.getInt("id"));
		vSite.setNomSite(pRS.getString("nom_site"));
		vSite.setDescriptif(pRS.getString("descriptif"));
		vSite.setCommentairePersonnel(pRS.getString("commentaire_personnel"));
		vSite.setTopoDisponible(pRS.getBoolean("topo_disponible"));
		vSite.setDateDeDebut(pRS.getDate("date_de_debut"));
		vSite.setDateDeFin(pRS.getDate("date_de_fin"));
		vSite.setDateAjoutSite(pRS.getTimestamp("date_ajout_site"));
		vSite.setDateMajSite(pRS.getTimestamp("date_maj_site"));
		try {
			vSite.setUtilisateur(utilisateurDao.getUtilisateur(pRS.getInt("utilisateur_id")));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		vSite.setPays(paysDao.getPays(pRS.getInt("pays_id")));
		vSite.setRegion(regionDao.getRegion(pRS.getInt("region_id")));
		vSite.setDepartement(departementDao.getDepartement(pRS.getInt("departement_id")));
		
		if(photoDao.getPhotoSite(pRS.getInt("id"))!=null)
			vSite.setPhotoSite(photoDao.getPhotoSite(pRS.getInt("id")));
		
		if(photoDao.getListPhotoAllSecteur(pRS.getInt("id"))!=null)
			vSite.setListPhotoAllSecteur(photoDao.getListPhotoAllSecteur(pRS.getInt("id")));
		
		if(commentaireDao.getListCommentaire(pRS.getInt("id"))!=null)
			vSite.setListCommentaire(commentaireDao.getListCommentaire(pRS.getInt("id")));
		
		if(secteurDao.getListSecteur(pRS.getInt("id"))!=null)
			vSite.setListSecteur(secteurDao.getListSecteur(pRS.getInt("id")));
		
		return vSite;
	}
}