package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.DepartementManager;
import com.escalade.siteweb.model.bean.site.Departement;

@Named
public class DepartementManagerImpl extends AbstractManager implements DepartementManager{
	
	private List<Departement> listDepartement = new ArrayList<>();

	@Override
	public List<Departement> getListDepartement() {
		listDepartement=getDaoFactory().getDepartementDao().getListDepartement();
		return this.listDepartement;
	}
}