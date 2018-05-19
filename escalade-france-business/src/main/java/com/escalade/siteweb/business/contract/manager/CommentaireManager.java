package com.escalade.siteweb.business.contract.manager;

import java.util.Date;
import java.util.List;


import com.escalade.siteweb.model.bean.site.Commentaire;

public interface CommentaireManager {

	List<Commentaire> getListCommentaire();

	void insertCommentaire(String commentaire, int utilisateurId, int siteId, Date date);

}
