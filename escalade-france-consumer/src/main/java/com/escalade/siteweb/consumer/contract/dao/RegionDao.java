package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface RegionDao {

	List<Region> getListRegion();

	List<Region> getListRegion(int paysId);
	
	Region getRegion(int regionId) throws NotFoundException;
}