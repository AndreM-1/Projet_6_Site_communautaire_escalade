package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface SiteManager {

	List<Site> getListSite();

	Site getSite(int siteId) throws NotFoundException;

}
