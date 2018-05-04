package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.model.bean.site.Commentaire;

public class CommentaireRM implements RowMapper<Commentaire> {

	@Override
	public Commentaire mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Commentaire vCommentaire = new Commentaire(pRS.getInt("id"));
		vCommentaire.setCommentaire(pRS.getString("commentaire"));
		return vCommentaire;
	}
}