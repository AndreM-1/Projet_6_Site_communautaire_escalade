package com.escalade.siteweb.business.impl.manager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.transaction.PlatformTransactionManager;

import com.escalade.siteweb.consumer.contract.DaoFactory;

public abstract class AbstractManager {
	
	@Inject
    private DaoFactory daoFactory; 
	
	@Inject
	@Named("txManagerEscalade")
	private PlatformTransactionManager platformTransactionManager;

	protected DaoFactory getDaoFactory() {
		return daoFactory; 
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}

	public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
	}
	
	 /**
     * Renvoie un {@link Validator} de contraintes
     *
     * @return Validator
     */
    protected Validator getConstraintValidator() {
        ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();		
        Validator vValidator = vFactory.getValidator();
        return vValidator;
    }

}
