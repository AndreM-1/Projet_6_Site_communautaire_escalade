package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.model.bean.site.Voie;

public class VoieRM implements RowMapper<Voie> {

	@Override
	public Voie mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Voie vVoie = new Voie(pRS.getInt("id"));
		vVoie.setNomVoie(pRS.getString("nom_Voie"));
		vVoie.setCotation(pRS.getString("cotation"));
		vVoie.setHauteur(pRS.getString("hauteur"));
		vVoie.setNbPoints(pRS.getString("nb_points"));
		vVoie.setDuree(pRS.getString("duree"));
		return vVoie;
	}
}