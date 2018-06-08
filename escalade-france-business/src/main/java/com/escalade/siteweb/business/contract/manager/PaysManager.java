package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.exception.NotFoundException;

/**
 * Manager du package « Pays »
 * @author André Monnier
 */
public interface PaysManager {

	/**
	 * Méthode permettant de renvoyer la liste des pays.
	 * @return List
	 */
	List<Pays> getListPays();

	/**
	 * Méthode permettant de renvoyer un pays en fonction de son identifiant.
	 * @param paysId : Identifiant du pays
	 * @return {@link Pays}
	 * @throws NotFoundException
	 */
	Pays getPays(int paysId) throws NotFoundException;
}