package com.escalade.siteweb.consumer.contract.dao;

import java.util.Date;
import java.util.List;


import com.escalade.siteweb.model.bean.site.Commentaire;

/**
 * Dao du package « Commentaire »
 * @author André Monnier
 */
public interface CommentaireDao {

	/**
	 * Méthode permettant de renvoyer la liste des commentaires.
	 * @return List
	 */
	List<Commentaire> getListCommentaire();
	
	/**
	 * Méthode permettant de renvoyer la liste des commentaires pour un site donné
	 * en commençant par le commentaire le plus récent.
	 * @param siteId : L'identifiant du site
	 * @return List
	 */
	List<Commentaire> getListCommentaire(int siteId);

	/**
	 * Méthode permettant d'insérer des commentaires de l'utilisateur pour un site donné.
	 * @param commentaire : Commentaire de l'utilisateur
	 * @param utilisateurId : Identifiant de l'utilisateur
	 * @param siteId : Identifiant du site
	 * @param date : Date du commentaire
	 */
	void insertCommentaire(String commentaire, int utilisateurId, int siteId, Date date);
}