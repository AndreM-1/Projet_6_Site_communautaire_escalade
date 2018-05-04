package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.escalade.siteweb.model.bean.site.Pays;


public class PaysRM implements RowMapper<Pays>{
	
	@Override
	public Pays mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Pays vPays = new Pays(pRS.getInt("id"));
		vPays.setNomPays(pRS.getString("nom_pays"));
		return vPays;
	}
}