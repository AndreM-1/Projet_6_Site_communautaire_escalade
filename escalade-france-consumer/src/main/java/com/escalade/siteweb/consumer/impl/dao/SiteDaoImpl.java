package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.DepartementDao;
import com.escalade.siteweb.consumer.contract.dao.PaysDao;
import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.RegionDao;
import com.escalade.siteweb.consumer.contract.dao.SiteDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.SiteRM;
import com.escalade.siteweb.model.bean.site.Site;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao{
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	@Inject
	private PaysDao paysDao;
	
	@Inject
	private RegionDao regionDao;
	
	@Inject
	private DepartementDao departementDao;
	
	@Inject
	private PhotoDao photoDao;
	
	@Override
	public List<Site> getListSite() {
        String vSQL = "SELECT * FROM public.site ORDER BY date_maj_site DESC";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Site> vRowMapper=new SiteRM(utilisateurDao,paysDao,regionDao,departementDao,photoDao);

        List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListSite;
    }
}