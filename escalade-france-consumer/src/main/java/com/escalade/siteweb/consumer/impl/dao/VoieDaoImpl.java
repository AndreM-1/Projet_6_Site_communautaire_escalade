package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.VoieDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.VoieRM;
import com.escalade.siteweb.model.bean.site.Voie;

@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao{
	
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
}