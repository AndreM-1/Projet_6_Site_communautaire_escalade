package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Secteur;

public interface SecteurDao {

	List<Secteur> getListSecteur();

	List<Secteur> getListSecteur(int siteId);

	void insertSecteur(String nomSecteur, int siteId);

}
