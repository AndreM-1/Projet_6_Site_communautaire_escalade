package com.escalade.siteweb.consumer.impl.rowmapper.photo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.model.bean.photo.Photo;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Photo}
 * @author André Monnier
 */
public class PhotoRM implements RowMapper<Photo> {

	@Override
	public Photo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Photo vPhoto = new Photo(pRS.getInt("id"));
		vPhoto.setNomPhoto(pRS.getString("nom_photo"));
		return vPhoto;
	}
}