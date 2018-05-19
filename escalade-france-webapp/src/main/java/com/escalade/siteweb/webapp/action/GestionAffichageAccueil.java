package com.escalade.siteweb.webapp.action;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.bean.site.Site;
import com.opensymphony.xwork2.ActionSupport;


public class GestionAffichageAccueil extends ActionSupport implements SessionAware {
	// ===================== Attributs =====================

	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres en entrée


	// ----- Eléments en sortie
	private List<Pays> listPays;
	private List<Region> listRegion;
	private List<Departement> listDepartement;
	private List<Site> listSite;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	
	
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAffichageAccueil.class);

	// ===================== Getters/Setters ===============	
	public List<Pays> getListPays() {
		return listPays;
	}

	public void setListPays(List<Pays> listPays) {
		this.listPays = listPays;
	}

	public List<Region> getListRegion() {
		return listRegion;
	}

	public void setListRegion(List<Region> listRegion) {
		this.listRegion = listRegion;
	}

	public List<Departement> getListDepartement() {
		return listDepartement;
	}

	public void setListDepartement(List<Departement> listDepartement) {
		this.listDepartement = listDepartement;
	}

	public List<Site> getListSite() {
		return listSite;
	}

	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	
	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;
		
	}
	
	// ===================== Méthodes ======================
	/**
	 * Méthode permettant de récupérer des listes de variables en session qui 
	 * seront utilisées dans plusieurs JSP car inclues dans la section header.
	 * @return success
	 */
	public String doList() {
		listPays = managerFactory.getPaysManager().getListPays();
		listRegion = managerFactory.getRegionManager().getListRegion();
		listDepartement = managerFactory.getDepartementManager().getListDepartement();
		listSite=managerFactory.getSiteManager().getListSite();
		
		//Ajout de variables en session
		this.session.put("listPays", listPays);
		this.session.put("listRegion", listRegion);
		this.session.put("listDepartement", listDepartement);

		LOGGER.info("Liste des pays :");
		LOGGER.info(listPays);
		LOGGER.info("Liste des régions :");
		LOGGER.info(listRegion);
		LOGGER.info("Liste des départements :");
		LOGGER.info(listDepartement);
		LOGGER.info("Liste des sites :");
		LOGGER.info(listSite.get(0));

		return ActionSupport.SUCCESS;
	}
}