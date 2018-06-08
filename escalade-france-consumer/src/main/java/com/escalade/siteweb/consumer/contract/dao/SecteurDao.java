package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.exception.NotFoundException;

/**
 * Dao du package « Secteur »
 * @author André Monnier
 */
public interface SecteurDao {

	/**
	 * Méthode permettant de renvoyer la liste des secteurs.
	 * @return List
	 */
	List<Secteur> getListSecteur();

	/**
	 * Méthode permettant de renvoyer une liste de secteurs pour un site donné.
	 * @param siteId : L'identifiant du site
	 * @return List
	 * @throws NotFoundException
	 */
	List<Secteur> getListSecteur(int siteId) throws NotFoundException;

	/**
	 * Méthode permettant d'enregistrer le secteur d'un site en BDD.
	 * @param nomSecteur : Le nom du secteur
	 * @param siteId : L'identifiant du site
	 * @throws Exception
	 */
	void insertSecteur(String nomSecteur, int siteId) throws Exception;
}