package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Departement;

public interface DepartementDao {

	List<Departement> getListDepartement();

	Departement getDepartement(int departementId);

}
