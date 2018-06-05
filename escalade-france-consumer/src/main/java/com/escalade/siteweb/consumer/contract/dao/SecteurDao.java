package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface SecteurDao {

	List<Secteur> getListSecteur();

	List<Secteur> getListSecteur(int siteId) throws NotFoundException;

	void insertSecteur(String nomSecteur, int siteId) throws Exception;

}
