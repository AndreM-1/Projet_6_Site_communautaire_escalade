package com.escalade.siteweb.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;

public class FormulaireContactRM implements RowMapper<FormulaireContact> {

	@Override
	public FormulaireContact mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		FormulaireContact vFormulaireContact = new FormulaireContact(pRS.getInt("id"));
		vFormulaireContact.setNomNa(pRS.getString("nom_na"));
		vFormulaireContact.setAdresseMailNa(pRS.getString("adresse_mail_na"));
		vFormulaireContact.setObjet(pRS.getString("objet"));
		vFormulaireContact.setMessage(pRS.getString("message"));
		return vFormulaireContact;
	}
}