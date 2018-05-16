package com.escalade.siteweb.webapp.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter{
	
	private static final DateFormat DATE_FORMAT =new SimpleDateFormat("yy-MM-dd");

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Object vRetour=null;
		
		if(values!=null) {
			if(values.length==1) {
				String vValue=values[0];
				System.out.println("*************DateConverter_cfs_vValue*************:"+vValue);
				try {
					vRetour=DATE_FORMAT.parse(vValue);
					System.out.println("*************DateConverter_cfs_vRetour************* : "+vRetour);
				} catch (ParseException pE) {
					throw new TypeConversionException("*************Format de date invalide*************",pE);
				}
			}else {
					vRetour=performFallbackConversion(context,values,toClass);
			}
		}
		return vRetour;
	}

	@Override
	public String convertToString(Map context, Object o) {
		String vRetour=null;
		if(o instanceof Date) {
			Date vDate=(Date)o;
			vRetour=DATE_FORMAT.format(vDate);
		}else {
			vRetour="";
		}
		System.out.println("*************DateConverter_cts_vRetour*************:"+vRetour);
		return vRetour;
	}
	
}
