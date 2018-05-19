package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;
import com.escalade.siteweb.model.exception.FunctionalException;

public interface FormulaireContactManager {

	List<FormulaireContact> getListFormulaireContact();

	void insertFormulaireContact(FormulaireContact formulaireContact,Boolean bUtil) throws FunctionalException;

}
