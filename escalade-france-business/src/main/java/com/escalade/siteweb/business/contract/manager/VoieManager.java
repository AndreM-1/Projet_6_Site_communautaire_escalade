package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Voie;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.TechnicalException;

public interface VoieManager {

	List<Voie> getListVoie();

	void insertVoie(List<Voie> listVoie, int secteurId) throws FunctionalException, TechnicalException;
}