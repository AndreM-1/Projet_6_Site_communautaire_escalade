package com.escalade.siteweb.webapp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *  Intercepteur permettant de bloquer l'accès à la page de profil ou de réservation de topo pour un utilisateur non connecté
 */
public class AuthInterceptor extends AbstractInterceptor {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String vResult;
		if(invocation.getInvocationContext().getSession().get("user")!=null) {
			vResult=invocation.invoke();	
		} else {
			vResult="refus-acces-page-profil-res-topo";
		}
		System.out.println("AuthInterceptor - Intercepteur :"+vResult);
		return vResult;
	}
}