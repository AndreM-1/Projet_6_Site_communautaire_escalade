package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.SecteurDao;
import com.escalade.siteweb.consumer.contract.dao.VoieDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.SecteurRM;
import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.exception.NotFoundException;


@Named
public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

	@Inject
	private PhotoDao photoDao;

	@Inject
	private VoieDao voieDao;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SecteurDaoImpl.class);
	
	@Override
	public List<Secteur> getListSecteur() {
		String vSQL = "SELECT * FROM public.secteur";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 

		RowMapper<Secteur> vRowMapper=new SecteurRM(photoDao,voieDao);

		List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListSecteur;
	}

	@Override
	public List<Secteur> getListSecteur(int siteId) throws NotFoundException {
		String vSQL = "SELECT * FROM public.secteur WHERE site_id="+siteId;

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 

		RowMapper<Secteur> vRowMapper=new SecteurRM(photoDao,voieDao);

		List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, vRowMapper);

		if(vListSecteur.size()!=0)
			return vListSecteur;
		else
			throw new NotFoundException("Consumer - Ce site n'a pas encore de secteurs.");
	}

	@Override
	public void insertSecteur(String nomSecteur, int siteId) throws Exception {

		JdbcTemplate vJdbcTemplate=new JdbcTemplate(getDataSource());
		LOGGER.info("Appel à la méthode insertSecteur");
		
		try {
			vJdbcTemplate.update("INSERT INTO public.secteur(nom_secteur,site_id) VALUES(?,?)", nomSecteur,siteId);
		} catch (Exception e) {
			LOGGER.info("Consumer - Méthode insertSecteur : Erreur technique lors de l'ajout de secteurs en BDD.");
			throw new Exception("Erreur technique lors de l'ajout de secteurs en BDD.");
		}

	}
}