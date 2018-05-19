package com.escalade.siteweb.consumer.impl.dao;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.escalade.siteweb.consumer.contract.dao.CommentaireDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.CommentaireRM;
import com.escalade.siteweb.model.bean.site.Commentaire;

@Named
public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	@Override
	public List<Commentaire> getListCommentaire() {
        String vSQL = "SELECT * FROM public.commentaire";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Commentaire> vRowMapper=new CommentaireRM(utilisateurDao);

        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListCommentaire;
    }
	
	@Override
	public List<Commentaire> getListCommentaire(int siteId) {
        String vSQL = "SELECT * FROM public.commentaire WHERE site_id="+siteId+" ORDER BY date_commentaire DESC";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Commentaire> vRowMapper=new CommentaireRM(utilisateurDao);

        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL, vRowMapper);
        
        if(vListCommentaire.size()!=0)
        	return vListCommentaire;
        else
        	return null;
    }
	
	@Override
	public void insertCommentaire(String commentaire, int utilisateurId, int siteId, Date date) {
		
		JdbcTemplate vJdbcTemplate=new JdbcTemplate(getDataSource());
		vJdbcTemplate.update("INSERT INTO public.commentaire(commentaire,utilisateur_id,site_id,date_commentaire) VALUES(?,?,?,?)", commentaire,utilisateurId,siteId,date);
		
	}
}