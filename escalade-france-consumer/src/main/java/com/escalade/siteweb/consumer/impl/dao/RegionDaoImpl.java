package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.RegionDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.RegionRM;
import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.exception.NotFoundException;

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
	public List<Region> getListRegion(int paysId) {
		String vSQL="SELECT * FROM public.region WHERE pays_id="+paysId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Region> vRowMapper=new RegionRM();

        List<Region> vListRegion = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListRegion;
	}
	
	public Region getRegion(int regionId) throws NotFoundException {
		String vSQL="SELECT * FROM public.region WHERE id="+regionId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Region> vRowMapper=new RegionRM();

        List<Region> vListRegion = vJdbcTemplate.query(vSQL, vRowMapper);

		if(vListRegion.size()!=0)	
			return vListRegion.get(0);
		else
			throw new NotFoundException("Consumer - Aucune région ne correspond à l'ID demandé.");
	}
}