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
}