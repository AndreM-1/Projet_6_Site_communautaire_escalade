package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Voie;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.TechnicalException;

/**
 * Manager du package « Voie »
 * @author André Monnier
 */
public interface VoieManager {

	/**
	 * Méthode permettant de renvoyer la liste des voies.
	 * @return List
	 */
	List<Voie> getListVoie();

	/**
	 * Méthode permettant d'enregistrer une liste de voies associée à un secteur en BDD.
	 * @param listVoie : La liste de voies
	 * @param secteurId : L'identifiant du secteur
	 * @throws FunctionalException
	 * @throws TechnicalException
	 */
	void insertVoie(List<Voie> listVoie, int secteurId) throws FunctionalException, TechnicalException;
}