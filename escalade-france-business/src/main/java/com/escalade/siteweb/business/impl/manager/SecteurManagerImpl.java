package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.SecteurManager;
import com.escalade.siteweb.model.bean.site.Secteur;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager{
	
	private List<Secteur> listSecteur = new ArrayList<>();

	@Override
	public List<Secteur> getListSecteur() {
		listSecteur=getDaoFactory().getSecteurDao().getListSecteur();
		return this.listSecteur;
	}
}