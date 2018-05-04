package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.PaysManager;
import com.escalade.siteweb.model.bean.site.Pays;

@Named
public class PaysManagerImpl extends AbstractManager implements PaysManager {

	private List<Pays> listPays = new ArrayList<>();

	@Override
	public List<Pays> getListPays() {
		listPays=getDaoFactory().getPaysDao().getListPays();
		return this.listPays;
	}
}