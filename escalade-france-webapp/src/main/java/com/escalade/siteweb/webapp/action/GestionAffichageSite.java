package com.escalade.siteweb.webapp.action;

import javax.inject.Inject;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;

public class GestionAffichageSite extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres en entrée
	private Integer id;


	// ----- Eléments en sortie
	private Site site;

	// ===================== Getters/Setters ===============
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	// ===================== Méthodes ======================

	/**
	 * Action affichant les détails d'un {@link Site}
	 * @return success / error
	 */
	public String doDetailSite() {
		if (id == null) {
			this.addActionError("L'id du site est manquant.");
		} else {
			try {
				site=managerFactory.getSiteManager().getSite(id);
			} catch (NotFoundException pEx) {
				this.addActionError("Site non trouvé. ID= "+id);
			}
		}
		return (this.hasErrors())?ActionSupport.ERROR:ActionSupport.SUCCESS;
	}
}