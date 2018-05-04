package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.model.bean.site.Site;

public class SiteRM implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Site vSite = new Site(pRS.getInt("id"));
		vSite.setNomSite(pRS.getString("nom_site"));
		vSite.setDescriptif(pRS.getString("descriptif"));
		vSite.setCommentairePersonnel(pRS.getString("commentaire_personnel"));
		vSite.setTopoDisponible(pRS.getBoolean("topo_disponible"));
		vSite.setDateDeDebut(pRS.getDate("date_de_debut"));
		vSite.setDateDeFin(pRS.getDate("date_de_fin"));
		vSite.setDateAjoutSite(pRS.getDate("date_ajout_site"));
		vSite.setDateMajSite(pRS.getDate("date_maj_site"));
		return vSite;
	}
}