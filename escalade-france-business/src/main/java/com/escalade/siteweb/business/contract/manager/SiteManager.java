package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

/**
 * Manager du package « Site »
 * @author André Monnier
 */
public interface SiteManager {

	/**
	 * Méthode permettant de renvoyer la liste des sites.
	 * @return List
	 */
	List<Site> getListSite();

	/**
	 * Méthode permettant de renvoyer un site en fonction de son identifiant.
	 * @param siteId : L'identifiant du site
	 * @return {@link Site}
	 * @throws NotFoundException
	 */
	Site getSite(int siteId) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer une liste de sites posté par un utilisateur
	 * en commençant par la publication la plus récente.
	 * @param utilisateurId : L'identifiant de l'utilisateur
	 * @return List
	 * @throws NotFoundException
	 */
	List<Site> getListSite(int utilisateurId) throws NotFoundException;

	/**
	 * Méthode permettant d'enregister un site en base de données.
	 * @param site : Le site à enregistrer en BDD.
	 * @throws FunctionalException
	 * @throws TechnicalException
	 */
	void insertSite(Site site) throws FunctionalException,TechnicalException;

	/**
	 * Méthode permettant de récupérer la séquence de la table site
	 * suite à l'ajout du site en base de données.
	 * @return La valeur de la séquence de la table site site_id_seq
	 */
	int getNumSiteAjoute();
}
