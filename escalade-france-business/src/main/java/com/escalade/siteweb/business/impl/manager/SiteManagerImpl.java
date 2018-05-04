package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.SiteManager;
import com.escalade.siteweb.model.bean.site.Site;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {
	
	private List<Site> listSite = new ArrayList<>();

	@Override
	public List<Site> getListSite() {
		listSite=getDaoFactory().getSiteDao().getListSite();
		return this.listSite;
	}
}