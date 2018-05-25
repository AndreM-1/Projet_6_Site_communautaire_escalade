package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.PaysDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.PaysRM;
import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class PaysDaoImpl extends AbstractDaoImpl implements PaysDao {
	
	@Override
	public List<Pays> getListPays() {
        String vSQL = "SELECT * FROM public.pays";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Pays> vRowMapper=new PaysRM();

        List<Pays> vListPays = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListPays;
    }
	
	@Override
	public Pays getPays(int paysId) throws NotFoundException {
		String vSQL = "SELECT * FROM public.pays WHERE id="+paysId;
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		
		RowMapper<Pays> vRowMapper=new PaysRM();

        List<Pays> vListPays=vJdbcTemplate.query(vSQL, vRowMapper);
        
		if(vListPays.size()!=0)	
			return vListPays.get(0);
		else
			throw new NotFoundException("Consumer - Aucun pays ne correspond à l'ID demandé.");
	}
}