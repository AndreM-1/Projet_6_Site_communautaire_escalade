package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;
import com.escalade.siteweb.model.exception.FunctionalException;

/**
 * Manager du package « FormulaireContact »
 * @author André Monnier
 */
public interface FormulaireContactManager {

	/**
	 * Méthode permettant de renvoyer la liste des formulaires de contact.
	 * @return List
	 */
	List<FormulaireContact> getListFormulaireContact();
	
	
	/**
	 * Méthode permettant d'insérer un formulaire de contact renseigné 
	 * par un utilisateur (identifié ou non) en BDD.
	 * @param formulaireContact : Le formulaire de contact renseigné par l'utilisateur
	 * @param bUtil : Un boolean indiquant si l'utilisateur est authentifié ou non
	 * @throws FunctionalException
	 */
	void insertFormulaireContact(FormulaireContact formulaireContact,Boolean bUtil) throws FunctionalException;
}