package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Voie;

public interface VoieDao {

	List<Voie> getListVoie();

	List<Voie> getListVoie(int secteurId);

	void insertVoie(Voie voie, int secteurId) throws Exception;

}
