package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.CommentaireManager;
import com.escalade.siteweb.model.bean.site.Commentaire;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {
	
	private List<Commentaire> listCommentaire = new ArrayList<>();

	@Override
	public List<Commentaire> getListCommentaire() {
		listCommentaire=getDaoFactory().getCommentaireDao().getListCommentaire();
		return this.listCommentaire;
	}
}