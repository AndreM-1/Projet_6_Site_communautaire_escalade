package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

/**
 * Manager du package « Secteur »
 * @author André Monnier
 */
public interface SecteurManager {

	/**
	 * Méthode permettant de renvoyer la liste des secteurs.
	 * @return List
	 */
	List<Secteur> getListSecteur();

	/**
	 * Méthode permettant d'enregistrer une liste de secteurs pour un site donné en BDD.
	 * @param listSecteur : La liste des secteurs
	 * @param siteId : L'identifiant du site
	 * @throws FunctionalException
	 * @throws TechnicalException
	 */
	void insertSecteur(List<Secteur> listSecteur, int siteId) throws FunctionalException,TechnicalException;

	/**
	 * Méthode permettant de renvoyer une liste de secteurs pour un site donné.
	 * @param siteId : L'identifiant du site
	 * @return List
	 * @throws NotFoundException
	 */
	List<Secteur> getListSecteur(int siteId) throws NotFoundException;
}