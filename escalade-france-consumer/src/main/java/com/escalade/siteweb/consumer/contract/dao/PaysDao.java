package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface PaysDao {

	List<Pays> getListPays();

	Pays getPays(int paysId) throws NotFoundException;

}
