package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.RegionManager;
import com.escalade.siteweb.model.bean.site.Region;

@Named
public class RegionManagerImpl extends AbstractManager implements RegionManager {
	
	private List<Region> listRegion = new ArrayList<>();

	@Override
	public List<Region> getListRegion() {
		listRegion=getDaoFactory().getRegionDao().getListRegion();
		return this.listRegion;
	}
}