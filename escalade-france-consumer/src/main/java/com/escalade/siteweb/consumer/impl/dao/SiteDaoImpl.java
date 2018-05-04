package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.SiteDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.SiteRM;
import com.escalade.siteweb.model.bean.site.Site;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao{
	
	@Override
	public List<Site> getListSite() {
        String vSQL = "SELECT * FROM public.site";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Site> vRowMapper=new SiteRM();

        List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListSite;
    }
}