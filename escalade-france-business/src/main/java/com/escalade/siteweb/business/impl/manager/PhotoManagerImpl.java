package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.escalade.siteweb.business.contract.manager.PhotoManager;
import com.escalade.siteweb.model.bean.photo.Photo;
import com.escalade.siteweb.model.exception.FunctionalException;

@Named
public class PhotoManagerImpl extends AbstractManager implements PhotoManager{

	private List<Photo> listPhoto = new ArrayList<>();

	@Override
	public List<Photo> getListPhoto() {
		listPhoto=getDaoFactory().getPhotoDao().getListPhoto();
		return this.listPhoto;
	}
	
	@Override
	public void insertPhotoUtilisateur(String nomPhoto, int utilisateurId) throws FunctionalException {
		
		//Utilisation d'un TransactionStatus. On a besoin de lever une FunctionalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			getDaoFactory().getPhotoDao().insertPhotoUtilisateur(nomPhoto,utilisateurId);
		} catch (FunctionalException vEx) {
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new FunctionalException("Couche Business - L'utilisateur a déjà une photo en base de données");
		}
		getPlatformTransactionManager().commit(vTransactionStatus);
	}
}