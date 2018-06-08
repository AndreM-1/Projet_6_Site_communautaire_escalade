package com.escalade.siteweb.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.model.bean.site.Commentaire;
import com.escalade.siteweb.model.exception.NotFoundException;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Commentaire}
 * @author André Monnier
 */
public class CommentaireRM implements RowMapper<Commentaire> {
	
	private UtilisateurDao utilisateurDao;
	
	public CommentaireRM(UtilisateurDao utilisateurDao) {
		this.utilisateurDao=utilisateurDao;
	}

	@Override
	public Commentaire mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Commentaire vCommentaire = new Commentaire(pRS.getInt("id"));
		vCommentaire.setCommentaire(pRS.getString("commentaire"));
		try {
			vCommentaire.setUtilisateur(utilisateurDao.getUtilisateur(pRS.getInt("utilisateur_id")));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return vCommentaire;
	}
}