package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.exception.NotFoundException;

/**
 * Manager du package « Departement »
 * @author André Monnier
 */
public interface DepartementManager {

	/**
	 * Méthode permettant de renvoyer la liste des départements.
	 * @return List
	 */
	List<Departement> getListDepartement();
	
	
	/**
	 * Méthode permettant de renvoyer la liste des départements d'une région.
	 * @param regionId : Identifiant de la région
	 * @return List
	 */
	List<Departement> getListDepartement(int regionId);

	/**
	 * Méthode permettant de renvoyer un département en fonction de son identifiant.
	 * @param departementId : Identifiant du département
	 * @return {@link Departement} 
	 * @throws NotFoundException
	 */
	Departement getDepartement(int departementId) throws NotFoundException;
}