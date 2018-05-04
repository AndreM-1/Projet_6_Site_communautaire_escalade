package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.model.bean.site.Region;

public class RegionRM implements RowMapper<Region> {

	@Override
	public Region mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Region vRegion = new Region(pRS.getInt("id"));
		vRegion.setNomRegion(pRS.getString("nom_region"));
		return vRegion;
	}
}