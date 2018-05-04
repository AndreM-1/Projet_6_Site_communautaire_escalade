package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.VoieManager;
import com.escalade.siteweb.model.bean.site.Voie;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager{
	
	private List<Voie> listVoie = new ArrayList<>();

	@Override
	public List<Voie> getListVoie() {
		listVoie=getDaoFactory().getVoieDao().getListVoie();
		return this.listVoie;
	}
}