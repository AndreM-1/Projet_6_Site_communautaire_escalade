package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;

public interface FormulaireContactDao {

	List<FormulaireContact> getListFormulaireContact();

	void insertFormulaireContact(FormulaireContact formulaireContact, Boolean bUtil);

}
