package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.DepartementManager;
import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class DepartementManagerImpl extends AbstractManager implements DepartementManager{
	
	private List<Departement> listDepartement = new ArrayList<>();
	private Departement departement;

	@Override
	public List<Departement> getListDepartement() {
		listDepartement=getDaoFactory().getDepartementDao().getListDepartement();
		return this.listDepartement;
	}
	
	@Override
	public List<Departement> getListDepartement(int regionId){
		listDepartement=getDaoFactory().getDepartementDao().getListDepartement(regionId);
		return this.listDepartement;
	}
	
	@Override
	public Departement getDepartement(int departementId) throws NotFoundException {
		try {
			departement=getDaoFactory().getDepartementDao().getDepartement(departementId);
			return departement;
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - Aucun département ne correspond à l'ID demandé.");
		}
	}
}