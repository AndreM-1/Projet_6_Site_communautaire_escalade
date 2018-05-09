package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Region;

public interface RegionDao {

	List<Region> getListRegion();

	Region getRegion(int regionId);

}
