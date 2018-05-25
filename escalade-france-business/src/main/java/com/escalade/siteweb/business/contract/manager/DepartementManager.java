package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface DepartementManager {

	List<Departement> getListDepartement();

	List<Departement> getListDepartement(int regionId);

	Departement getDepartement(int departementId) throws NotFoundException;

}
