package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.model.bean.site.Departement;

public class DepartementRM implements RowMapper<Departement> {

	@Override
	public Departement mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Departement vDepartement = new Departement(pRS.getInt("id"));
		vDepartement.setNomDepartement(pRS.getString("nom_departement"));
		return vDepartement;
	}
}