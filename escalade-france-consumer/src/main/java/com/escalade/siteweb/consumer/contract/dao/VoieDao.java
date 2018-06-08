package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Voie;

/**
 * Dao du package « Voie »
 * @author André Monnier
 */
public interface VoieDao {

	/**
	 * Méthode permettant de renvoyer la liste des voies.
	 * @return List
	 */
	List<Voie> getListVoie();

	/**
	 * Méthode permettant de renvoyer la liste des voies d'un secteur.
	 * @param secteurId : L'identifiant du secteur
	 * @return List
	 */
	List<Voie> getListVoie(int secteurId);

	/**
	 * Méthode permettant d'enregistrer une voie d'un secteur en BDD.
	 * @param voie : La voie à enregistrer en BDD
	 * @param secteurId : L'identifiant du secteur
	 * @throws Exception
	 */
	void insertVoie(Voie voie, int secteurId) throws Exception;
}