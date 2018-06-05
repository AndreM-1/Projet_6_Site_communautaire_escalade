package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.photo.Photo;
import com.escalade.siteweb.model.exception.FunctionalException;

public interface PhotoManager {

	List<Photo> getListPhoto();

	void insertPhotoUtilisateur(String nomPhoto, int utilisateurId) throws FunctionalException;

	void insertPhotoSite(String nomPhoto, int siteId) throws FunctionalException;

}