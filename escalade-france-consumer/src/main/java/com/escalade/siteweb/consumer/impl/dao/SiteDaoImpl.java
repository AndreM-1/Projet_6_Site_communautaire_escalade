package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.escalade.siteweb.consumer.contract.dao.CommentaireDao;
import com.escalade.siteweb.consumer.contract.dao.DepartementDao;
import com.escalade.siteweb.consumer.contract.dao.PaysDao;
import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.RegionDao;
import com.escalade.siteweb.consumer.contract.dao.SecteurDao;
import com.escalade.siteweb.consumer.contract.dao.SiteDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.SiteRM;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;

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
	
	@Inject
	private CommentaireDao commentaireDao;
	
	@Inject
	private SecteurDao secteurDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SiteDaoImpl.class);
	
	@Override
	public List<Site> getListSite() {
        String vSQL = "SELECT * FROM public.site ORDER BY date_maj_site DESC";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Site> vRowMapper=new SiteRM(utilisateurDao,paysDao,regionDao,departementDao,photoDao,commentaireDao,secteurDao);

        List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListSite;
    }
	
	@Override
	public Site getSite(int siteId) throws NotFoundException{
		String vSQL="SELECT * FROM public.site WHERE id="+siteId;
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		
		RowMapper<Site> vRowMapper=new SiteRM(utilisateurDao,paysDao,regionDao,departementDao,photoDao,commentaireDao,secteurDao);
		
		List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);
		
        if(vListSite.size()!=0)	
        	return vListSite.get(0);
        else
        	 throw new NotFoundException("Consumer - Aucun site ne correspond à l'ID demandé.");
		
	}
	
	@Override
	public List<Site> getListSite(int utilisateurId) throws NotFoundException{
		String vSQL = "SELECT * FROM public.site WHERE utilisateur_id = "+utilisateurId + " ORDER BY date_maj_site DESC";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		
		RowMapper<Site> vRowMapper=new SiteRM(utilisateurDao,paysDao,regionDao,departementDao,photoDao,commentaireDao,secteurDao);
		
		List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);
		
        if(vListSite.size()!=0)	
        	return vListSite;
        else
        	 throw new NotFoundException("Consumer - L'utilisateur n'a pas encore posté de site.");
	}
	
	@Override
	public void insertSite(Site site) throws Exception{
		String vSQL="INSERT INTO public.site(nom_site,descriptif,commentaire_personnel,topo_disponible,pays_id,region_id,departement_id,utilisateur_id,date_ajout_site,date_maj_site) VALUES "
				+ "(:nomSite,:descriptif,:commentairePersonnel,:topoDisponible,:pays.id,:region.id,:departement.id,:utilisateur.id,:dateAjoutSite,:dateMajSite)";
				
		SqlParameterSource vParams=new BeanPropertySqlParameterSource(site);
		NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
		
		try {
			vJdbcTemplate.update(vSQL,vParams);
		} catch (Exception vEx) {
			LOGGER.info("Erreur technique lors de l'ajout du site en BDD.");
			throw new Exception("Erreur technique lors de l'ajout du site en BDD.");
		}
	}
	
	@Override
	public int getCountNbSite() {
		String vSQL="SELECT COUNT(*) FROM public.site";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		int nbSite=vJdbcTemplate.queryForObject(vSQL, Integer.class);
		return nbSite;
	}
}