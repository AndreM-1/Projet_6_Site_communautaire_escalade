package com.escalade.siteweb.webapp.action;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.bean.site.Voie;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.TechnicalException;
import com.opensymphony.xwork2.ActionSupport;

public class GestionAjoutModifSite extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres 
	private Pays pays;
	private Region region;
	private Departement departement;

	private List<Pays> listPays;
	private List<Region> listRegion;
	private List<Departement> listDepartement;
	private Site site;
	private List<Secteur> listSecteur;
	private List<Voie> listVoie;

	// ----- Eléments Struts
	private Map<String, Object> session;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAjoutModifSite.class);


	// ===================== Getters/Setters ===============
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Secteur> getListSecteur() {
		return listSecteur;
	}

	public void setListSecteur(List<Secteur> listSecteur) {
		this.listSecteur = listSecteur;
	}
	
	public List<Voie> getListVoie() {
		return listVoie;
	}

	public void setListVoie(List<Voie> listVoie) {
		this.listVoie = listVoie;
	}

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

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;

	}


	// ===================== Méthodes ======================
	public String doAjoutSite() {
		String vResult=ActionSupport.INPUT;
		listPays=managerFactory.getPaysManager().getListPays();
		LOGGER.info("Méthode doAjoutSite()- Liste Pays : "+listPays);
		if(site!=null) {
			if(pays!=null&&region!=null&&departement!=null) {
				LOGGER.info("Après validation du formulaire d'ajout de site - Pays : "+pays);
				LOGGER.info("Après validation du formulaire d'ajout de site - Région : "+region);
				LOGGER.info("Après validation du formulaire d'ajout de site - Département : "+departement);
				Utilisateur utilisateur=(Utilisateur)session.get("user");
				Date date=new Date();
				site.setPays(pays);
				site.setRegion(region);
				site.setDepartement(departement);
				site.setUtilisateur(utilisateur);
				site.setDateAjoutSite(date);
				site.setDateMajSite(date);
				LOGGER.info("Après validation du formulaire d'ajout de site - Site : "+site);
				try {

					LOGGER.info("Après validation du formulaire d'ajout de site - Liste de Secteurs : "+listSecteur);
					//LOGGER.info("Après validation du formulaire d'ajout de site - Liste de Voies : "+listVoie);
			
					managerFactory.getSiteManager().insertSite(site,listSecteur);

				} catch (FunctionalException e) {
					this.addActionError(e.getMessage());
				}catch (TechnicalException e) {
					this.addActionError(e.getMessage());
					vResult=ActionSupport.ERROR;
				}


				vResult=ActionSupport.SUCCESS;
			}else {
				this.addActionError("Certaines champs obligatoires ne sont pas renseignés.");
			}

		}
		LOGGER.info("Méthode doAjoutSite()- vResult : "+vResult);
		return vResult;
	}

	/**
	 * Action AJAX renvoyant la liste des pays
	 * @return success
	 */
	public String doAjaxGetListPays() {
		LOGGER.info("Appel à la méthode doAjaxGetListPays()");
		listPays=managerFactory.getPaysManager().getListPays();
		LOGGER.info("Méthode doAjaxGetListPays() - Liste Pays : "+listPays);
		return ActionSupport.SUCCESS;
	}

	/**
	 * Action AJAX renvoyant la liste des régions d'un pays
	 * @return success/error
	 */
	public String doAjaxGetListRegion() {
		LOGGER.info("Appel à la méthode doAjaxGetListRegion()");
		if (pays==null)
			this.addActionError("Le pays doit être précisé");
		else {
			LOGGER.info("Méthode doAjaxGetListRegion() - Id et Nom du Pays :"+pays.getId() + "-" +pays.getNomPays());
			listRegion=managerFactory.getRegionManager().getListRegion(pays.getId());
		}
		return this.hasActionErrors()?ActionSupport.ERROR:ActionSupport.SUCCESS;
	}

	/**
	 * Action AJAX renvoyant la liste des départements d'une région
	 * @return success/error
	 */
	public String doAjaxGetListDepartement() {
		LOGGER.info("Appel à la méthode doAjaxGetListDepartement()");
		if (region==null)
			this.addActionError("La région doit être précisée");
		else {
			LOGGER.info("Méthode doAjaxGetListDepartement() - Id et Nom de la région :"+region.getId() + "-" +region.getNomRegion());
			listDepartement=managerFactory.getDepartementManager().getListDepartement(region.getId());
		}
		return this.hasActionErrors()?ActionSupport.ERROR:ActionSupport.SUCCESS;
	}

}
