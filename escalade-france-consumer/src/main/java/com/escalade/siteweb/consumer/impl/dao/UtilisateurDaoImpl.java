package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;


@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

	@Override
	public List<Utilisateur> getListUtilisateur() {
        String vSQL = "SELECT * FROM public.utilisateur";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Utilisateur> vRowMapper=new UtilisateurRM();

        List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListUtilisateur;
    }
}