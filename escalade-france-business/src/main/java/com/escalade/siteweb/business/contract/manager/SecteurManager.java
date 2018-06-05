package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

public interface SecteurManager {

	List<Secteur> getListSecteur();

	void insertSecteur(List<Secteur> listSecteur, int siteId) throws FunctionalException,TechnicalException;

	List<Secteur> getListSecteur(int siteId) throws NotFoundException;

}
