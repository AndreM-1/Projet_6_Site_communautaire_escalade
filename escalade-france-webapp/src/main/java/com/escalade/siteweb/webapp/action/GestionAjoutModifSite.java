package com.escalade.siteweb.webapp.action;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.photo.Photo;
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

public class GestionAjoutModifSite extends ActionSupport implements SessionAware, ServletRequestAware {

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


	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;


	//Eléments liés  l'upload
	private File fileSiteUpload;
	private String fileSiteUploadContentType;
	private String fileSiteUploadFileName;
	
	private String nomPhotoSite;

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

	@Override
	public void setServletRequest(HttpServletRequest pRequest) {
		this.servletRequest=pRequest;

	}

	public File getFileSiteUpload() {
		return fileSiteUpload;
	}

	public void setFileSiteUpload(File fileSiteUpload) {
		this.fileSiteUpload = fileSiteUpload;
	}

	public String getFileSiteUploadContentType() {
		return fileSiteUploadContentType;
	}

	public void setFileSiteUploadContentType(String fileSiteUploadContentType) {
		this.fileSiteUploadContentType = fileSiteUploadContentType;
	}

	public String getFileSiteUploadFileName() {
		return fileSiteUploadFileName;
	}

	public void setFileSiteUploadFileName(String fileSiteUploadFileName) {
		this.fileSiteUploadFileName = fileSiteUploadFileName;
	}
	
	public String getNomPhotoSite() {
		return nomPhotoSite;
	}

	public void setNomPhotoSite(String nomPhotoSite) {
		this.nomPhotoSite = nomPhotoSite;
	}

	// ===================== Méthodes ======================
	public String doAjoutSite() {
		String vResult=ActionSupport.INPUT;
		Utilisateur utilisateur=(Utilisateur)session.get("user");
		Site siteEnSession=null;
		listPays=managerFactory.getPaysManager().getListPays();
		listRegion=managerFactory.getRegionManager().getListRegion(listPays.get(0).getId());
		listDepartement=managerFactory.getDepartementManager().getListDepartement(listRegion.get(0).getId());
		LOGGER.info("Méthode doAjoutSite()- Liste Pays : "+listPays);
		

		if(site!=null) {
			
			if(site.getPays()!=null&&site.getRegion()!=null&&site.getDepartement()!=null) {
				LOGGER.info("Après validation du formulaire d'ajout de site - Pays : "+site.getPays());
				LOGGER.info("Après validation du formulaire d'ajout de site - Région : "+site.getRegion());
				LOGGER.info("Après validation du formulaire d'ajout de site - Département : "+site.getDepartement());
				
				//Ajout de variables en session
				this.session.put("listPaysPaj", listPays);
				this.session.put("listRegionPaj", listRegion);
				this.session.put("listDepartementPaj", listDepartement);
				Date date=new Date();
				site.setUtilisateur(utilisateur);
				site.setDateAjoutSite(date);
				site.setDateMajSite(date);
				
				//Ajout de la variable site en session
				this.session.put("siteToAdd", site);
				siteEnSession=(Site)session.get("siteToAdd");
				LOGGER.info("Méthode doAjoutSite : Vérification si un site est en session : "+siteEnSession);	

				try {
					for(Secteur secteur :site.getListSecteur()) {
						LOGGER.info(" Nom du secteur : "+secteur.getNomSecteur());
						for(Voie voie :secteur.getListVoie()) {
							LOGGER.info("Après validation du formulaire d'ajout de site - Liste de Voies : "+voie.getNomVoie());
						}
					}

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
			
			LOGGER.info("Après validation du formulaire d'ajout de site - Site : "+site);

		}
		LOGGER.info("Méthode doAjoutSite()- vResult : "+vResult);
		return vResult;
	}
	
	@SuppressWarnings("unchecked")
	public String doUploadPhotoSite() {
		String vResult=ActionSupport.INPUT;
		Utilisateur utilisateur=(Utilisateur)session.get("user");
		Date date=new Date();
		site.setUtilisateur(utilisateur);
		site.setDateAjoutSite(date);
		site.setDateMajSite(date);
		//Ajout de variable site en session
		this.session.put("siteToAdd", site);
		site=(Site)session.get("siteToAdd");
		
		
	    listPays=(List<Pays>)session.get("listPaysPaj");
	    listRegion=(List<Region>)session.get("listRegionPaj");
	    listDepartement=(List<Departement>)session.get("listDepartementPaj");
		
		LOGGER.info("Méthode doUploadPhotoSite - Utilisateur : "+utilisateur);

		try {
			String destPathPhoto="";
			String[] tabString;	
			LOGGER.info("Méthode doUploadPhotoSite - Src (Dossier Temp) File name: " + fileSiteUpload);
			LOGGER.info("Méthode doUploadPhotoSite - Nom initial du fichier photo site :"+fileSiteUploadFileName);

			tabString=fileSiteUploadFileName.split("\\.");

			//On change le nom du fichier à uploader, en reprenant l'extension du fichier initial.
			fileSiteUploadFileName="utilisateur_"+utilisateur.getId()+"_site_on_going."+tabString[tabString.length-1];
			LOGGER.info("Dst File name: " + fileSiteUploadFileName);

			//On définit le répertoire où sera uploadé la photo du site.
			destPathPhoto=servletRequest.getServletContext().getRealPath("/jsp/assets/images/");
			LOGGER.info("CHEMIN ABSOLU : "+destPathPhoto);

			File destFile  = new File(destPathPhoto, fileSiteUploadFileName);

			//On copie le fichier dans ce répertoire.
			FileUtils.copyFile(fileSiteUpload, destFile);
			
			nomPhotoSite="jsp/assets/images/"+fileSiteUploadFileName;
			Photo photoSite=new Photo();
			photoSite.setNomPhoto(nomPhotoSite);
			site.setPhotoSite(photoSite);
			vResult=ActionSupport.SUCCESS;

		} catch (IOException e1) {
			this.addActionError("Echec lors de l'upload du fichier");
			return ActionSupport.ERROR;
		}
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
