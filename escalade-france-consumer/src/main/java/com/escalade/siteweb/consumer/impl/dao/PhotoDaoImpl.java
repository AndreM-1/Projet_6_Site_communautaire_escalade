package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.impl.rowmapper.photo.PhotoRM;
import com.escalade.siteweb.model.bean.photo.Photo;

@Named
public class PhotoDaoImpl extends AbstractDaoImpl implements PhotoDao{

	@Override
	public List<Photo> getListPhoto() {
        String vSQL = "SELECT * FROM public.photo";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Photo> vRowMapper=new PhotoRM();

        List<Photo> vListPhoto = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListPhoto;
    }
	
	@Override
	public Photo getPhotoSite(int siteId) {
		String vSQL = "SELECT * FROM public.photo WHERE site_id="+siteId;
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		
		RowMapper<Photo> vRowMapper=new PhotoRM();

        List<Photo> vListPhoto=vJdbcTemplate.query(vSQL, vRowMapper);
        
        if(vListPhoto.size()!=0)	
        	return vListPhoto.get(0);
        else
        	return null;
	}
	
	@Override
	public List<Photo> getListPhotoSecteur(int siteId){
		String vSQL = "SELECT * FROM public.photo INNER JOIN public.secteur ON photo.secteur_id=secteur.id WHERE secteur.site_id="+siteId;
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		
		RowMapper<Photo> vRowMapper=new PhotoRM();

        List<Photo> vListPhoto=vJdbcTemplate.query(vSQL, vRowMapper);
        
        if(vListPhoto.size()!=0)
        	return vListPhoto;
        else
        	return null;
	}
	
	@Override
	public Photo getPhotoUtilisateur(int utilisateurId) {
		String vSQL="SELECT * FROM public.photo WHERE utilisateur_id="+utilisateurId;
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Photo> vRowMapper=new PhotoRM();
        List<Photo> vListPhoto=vJdbcTemplate.query(vSQL, vRowMapper);
        if(vListPhoto.size()!=0)	
        	return vListPhoto.get(0);
        else
        	return null;
	}
}