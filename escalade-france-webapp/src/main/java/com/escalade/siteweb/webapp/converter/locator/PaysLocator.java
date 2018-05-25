package com.escalade.siteweb.webapp.converter.locator;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.conversion.TypeConversionException;

public class PaysLocator extends StrutsTypeConverter {

	// ======================== Attributs =======================
	@Inject
	private ManagerFactory managerFactory;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PaysLocator.class);

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		LOGGER.info("PaysLocator : Appel de la méthode convertFromString ");
		Object vRetour=null;
		if(values!=null) {
			if(values.length==1) {
				String vValue=values[0];
				LOGGER.info("PaysLocator : Pays Id :"+vValue);
				try {
					vRetour=StringUtils.isEmpty(vValue)?null:managerFactory.getPaysManager().getPays(new Integer(vValue));
				} catch (NumberFormatException pE) {
					throw new TypeConversionException("PaysLocator - Format d'identifiant pays invalide",pE);
				}
				catch(NotFoundException pE) {
					throw new TypeConversionException("PaysLocator - Pays inconnu",pE);
				}
			} else {
				vRetour=performFallbackConversion(context,values,toClass);
			}
		}
		return vRetour;
	}

	@Override
	public String convertToString(Map context, Object o) {
		LOGGER.info("PaysLocator : Appel de la méthode convertToString ");
		String vRetour=null;
		if(o instanceof Pays) {
			Pays vPays=(Pays) o;
			vRetour=vPays.getId()!=null?vPays.getId().toString():"";
		} else {
			vRetour="";
		}
		return vRetour;
	}
}
