package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Named;
import javax.validation.ConstraintViolation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.escalade.siteweb.business.contract.manager.VoieManager;
import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.bean.site.Voie;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.TechnicalException;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager{
	
	private List<Voie> listVoie = new ArrayList<>();
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(VoieManagerImpl.class);

	@Override
	public List<Voie> getListVoie() {
		listVoie=getDaoFactory().getVoieDao().getListVoie();
		return this.listVoie;
	}
	
	@Override
	public void insertVoie(List<Voie> listVoie, int secteurId) throws FunctionalException,TechnicalException{
		
		//On lève une exception si la validation de bean échoue. A noter que la validation
		// de bean porte sur l'objet voie.
		for (Voie voie : listVoie){
			Set<ConstraintViolation<Voie>> vViolations = getConstraintValidator().validate(voie);
			if(!vViolations.isEmpty()) {
				for (ConstraintViolation<Voie> violation : vViolations) {
					LOGGER.info((violation.getMessage())); 
				}
				throw new FunctionalException("Tous les champs sont obligatoires/Les champs saisis ne doivent pas comporter plus de 100 caractères.");
			}
		}
		
		//Utilisation d'un TransactionStatus. On a besoin de lever une TechnicalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		
		for (Voie voie : listVoie) {
			try {
				getDaoFactory().getVoieDao().insertVoie(voie, secteurId);
			} catch (Exception e) {
				getPlatformTransactionManager().rollback(vTransactionStatus);
				throw new TechnicalException("Erreur technique lors de l'ajout de voies en BDD.");
				
			}
		}
		
		getPlatformTransactionManager().commit(vTransactionStatus);
		
	}
}