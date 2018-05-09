package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.RegionDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.RegionRM;
import com.escalade.siteweb.model.bean.site.Region;

@Named
public class RegionDaoImpl extends AbstractDaoImpl implements RegionDao {
	
	@Override
	public List<Region> getListRegion() {
        String vSQL = "SELECT * FROM public.region";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Region> vRowMapper=new RegionRM();

        List<Region> vListRegion = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListRegion;
    }
	
	@Override
	public Region getRegion(int regionId) {
		String vSQL = "SELECT * FROM public.region WHERE id="+regionId;
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		
		RowMapper<Region> vRowMapper=new RegionRM();

        List<Region> vListRegion=vJdbcTemplate.query(vSQL, vRowMapper);
        return vListRegion.get(0);
	}
}