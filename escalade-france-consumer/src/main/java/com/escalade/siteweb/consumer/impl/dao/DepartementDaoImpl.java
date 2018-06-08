package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.DepartementDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.DepartementRM;
import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class DepartementDaoImpl extends AbstractDaoImpl implements DepartementDao {
	
	@Override
	public List<Departement> getListDepartement() {
        String vSQL = "SELECT * FROM public.departement";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Departement> vRowMapper=new DepartementRM();

        List<Departement> vListDepartement = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListDepartement;
    }
	
	@Override
	public List<Departement> getListDepartement(int regionId){
		
		String vSQL="SELECT * FROM public.departement WHERE region_id="+regionId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Departement> vRowMapper=new DepartementRM();

        List<Departement> vListDepartement = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListDepartement;
	}
	
	public Departement getDepartement(int departementId) throws NotFoundException {
		String vSQL="SELECT * FROM public.departement WHERE id="+departementId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<Departement> vRowMapper=new DepartementRM();

        List<Departement> vListDepartement = vJdbcTemplate.query(vSQL, vRowMapper);

		if(vListDepartement.size()!=0)	
			return vListDepartement.get(0);
		else
			throw new NotFoundException("Consumer - Aucun département ne correspond à l'ID demandé.");
	}
}