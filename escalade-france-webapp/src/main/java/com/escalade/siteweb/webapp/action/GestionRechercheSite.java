package com.escalade.siteweb.webapp.action;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.bean.site.Site;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer la recherche d'un {@link Site}
 * @author André Monnier
 */
public class GestionRechercheSite extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ManagerFactory managerFactory;
	
	//Paramètres
	private Pays pays;
	private Region region;
	private Departement departement;
	private List<Site> listSite;
	private List<Site> listSiteTrouve;
	private String siteRecherche;
	private Boolean bSiteTrouve=false;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionRechercheSite.class);
	
	// ===================== Getters/Setters ===============
	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public List<Site> getListSite() {
		return listSite;
	}

	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	
	public List<Site> getListSiteTrouve() {
		return listSiteTrouve;
	}

	public void setListSiteTrouve(List<Site> listSiteTrouve) {
		this.listSiteTrouve = listSiteTrouve;
	}

	public String getSiteRecherche() {
		return siteRecherche;
	}

	public void setSiteRecherche(String siteRecherche) {
		this.siteRecherche = siteRecherche;
	}
	
	public Boolean getbSiteTrouve() {
		return bSiteTrouve;
	}

	public void setbSiteTrouve(Boolean bSiteTrouve) {
		this.bSiteTrouve = bSiteTrouve;
	}

	// ===================== Méthodes ======================
	/**
	 * Méthode permettant de gérer la recherche d'un {@link Site}
	 * @return success / error
	 */
	public String doRechercheSite() {
		String vResult;	
	
		if(pays!=null&&region!=null&departement!=null) {
			LOGGER.info("Méthode doRechercheSite - Pays : "+pays);
			LOGGER.info("Méthode doRechercheSite - Region : "+region);
			LOGGER.info("Méthode doRechercheSite - Departement : "+departement);
			
			if(siteRecherche==null||siteRecherche.isEmpty()||siteRecherche.trim().isEmpty()) {
				this.addActionError("Veuilez saisir un nom pour le site recherché.");
				vResult=ActionSupport.ERROR;
			}else {
				listSiteTrouve=new ArrayList<Site>();
				LOGGER.info("Méthode doRechercheSite - Nom du site Recherché : "+siteRecherche);
				listSite=managerFactory.getSiteManager().getListSite();
				for(Site site:listSite) {
					if(pays.getNomPays().equals(site.getPays().getNomPays()) && region.getNomRegion().equals(site.getRegion().getNomRegion()) &&
							departement.getNomDepartement().equals(site.getDepartement().getNomDepartement()) && siteRecherche.replaceAll(" ", "").equalsIgnoreCase(site.getNomSite().replaceAll(" ", ""))) {
						LOGGER.info("Correspondance exacte. Le site a bien été trouvé.");
						listSiteTrouve.add(site);
						bSiteTrouve=true;
					}
				}
				
				vResult=ActionSupport.SUCCESS;
				
			}
				
		} else {
			this.addActionError("Veuilez saisir les noms du pays, de la région et du département.");
			vResult=ActionSupport.ERROR;
		}

		return vResult;
		
	}
}