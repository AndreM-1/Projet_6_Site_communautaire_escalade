package com.escalade.siteweb.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;
import com.escalade.siteweb.model.exception.NotFoundException;

public class FormulaireContactRM implements RowMapper<FormulaireContact> {
	
	private UtilisateurDao utilisateurDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(FormulaireContactRM.class);
	
	public FormulaireContactRM(UtilisateurDao utilisateurDao) {
		this.utilisateurDao=utilisateurDao;
	}

	@Override
	public FormulaireContact mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		FormulaireContact vFormulaireContact = new FormulaireContact(pRS.getInt("id"));
		vFormulaireContact.setNomNa(pRS.getString("nom_na"));
		vFormulaireContact.setAdresseMailNa(pRS.getString("adresse_mail_na"));
		vFormulaireContact.setObjet(pRS.getString("objet"));
		vFormulaireContact.setMessage(pRS.getString("message"));
		
		try {
			vFormulaireContact.setUtilisateur(utilisateurDao.getUtilisateur(pRS.getInt("utilisateur_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		vFormulaireContact.setDateFormContact(pRS.getTimestamp("date_form_contact"));
		return vFormulaireContact;
	}
}