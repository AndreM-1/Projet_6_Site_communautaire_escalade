package com.escalade.siteweb.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * Classe permettant de définir un object de type {@link DataSource}
 * qui sera utilisé par les implémentations de la couche Dao pour se
 * connecter à la base de données. 
 * @author André Monnier
 */
public abstract class AbstractDaoImpl {
	
	@Inject
	@Named("dataSourceEscalade")
	private DataSource dataSource; 

	protected DataSource getDataSource() {
		return dataSource;
	}
}