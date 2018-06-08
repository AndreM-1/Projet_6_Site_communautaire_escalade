package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.VoieDao;
import com.escalade.siteweb.model.bean.site.Secteur;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Secteur}
 * @author André Monnier
 */
public class SecteurRM implements RowMapper<Secteur> {
	
	private PhotoDao photoDao;
	private VoieDao voieDao;
	
	public SecteurRM(PhotoDao photoDao,VoieDao voieDao) {
		this.photoDao=photoDao;
		this.voieDao=voieDao;
	}
	
	@Override
	public Secteur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Secteur vSecteur = new Secteur(pRS.getInt("id"));
		vSecteur.setNomSecteur(pRS.getString("nom_secteur"));
		if(photoDao.getListPhotoSecteur(pRS.getInt("id"))!=null)
			vSecteur.setListPhotoSecteur(photoDao.getListPhotoSecteur(pRS.getInt("id")));
		if(voieDao.getListVoie(pRS.getInt("id"))!=null)
			vSecteur.setListVoie(voieDao.getListVoie(pRS.getInt("id")));
		return vSecteur;
	}
}