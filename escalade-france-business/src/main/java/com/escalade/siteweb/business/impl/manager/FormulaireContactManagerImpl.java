package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.escalade.siteweb.business.contract.manager.FormulaireContactManager;
import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;

@Named
public class FormulaireContactManagerImpl extends AbstractManager implements FormulaireContactManager {
	
	private List<FormulaireContact> listFormulaireContact = new ArrayList<>();

	@Override
	public List<FormulaireContact> getListFormulaireContact() {
		listFormulaireContact=getDaoFactory().getFormulaireContactDao().getListFormulaireContact();
		return this.listFormulaireContact;
	}	
}