package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.impl.rowmapper.photo.PhotoRM;
import com.escalade.siteweb.model.bean.photo.Photo;
import com.escalade.siteweb.model.exception.FunctionalException;

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
	public List<Photo> getListPhotoAllSecteur(int siteId){
		String vSQL = "SELECT * FROM public.photo INNER JOIN public.secteur ON photo.secteur_id=secteur.id WHERE secteur.site_id="+siteId+" ORDER BY photo.id ASC";
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
	
	@Override
	public List<Photo> getListPhotoSecteur(int secteurId) {
		String vSQL="SELECT * FROM public.photo WHERE secteur_id="+secteurId;
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Photo> vRowMapper=new PhotoRM();
        List<Photo> vListPhoto=vJdbcTemplate.query(vSQL, vRowMapper);
        if(vListPhoto.size()!=0)	
        	return vListPhoto;
        else
        	return null;
	}
	
	@Override
	public void insertPhotoUtilisateur(String nomPhoto, int utilisateurId) throws FunctionalException{
		String vSQL="INSERT INTO public.photo(nom_photo,utilisateur_id) VALUES (?,?)";
		JdbcTemplate vJdbcTemplate=new JdbcTemplate(getDataSource());
	
		try {
			vJdbcTemplate.update(vSQL, nomPhoto,utilisateurId);
		} catch (DuplicateKeyException vEx) {
			System.out.println("Couche Consumer - L'utilisateur a déjà une photo en base de données");
			throw new FunctionalException("Couche Consumer - L'utilisateur a déjà une photo en base de données");
		}
	}
}