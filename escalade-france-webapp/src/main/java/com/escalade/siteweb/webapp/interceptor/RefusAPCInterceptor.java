package com.escalade.siteweb.webapp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Intercepteur permettant de bloquer l'accès à la page de connexion pour un utilisateur déjà connecté.
 */
public class RefusAPCInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String vResult;
		if(invocation.getInvocationContext().getSession().get("user")==null) {
			vResult=invocation.invoke();	
		} else {
			vResult="refus-acces-page-connexion";
		}
		System.out.println("Intercepteur :"+vResult);
		return vResult;
	}

}
