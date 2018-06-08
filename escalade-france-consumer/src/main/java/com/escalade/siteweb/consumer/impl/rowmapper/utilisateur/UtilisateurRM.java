package com.escalade.siteweb.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Utilisateur}
 * @author André Monnier
 */
public class UtilisateurRM implements RowMapper<Utilisateur>{
	
	private PhotoDao photoDao;
	
	public UtilisateurRM(PhotoDao photoDao) {
		this.photoDao=photoDao;
	}

	@Override
	public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Utilisateur vUtilisateur = new Utilisateur(pRS.getInt("id"));
		vUtilisateur.setCivilite(pRS.getString("civilite"));
		vUtilisateur.setNom(pRS.getString("nom"));
		vUtilisateur.setPrenom(pRS.getString("prenom"));
		vUtilisateur.setPseudo(pRS.getString("pseudo"));
		vUtilisateur.setAdresseMail(pRS.getString("adresse_mail"));
		vUtilisateur.setSalt(pRS.getString("salt"));
		vUtilisateur.setMotDePasseSecurise(pRS.getString("mot_de_passe_securise"));
		vUtilisateur.setTelephone(pRS.getString("telephone"));
		vUtilisateur.setDateNaissance(pRS.getDate("date_naissance"));
		vUtilisateur.setAdresse(pRS.getString("adresse"));
		vUtilisateur.setCodePostal(pRS.getString("code_postal"));
		vUtilisateur.setVille(pRS.getString("ville"));
		vUtilisateur.setPays(pRS.getString("pays"));
		vUtilisateur.setAdministrateur(pRS.getBoolean("administrateur"));
		if(photoDao.getPhotoUtilisateur(pRS.getInt("id"))!=null)
			vUtilisateur.setPhotoUtilisateur(photoDao.getPhotoUtilisateur(pRS.getInt("id")));
		return vUtilisateur;
	}
}