package com.escalade.siteweb.webapp.converter.locator;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * Bean Locator permettant de récupérer un objet de type {@link Departement}
 * à partir de l'id de cet objet.
 * @author André Monnier
 */
public class DepartementLocator extends StrutsTypeConverter{
	
	// ======================== Attributs =======================
	@Inject
	private ManagerFactory managerFactory;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DepartementLocator.class);

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		LOGGER.info("DepartementLocator : Appel de la méthode convertFromString ");
		Object vRetour=null;
		if(values!=null) {
			if(values.length==1) {
				String vValue=values[0];
				LOGGER.info("DepartementLocator : Departement Id :"+vValue);
				try {
					vRetour=StringUtils.isEmpty(vValue)?null:managerFactory.getDepartementManager().getDepartement(new Integer(vValue));
				} catch (NumberFormatException pE) {
					throw new TypeConversionException("DepartementLocator - Format d'identifiant département invalide",pE);
				}
				catch(NotFoundException pE) {
					throw new TypeConversionException("DepartementLocator - Departement inconnu",pE);
				}
			} else {
				vRetour=performFallbackConversion(context,values,toClass);
			}
		}
		return vRetour;
	}

	@Override
	public String convertToString(Map context, Object o) {
		LOGGER.info("DepartementLocator : Appel de la méthode convertToString ");
		String vRetour=null;
		if(o instanceof Departement) {
			Departement vDepartement=(Departement) o;
			vRetour=vDepartement.getId()!=null?vDepartement.getId().toString():"";
		} else {
			vRetour="";
		}
		return vRetour;
	}

}
