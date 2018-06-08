package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.exception.NotFoundException;

/**
 * Manager du package « Region »
 * @author André Monnier
 */
public interface RegionManager {

	/**
	 * Méthode permettant de renvoyer la liste des régions.
	 * @return List
	 */
	List<Region> getListRegion();

	/**
	 * Méthode permettant de renvoyer la liste des régions d'un pays.
	 * @param paysId : L'identifiant du pays
	 * @return List
	 */
	List<Region> getListRegion(int paysId);

	/**
	 * Méthode permettant de renvoyer une région à partir de son identifiant.
	 * @param regionId : L'identifiant de la région
	 * @return {@link Region}
	 * @throws NotFoundException
	 */
	Region getRegion(int regionId) throws NotFoundException;
}