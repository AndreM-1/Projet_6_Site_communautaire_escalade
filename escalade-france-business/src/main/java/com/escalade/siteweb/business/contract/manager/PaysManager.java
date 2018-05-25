package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface PaysManager {

	List<Pays> getListPays();

	Pays getPays(int paysId) throws NotFoundException;

}
