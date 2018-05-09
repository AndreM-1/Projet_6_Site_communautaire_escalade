package com.escalade.siteweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.DepartementDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.DepartementRM;
import com.escalade.siteweb.model.bean.site.Departement;

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
	public Departement getDepartement(int departementId) {
		String vSQL = "SELECT * FROM public.departement WHERE id="+departementId;
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
		
		RowMapper<Departement> vRowMapper=new DepartementRM();

        List<Departement> vListDepartement=vJdbcTemplate.query(vSQL, vRowMapper);
        return vListDepartement.get(0);
	}
}