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

import com.escalade.siteweb.business.contract.manager.SecteurManager;
import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager{
	
	private List<Secteur> listSecteur = new ArrayList<>();
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SecteurManagerImpl.class);

	@Override
	public List<Secteur> getListSecteur() {
		listSecteur=getDaoFactory().getSecteurDao().getListSecteur();
		return this.listSecteur;
	}
	
	@Override
	public List<Secteur> getListSecteur(int siteId) throws NotFoundException{
		
		try {
			listSecteur=getDaoFactory().getSecteurDao().getListSecteur(siteId);
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - Ce site n'a pas encore de secteurs.");
		}
		
		return this.listSecteur;
	}
	
	
	
	@Override
	public void insertSecteur(List<Secteur> listSecteur, int siteId) throws FunctionalException,TechnicalException{
		
		//On lève une exception si la validation de bean échoue. A noter que la validation
		// de bean porte sur l'objet secteur.
		for (Secteur secteur : listSecteur){
			Set<ConstraintViolation<Secteur>> vViolations = getConstraintValidator().validate(secteur);
			if(!vViolations.isEmpty()) {
				for (ConstraintViolation<Secteur> violation : vViolations) {
					LOGGER.info((violation.getMessage())); 
				}
				throw new FunctionalException("Veuillez renseigner le nom du secteur.");
			}
		}
		
		//Utilisation d'un TransactionStatus. On a besoin de lever une TechnicalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		
		for (Secteur secteur : listSecteur) {
			try {
				getDaoFactory().getSecteurDao().insertSecteur(secteur.getNomSecteur(), siteId);
			} catch (Exception e) {
				getPlatformTransactionManager().rollback(vTransactionStatus);
				throw new TechnicalException("Erreur technique lors de l'ajout de secteurs en BDD.");
				
			}
		}
		
		getPlatformTransactionManager().commit(vTransactionStatus);
	
	}
}