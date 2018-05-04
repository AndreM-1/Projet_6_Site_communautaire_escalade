package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.PhotoManager;
import com.escalade.siteweb.model.bean.photo.Photo;

@Named
public class PhotoManagerImpl extends AbstractManager implements PhotoManager{

	private List<Photo> listPhoto = new ArrayList<>();

	@Override
	public List<Photo> getListPhoto() {
		listPhoto=getDaoFactory().getPhotoDao().getListPhoto();
		return this.listPhoto;
	}
}