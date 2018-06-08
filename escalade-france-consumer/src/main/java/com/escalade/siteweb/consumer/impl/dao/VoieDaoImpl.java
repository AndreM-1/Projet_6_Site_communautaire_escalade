package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.VoieDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.VoieRM;
import com.escalade.siteweb.model.bean.site.Voie;

@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao{
	

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(VoieDaoImpl.class);
	
	@Override
	public List<Voie> getListVoie() {
        String vSQL = "SELECT * FROM public.voie";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Voie> vRowMapper=new VoieRM();

        List<Voie> vListVoie = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListVoie;
    }
	
	@Override
	public List<Voie> getListVoie(int secteurId) {
        String vSQL = "SELECT * FROM public.voie WHERE secteur_id="+secteurId;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Voie> vRowMapper=new VoieRM();

        List<Voie> vListVoie = vJdbcTemplate.query(vSQL, vRowMapper);
        
        if(vListVoie.size()!=0)	
        	return vListVoie;
        else
        	return null;
    }
	
	@Override
	public void insertVoie(Voie voie, int secteurId) throws Exception{
		String vSQL="INSERT INTO public.voie(nom_voie,cotation,hauteur,nb_points,duree,secteur_id) VALUES (?,?,?,?,?,?)";
				
		JdbcTemplate vJdbcTemplate=new JdbcTemplate(getDataSource());
		LOGGER.info("Appel à la méthode insertVoie");
		
		try {
			vJdbcTemplate.update(vSQL,voie.getNomVoie(),voie.getCotation(),voie.getHauteur(),voie.getNbPoints(),voie.getDuree(),secteurId);
		} catch (Exception e) {
			LOGGER.info("Consumer - Méthode insertVoie : Erreur technique lors de l'ajout de voies en BDD.");
			throw new Exception("Erreur technique lors de l'ajout de voies en BDD.");
		}
	}
}