package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.CommentaireDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.CommentaireRM;
import com.escalade.siteweb.model.bean.site.Commentaire;

@Named
public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {
	
	@Override
	public List<Commentaire> getListCommentaire() {
        String vSQL = "SELECT * FROM public.commentaire";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Commentaire> vRowMapper=new CommentaireRM();

        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListCommentaire;
    }
}