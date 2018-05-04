package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.SecteurDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.SecteurRM;
import com.escalade.siteweb.model.bean.site.Secteur;

@Named
public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {
	
	@Override
	public List<Secteur> getListSecteur() {
        String vSQL = "SELECT * FROM public.secteur";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Secteur> vRowMapper=new SecteurRM();

        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListSecteur;
    }
}