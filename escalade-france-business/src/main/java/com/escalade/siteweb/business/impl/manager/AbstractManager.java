package com.escalade.siteweb.business.impl.manager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.transaction.PlatformTransactionManager;

import com.escalade.siteweb.consumer.contract.DaoFactory;

/**
 * Classe permettant de définir une DaoFactory, un platformTransactionManager (utilisé
 * dans un contexte transactionnel) et un validateur de contraintes qui seront utilisés par
 * les implémentations de la couche business.
 * @author André Monnier
 */
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
     * Méthode permettant de renvoyer un {@link Validator} de contraintes
     * @return Validator
     */
    protected Validator getConstraintValidator() {
        ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();		
        Validator vValidator = vFactory.getValidator();
        return vValidator;
    }
}