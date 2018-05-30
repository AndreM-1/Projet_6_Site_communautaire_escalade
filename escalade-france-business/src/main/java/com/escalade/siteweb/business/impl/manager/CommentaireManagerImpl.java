package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
	
	
	@Override
	public void insertCommentaire(String commentaire, int utilisateurId, int siteId, Date date) {
		TransactionTemplate vTransactionTemplate=new TransactionTemplate(getPlatformTransactionManager());
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
				getDaoFactory().getCommentaireDao().insertCommentaire(commentaire, utilisateurId,siteId,date);	
			}   
		});
	}
}