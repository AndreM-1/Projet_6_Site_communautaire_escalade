package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.PaysManager;
import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class PaysManagerImpl extends AbstractManager implements PaysManager {

	private List<Pays> listPays = new ArrayList<>();
	private Pays pays;

	@Override
	public List<Pays> getListPays() {
		listPays=getDaoFactory().getPaysDao().getListPays();
		return this.listPays;
	}
	
	@Override
	public Pays getPays(int paysId) throws NotFoundException {
		try {
			pays=getDaoFactory().getPaysDao().getPays(paysId);
			return pays;
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - Aucun pays ne correspond à l'ID demandé.");
		}
	}
}