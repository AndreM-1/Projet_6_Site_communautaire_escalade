package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface RegionManager {

	List<Region> getListRegion();

	List<Region> getListRegion(int paysId);

	Region getRegion(int regionId) throws NotFoundException;

}
