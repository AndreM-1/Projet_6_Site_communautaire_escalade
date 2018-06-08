package com.escalade.siteweb.webapp.converter.locator;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * Bean Locator permettant de récupérer un objet de type {@link Region}
 * à partir de l'id de cet objet.
 * @author André Monnier
 */
public class RegionLocator extends StrutsTypeConverter {

	// ======================== Attributs =======================
	@Inject
	private ManagerFactory managerFactory;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(RegionLocator.class);

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		LOGGER.info("RegionLocator : Appel de la méthode convertFromString ");
		Object vRetour=null;
		if(values!=null) {
			if(values.length==1) {
				String vValue=values[0];
				LOGGER.info("RegionLocator : Region Id :"+vValue);
				try {
					vRetour=StringUtils.isEmpty(vValue)?null:managerFactory.getRegionManager().getRegion(new Integer(vValue));
				} catch (NumberFormatException pE) {
					throw new TypeConversionException("RegionLocator - Format d'identifiant région invalide",pE);
				}
				catch(NotFoundException pE) {
					throw new TypeConversionException("RegionLocator - Région inconnu",pE);
				}
			} else {
				vRetour=performFallbackConversion(context,values,toClass);
			}
		}
		return vRetour;
	}

	@Override
	public String convertToString(Map context, Object o) {
		LOGGER.info("RegionLocator : Appel de la méthode convertToString ");
		String vRetour=null;
		if(o instanceof Region) {
			Region vRegion=(Region) o;
			vRetour=vRegion.getId()!=null?vRegion.getId().toString():"";
		} else {
			vRetour="";
		}
		return vRetour;
	}
}
