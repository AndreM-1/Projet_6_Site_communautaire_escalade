package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.escalade.siteweb.consumer.contract.dao.FormulaireContactDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.impl.rowmapper.utilisateur.FormulaireContactRM;
import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;


@Named
public class FormulaireContactDaoImpl extends AbstractDaoImpl implements FormulaireContactDao{
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	@Override
	public List<FormulaireContact> getListFormulaireContact() {
        String vSQL = "SELECT * FROM public.formulaire_contact ORDER BY date_form_contact DESC";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<FormulaireContact> vRowMapper=new FormulaireContactRM(utilisateurDao);

        List<FormulaireContact> vListFormulaireContact = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListFormulaireContact;
    }
	
	@Override
	public void insertFormulaireContact(FormulaireContact formulaireContact, Boolean bUtil) {
		String vSQL="";
		
		if(!bUtil)
			vSQL="INSERT INTO public.formulaire_contact(nom_na,adresse_mail_na,objet,message,date_form_contact) VALUES (:nomNa,:adresseMailNa,:objet,:message,:dateFormContact)";
		else
			vSQL="INSERT INTO public.formulaire_contact(objet,message,utilisateur_id,date_form_contact) VALUES (:objet,:message,:utilisateur.id,:dateFormContact)";
				
		SqlParameterSource vParams=new BeanPropertySqlParameterSource(formulaireContact);
		NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vSQL,vParams);
	}
}