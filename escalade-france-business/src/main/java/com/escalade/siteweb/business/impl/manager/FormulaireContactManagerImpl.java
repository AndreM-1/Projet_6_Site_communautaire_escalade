package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Named;
import javax.validation.ConstraintViolation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.escalade.siteweb.business.contract.manager.FormulaireContactManager;
import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;
import com.escalade.siteweb.model.exception.FunctionalException;

@Named
public class FormulaireContactManagerImpl extends AbstractManager implements FormulaireContactManager {
	
	private List<FormulaireContact> listFormulaireContact = new ArrayList<>();
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(FormulaireContactManagerImpl.class);

	@Override
	public List<FormulaireContact> getListFormulaireContact() {
		listFormulaireContact=getDaoFactory().getFormulaireContactDao().getListFormulaireContact();
		return this.listFormulaireContact;
	}	
	
	@Override
	public void insertFormulaireContact(FormulaireContact formulaireContact, Boolean bUtil) throws FunctionalException {
		
		//On lève une exception si la validation de bean échoue.
		Set<ConstraintViolation<FormulaireContact>> vViolations = getConstraintValidator().validate(formulaireContact);

		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<FormulaireContact> violation : vViolations) {
				LOGGER.info((violation.getMessage())); 
			}
			throw new FunctionalException("Certains paramètres ne sont pas renseignés correctement.");
		}
		
		//Utilisation d'un TransactionTemplate.
		TransactionTemplate vTransactionTemplate=new TransactionTemplate(getPlatformTransactionManager());
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
				getDaoFactory().getFormulaireContactDao().insertFormulaireContact(formulaireContact,bUtil);	
			}   
		});
		
	}
}