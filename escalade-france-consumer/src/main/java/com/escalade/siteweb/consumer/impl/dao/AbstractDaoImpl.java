package com.escalade.siteweb.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {
	
	@Inject
	@Named("dataSourceEscalade")
	private DataSource dataSource; 

	protected DataSource getDataSource() {
		return dataSource;
	}

}
