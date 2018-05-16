package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.SiteManager;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {
	
	private List<Site> listSite = new ArrayList<>();
	private Site site;

	@Override
	public List<Site> getListSite() {
		listSite=getDaoFactory().getSiteDao().getListSite();
		return this.listSite;
	}
	
	@Override
	public Site getSite(int siteId) throws NotFoundException{
		try {
			site=getDaoFactory().getSiteDao().getSite(siteId);
			return site;
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - Aucun site ne correspond à l'ID demandé.");
		}
	}
	
	@Override
	public List<Site> getListSite(int utilisateurId) throws NotFoundException{
		try {
			listSite=getDaoFactory().getSiteDao().getListSite(utilisateurId);  
			return listSite;
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - L'utilisateur n'a pas encore posté de site.");
		}
	}
}