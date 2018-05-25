package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.RegionManager;
import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class RegionManagerImpl extends AbstractManager implements RegionManager {
	
	private List<Region> listRegion = new ArrayList<>();
	private Region region;

	@Override
	public List<Region> getListRegion() {
		listRegion=getDaoFactory().getRegionDao().getListRegion();
		return this.listRegion;
	}
	
	@Override
	public List<Region> getListRegion(int paysId) {
		listRegion=getDaoFactory().getRegionDao().getListRegion(paysId);
		return this.listRegion;
	}
	
	@Override
	public Region getRegion(int regionId) throws NotFoundException {
		try {
			region=getDaoFactory().getRegionDao().getRegion(regionId);
			return region;
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - Aucune région ne correspond à l'ID demandé.");
		}
	}
}