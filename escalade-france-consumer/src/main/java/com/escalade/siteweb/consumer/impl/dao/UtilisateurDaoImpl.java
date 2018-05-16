package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.NotFoundException;


@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

	@Inject
	private PhotoDao photoDao;

	@Override
	public List<Utilisateur> getListUtilisateur() {
		String vSQL = "SELECT * FROM public.utilisateur ORDER BY id ASC";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 

		RowMapper<Utilisateur> vRowMapper=new UtilisateurRM(photoDao);

		List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListUtilisateur;
	}


	@Override
	public Utilisateur getUtilisateur(String adresseMail, String motDePasse) throws NotFoundException {
		String vSQL="SELECT * FROM public.utilisateur WHERE adresse_mail='"+adresseMail+"' AND mot_de_passe='"+motDePasse+"'";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		RowMapper<Utilisateur> vRowMapper=new UtilisateurRM(photoDao);

		List<Utilisateur> vListUtilisateur=vJdbcTemplate.query(vSQL, vRowMapper);

		if(vListUtilisateur.size()!=0)	
			return vListUtilisateur.get(0);
		else
			throw new NotFoundException("Consumer - Aucun utilisateur correspondant au couple login/password fourni.");
	}

	@Override
	public Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException {
		String vSQL = "SELECT * FROM public.utilisateur WHERE id="+utilisateurId;

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 

		RowMapper<Utilisateur> vRowMapper=new UtilisateurRM(photoDao);

		List<Utilisateur> vListUtilisateur=vJdbcTemplate.query(vSQL, vRowMapper);
		if(vListUtilisateur.size()!=0)	
			return vListUtilisateur.get(0);
		else
			throw new NotFoundException("Consumer - Aucun utilisateur ne correspond à l'ID demandé.");
	}
	
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {

		String vSQL="UPDATE public.utilisateur SET civilite=:civilite, nom=:nom, prenom=:prenom, pseudo=:pseudo, adresse_mail=:adresseMail, telephone=:telephone,"
				+ "date_naissance=:dateNaissance, adresse=:adresse, code_postal=:codePostal, ville=:ville, pays=:pays WHERE id=:id";
		
		SqlParameterSource vParams=new BeanPropertySqlParameterSource(utilisateur);
		NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vSQL,vParams);
			
	}
	
	@Override
	public void updateMdp(Utilisateur utilisateur) {
		String vSQL="UPDATE public.utilisateur SET mot_de_passe=:motDePasse WHERE id=:id";
		
		SqlParameterSource vParams=new BeanPropertySqlParameterSource(utilisateur);
		NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vSQL,vParams);
		
	}
}