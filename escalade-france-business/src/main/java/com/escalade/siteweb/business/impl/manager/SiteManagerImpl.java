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

import com.escalade.siteweb.business.contract.manager.SiteManager;
import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

	private List<Site> listSite = new ArrayList<>();
	private Site site;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SiteManagerImpl.class);

	@Override
	public List<Site> getListSite() {
		listSite=getDaoFactory().getSiteDao().getListSite();
		return this.listSite;
	}

	@Override
	public Site getSite(int siteId) throws NotFoundException{
		try {
			site=getDaoFactory().getSiteDao().getSite(siteId);
			return site;
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - Aucun site ne correspond à l'ID demandé.");
		}
	}

	@Override
	public List<Site> getListSite(int utilisateurId) throws NotFoundException{
		try {
			listSite=getDaoFactory().getSiteDao().getListSite(utilisateurId);  
			return listSite;
		} catch (NotFoundException e) {
			throw new NotFoundException("Business - L'utilisateur n'a pas encore posté de site.");
		}
	}

	@Override
	public void insertSite(Site site, List<Secteur> listSecteur) throws FunctionalException,TechnicalException{
		//On lève une exception si la validation de bean échoue. A noter que la validation
		// de bean porte sur l'objet site.
		Set<ConstraintViolation<Site>> vViolations = getConstraintValidator().validate(site);
		if(!vViolations.isEmpty()) {
			for (ConstraintViolation<Site> violation : vViolations) {
				LOGGER.info((violation.getMessage())); 
			}
			throw new FunctionalException("Veuillez renseigner le nom du site.");
		}

		//Utilisation d'un TransactionStatus. On a besoin de lever une FunctionalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			getDaoFactory().getSiteDao().insertSite(site);
			int numSiteAjoute=getDaoFactory().getSiteDao().getCountNbSite();
			LOGGER.info("Business - Nb site :"+numSiteAjoute);
			for(Secteur secteur:listSecteur) {
				if(!secteur.getNomSecteur().isEmpty()) {
					getDaoFactory().getSecteurDao().insertSecteur(secteur.getNomSecteur(),numSiteAjoute);
		
				}
			}
		} catch (Exception vEx) {
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new TechnicalException("Erreur technique lors de l'ajout du site en BDD.");
		}

		getPlatformTransactionManager().commit(vTransactionStatus);
	}
}