package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface SiteDao {

	List<Site> getListSite();

	Site getSite(int siteId) throws NotFoundException;

	List<Site> getListSite(int utilisateurId) throws NotFoundException;

	void insertSite(Site site) throws Exception;

	int getCountNbSite();

}
