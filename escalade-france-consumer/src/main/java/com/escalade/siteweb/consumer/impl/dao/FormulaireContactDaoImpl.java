package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.FormulaireContactDao;
import com.escalade.siteweb.consumer.impl.rowmapper.utilisateur.FormulaireContactRM;
import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;


@Named
public class FormulaireContactDaoImpl extends AbstractDaoImpl implements FormulaireContactDao{
	
	@Override
	public List<FormulaireContact> getListFormulaireContact() {
        String vSQL = "SELECT * FROM public.formulaire_contact";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<FormulaireContact> vRowMapper=new FormulaireContactRM();

        List<FormulaireContact> vListFormulaireContact = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListFormulaireContact;
    }
}