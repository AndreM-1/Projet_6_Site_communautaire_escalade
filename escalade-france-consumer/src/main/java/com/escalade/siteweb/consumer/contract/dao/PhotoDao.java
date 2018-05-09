package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.photo.Photo;

public interface PhotoDao {

	List<Photo> getListPhoto();

	Photo getPhotoSite(int siteId);

	List<Photo> getListPhotoSecteur(int siteId);

	Photo getPhotoUtilisateur(int utilisateurId);

}
