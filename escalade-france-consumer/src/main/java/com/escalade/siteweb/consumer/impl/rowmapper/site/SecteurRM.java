package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.model.bean.site.Secteur;

public class SecteurRM implements RowMapper<Secteur> {
	
	@Override
	public Secteur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Secteur vSecteur = new Secteur(pRS.getInt("id"));
		vSecteur.setNomSecteur(pRS.getString("nom_secteur"));
		return vSecteur;
	}
}