package com.escalade.siteweb.consumer.contract.dao;

import java.util.Date;
import java.util.List;


import com.escalade.siteweb.model.bean.site.Commentaire;

public interface CommentaireDao {

	List<Commentaire> getListCommentaire();

	List<Commentaire> getListCommentaire(int siteId);

	void insertCommentaire(String commentaire, int utilisateurId, int siteId, Date date);

}
