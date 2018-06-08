package com.escalade.siteweb.webapp.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *  Intercepteur permettant de bloquer l'accès à la page de profil, de réservation de topo,
 *  d'ajout de site et l'ajout de commentaires pour un utilisateur non connecté.
 *  @author André Monnier
 */
public class AuthInterceptor extends AbstractInterceptor {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AuthInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String vResult;
		if(invocation.getInvocationContext().getSession().get("user")!=null) {
			vResult=invocation.invoke();	
		} else {
			vResult="refus-acces-page-profil-res-topo";
		}
		LOGGER.info("AuthInterceptor - Intercepteur :"+vResult);
		return vResult;
	}
}