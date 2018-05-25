package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

public interface SiteManager {

	List<Site> getListSite();

	Site getSite(int siteId) throws NotFoundException;

	List<Site> getListSite(int utilisateurId) throws NotFoundException;

	void insertSite(Site site, List<Secteur> listSecteur) throws FunctionalException,TechnicalException;

}
