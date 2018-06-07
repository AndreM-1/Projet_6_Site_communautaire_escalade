package com.escalade.siteweb.webapp.action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import com.escalade.siteweb.model.bean.site.Departement;
import com.escalade.siteweb.model.bean.site.Pays;
import com.escalade.siteweb.model.bean.site.Region;
import com.escalade.siteweb.model.bean.site.Secteur;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.bean.site.Voie;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
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
	private Integer id;
	private List<Integer> listChoixNbSecteurs;
	private Integer nbSecteurs;
	private Integer nbSecteursInitial;
	private Integer secteurCourant;
	private List<Integer> listChoixNbVoies;
	private Integer nbVoies;
	private List<Voie> listVoie;

	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;


	//Eléments liés  l'upload
	private File fileSiteUpload;
	private String fileSiteUploadContentType;
	private String fileSiteUploadFileName;

	private List<File> fileSecteurUpload;
	private List<String> fileSecteurUploadContentType;
	private List<String> fileSecteurUploadFileName;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAjoutModifSite.class);


	// ===================== Getters/Setters ===============
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Secteur> getListSecteur() {
		return listSecteur;
	}

	public void setListSecteur(List<Secteur> listSecteur) {
		this.listSecteur = listSecteur;
	}

	public List<Integer> getListChoixNbSecteurs() {
		return listChoixNbSecteurs;
	}

	public void setListChoixNbSecteurs(List<Integer> listChoixNbSecteurs) {
		this.listChoixNbSecteurs = listChoixNbSecteurs;
	}

	public Integer getNbSecteurs() {
		return nbSecteurs;
	}

	public void setNbSecteurs(Integer nbSecteurs) {
		this.nbSecteurs = nbSecteurs;
	}
	
	public Integer getNbSecteursInitial() {
		return nbSecteursInitial;
	}

	public void setNbSecteursInitial(Integer nbSecteursInitial) {
		this.nbSecteursInitial = nbSecteursInitial;
	}

	public Integer getSecteurCourant() {
		return secteurCourant;
	}

	public void setSecteurCourant(Integer secteurCourant) {
		this.secteurCourant = secteurCourant;
	}

	public List<Integer> getListChoixNbVoies() {
		return listChoixNbVoies;
	}

	public void setListChoixNbVoies(List<Integer> listChoixNbVoies) {
		this.listChoixNbVoies = listChoixNbVoies;
	}

	public Integer getNbVoies() {
		return nbVoies;
	}

	public void setNbVoies(Integer nbVoies) {
		this.nbVoies = nbVoies;
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

	public List<File> getFileSecteurUpload() {
		return fileSecteurUpload;
	}

	public void setFileSecteurUpload(List<File> fileSecteurUpload) {
		this.fileSecteurUpload = fileSecteurUpload;
	}

	public List<String> getFileSecteurUploadContentType() {
		return fileSecteurUploadContentType;
	}

	public void setFileSecteurUploadContentType(List<String> fileSecteurUploadContentType) {
		this.fileSecteurUploadContentType = fileSecteurUploadContentType;
	}

	public List<String> getFileSecteurUploadFileName() {
		return fileSecteurUploadFileName;
	}

	public void setFileSecteurUploadFileName(List<String> fileSecteurUploadFileName) {
		this.fileSecteurUploadFileName = fileSecteurUploadFileName;
	}

	// ===================== Méthodes ======================
	public String doAjoutSite() {
		String vResult=ActionSupport.INPUT;
		Utilisateur utilisateur=(Utilisateur)session.get("user");

		listPays=managerFactory.getPaysManager().getListPays();
		listRegion=managerFactory.getRegionManager().getListRegion(listPays.get(0).getId());
		listDepartement=managerFactory.getDepartementManager().getListDepartement(listRegion.get(0).getId());
		LOGGER.info("Méthode doAjoutSite()- Liste Pays : "+listPays);

		if(site!=null) {
			if(site.getPays()!=null&&site.getRegion()!=null&&site.getDepartement()!=null) {
				LOGGER.info("Après validation du formulaire d'ajout de site - Pays : "+site.getPays());
				LOGGER.info("Après validation du formulaire d'ajout de site - Région : "+site.getRegion());
				LOGGER.info("Après validation du formulaire d'ajout de site - Département : "+site.getDepartement());
				Date date=new Date();
				site.setUtilisateur(utilisateur);
				site.setDateAjoutSite(date);
				site.setDateMajSite(date);

				try {
					managerFactory.getSiteManager().insertSite(site);

					try {
						LOGGER.info("Numéro site ajouté : "+managerFactory.getSiteManager().getNumSiteAjoute());
						site=managerFactory.getSiteManager().getSite(managerFactory.getSiteManager().getNumSiteAjoute());
						vResult=ActionSupport.SUCCESS;
					} catch (NotFoundException e) {
						LOGGER.info("Méthode doAjoutSite() : Site non trouvé");
						this.addActionError("Erreur technique lors de l'ajout du site en BDD.");
						vResult=ActionSupport.ERROR;
					}	

				} catch (FunctionalException e) {
					this.addActionError(e.getMessage());
				}catch (TechnicalException e) {
					this.addActionError(e.getMessage());
					vResult=ActionSupport.ERROR;
				}


			}else {
				this.addActionError("Certaines champs obligatoires ne sont pas renseignés.");
			}

		}
		LOGGER.info("Méthode doAjoutSite()- vResult : "+vResult);
		return vResult;
	}

	public String doUploadPhotoSite() {
		String vResult=ActionSupport.INPUT;

		if(id==null) {
			this.addActionError("L'id du site est manquant.");
			vResult=ActionSupport.ERROR;
		}else {
			try {
				site=managerFactory.getSiteManager().getSite(id);
				LOGGER.info("Méthode doUploadPhotoSite - Site en cours d'ajout : "+site);
			} catch (NotFoundException e) {
				LOGGER.info("Méthode doUploadPhotoSite() : Site non trouvé");
				this.addActionError("Erreur technique lors de l'ajout du site en BDD.");
				vResult=ActionSupport.ERROR;
			}
		}

		if(!this.hasErrors()&&fileSiteUpload!=null) {
			String destPathPhoto="";
			String[] tabString;	
			String nomPhotoSite="";
			Boolean bUploadPhotoSite=true;

			try {			
				LOGGER.info("Méthode doUploadPhotoSite - Src (Dossier Temp) File name: " + fileSiteUpload);
				LOGGER.info("Méthode doUploadPhotoSite - Nom initial du fichier photo site :"+fileSiteUploadFileName);

				tabString=fileSiteUploadFileName.split("\\.");

				//On change le nom du fichier à uploader, en reprenant l'extension du fichier initial.
				fileSiteUploadFileName="site_"+site.getId()+"."+tabString[tabString.length-1];
				LOGGER.info("Dst File name: " + fileSiteUploadFileName);

				//On définit le répertoire où sera uploadé la photo du site.
				destPathPhoto=servletRequest.getServletContext().getRealPath("/jsp/assets/images/");
				LOGGER.info("CHEMIN ABSOLU : "+destPathPhoto);

				File destFile  = new File(destPathPhoto, fileSiteUploadFileName);

				//On copie le fichier dans ce répertoire.
				FileUtils.copyFile(fileSiteUpload, destFile);

			} catch (IOException e1) {
				this.addActionError("Echec lors de l'upload du fichier");
				bUploadPhotoSite=false;
				return ActionSupport.ERROR;
			}

			if(bUploadPhotoSite) {

				//On définit le nom de la photo tel qu'il sera en base de données
				nomPhotoSite="jsp/assets/images/"+fileSiteUploadFileName;
				LOGGER.info("Méthode doUploadPhotoSite - nomPhotoSite en BDD :" +nomPhotoSite);
				LOGGER.info("Méthode doUploadPhotoSite - site_id : "+site.getId());

				//Si le site n'a pas de photo en BDD, la photo sera ajoutée. Sinon, rien ne se passe, et
				//on affiche juste un message pour dire que le site a déjà une photo en BDD.
				try {
					managerFactory.getPhotoManager().insertPhotoSite(nomPhotoSite, site.getId());
				} catch (FunctionalException e) {
					LOGGER.info(e.getMessage());
				}
				vResult=ActionSupport.SUCCESS;
			}

		}

		return vResult;
	}

	public String doAjoutSecteur() {
		String vResult=ActionSupport.INPUT;

		if(id==null) {
			this.addActionError("L'id du site est manquant.");
			vResult=ActionSupport.ERROR;
		}else {
			try {
				site=managerFactory.getSiteManager().getSite(id);
				LOGGER.info("Méthode doAjoutSecteur - Site en cours d'ajout : "+site);
			} catch (NotFoundException e) {
				LOGGER.info("Méthode doAjoutSecteur : Site non trouvé");
				this.addActionError("Erreur technique lors de l'ajout du site en BDD.");
				vResult=ActionSupport.ERROR;
			}

			if(!this.hasErrors()) {
				listChoixNbSecteurs=new ArrayList<Integer>();
				for (int i=1;i<=20;i++) {
					listChoixNbSecteurs.add(i);
				}
				LOGGER.info("Méthode doAjoutSecteur - listChoixNbSecteurs : "+listChoixNbSecteurs);
				LOGGER.info("Méthode doAjoutSecteur - nbSecteurs : "+nbSecteurs);	
				LOGGER.info("Méthode doAjoutSecteur - listSecteur : "+listSecteur);	

				if(nbSecteurs!=null&&listSecteur!=null) {
					try {
						managerFactory.getSecteurManager().insertSecteur(listSecteur,site.getId());
						vResult=ActionSupport.SUCCESS;
					} catch (FunctionalException e) {
						LOGGER.info("Méthode doAjoutSecteur :"+e.getMessage());
						this.addActionError("Veuillez renseigner le nom du secteur pour chaque secteur");
					}catch (TechnicalException e) {
						LOGGER.info("Méthode doAjoutSecteur :"+e.getMessage());
						this.addActionError(e.getMessage());
						vResult=ActionSupport.ERROR;
					}
				}
			}

		}

		return vResult;
	}

	public String doAjoutVoie() {
		String vResult=ActionSupport.INPUT;
	
		if(id==null) {
			this.addActionError("L'id du site est manquant.");
			vResult=ActionSupport.ERROR;
		}else {
			try {
				site=managerFactory.getSiteManager().getSite(id);
				listSecteur=managerFactory.getSecteurManager().getListSecteur(id);
				LOGGER.info("Méthode doAjoutVoie - Secteurs en cours d'ajout : "+listSecteur);	
			} catch (NotFoundException e) {
				LOGGER.info("Méthode doAjoutVoie : Site/Secteurs non trouvés");
				this.addActionError("Erreur technique lors de l'ajout du site en BDD.");
				vResult=ActionSupport.ERROR;
			}

			if(!this.hasErrors()) {

				listChoixNbVoies=new ArrayList<Integer>();
				for (int i=1;i<=20;i++) {
					listChoixNbVoies.add(i);
				}
				LOGGER.info("Méthode doAjoutVoie - listChoixNbVoies : "+listChoixNbVoies);

				if(secteurCourant==null) {
					nbSecteursInitial=nbSecteurs;
					if(nbSecteurs==listSecteur.size()) {
						secteurCourant=1;
						LOGGER.info("Méthode doAjoutVoie - secteurCourant null :"+secteurCourant);
					}else {
						secteurCourant=listSecteur.size()-nbSecteurs+1;
						nbSecteurs=listSecteur.size();
					}
				}
				LOGGER.info("Méthode doAjoutVoie - secteurCourant : "+secteurCourant);
				LOGGER.info("Méthode doAjoutVoie - nbVoies : "+nbVoies);
				LOGGER.info("Méthode doAjoutVoie - listVoie : "+listVoie);

				if(secteurCourant!=null&&nbVoies!=null&&listVoie!=null) {
					int secteurId=listSecteur.get(secteurCourant-1).getId();
					LOGGER.info("Méthode doAjoutVoie - secteurId : "+secteurId);
					LOGGER.info("Méthode doAjoutVoie - listVoie : "+listVoie);

					//Appel à la couche business
					try {
						managerFactory.getVoieManager().insertVoie(listVoie,secteurId);

						if(secteurCourant==nbSecteurs) {
							LOGGER.info("Les voies ont été ajoutées pour tous les secteurs!");
							nbSecteurs=nbSecteursInitial;
							vResult=ActionSupport.SUCCESS;
						}
						nbVoies=null;
						secteurCourant++;
					} catch (FunctionalException e) {
						LOGGER.info("Méthode doAjoutVoie :"+e.getMessage());
						this.addActionError(e.getMessage());
					} catch (TechnicalException e) {
						LOGGER.info("Méthode doAjoutVoie :"+e.getMessage());
						this.addActionError(e.getMessage());
						vResult=ActionSupport.ERROR;
					}		
				}
				if(secteurCourant!=null&&nbVoies==null&&listVoie==null) {
					if(secteurCourant>nbSecteurs) {
						LOGGER.info("Les voies ont été ajoutées pour tous les secteurs!");
						nbSecteurs=nbSecteursInitial;
						vResult=ActionSupport.SUCCESS;
					}
				}
			}	
		}

		return vResult;
	}

	public String doUploadPhotoSecteur(){
		String vResult=ActionSupport.INPUT;

		if(id==null) {
			this.addActionError("L'id du site est manquant.");
			vResult=ActionSupport.ERROR;
		}else {
			try {
				site=managerFactory.getSiteManager().getSite(id);
				listSecteur=managerFactory.getSecteurManager().getListSecteur(id);
				LOGGER.info("Méthode doUploadPhotoSecteur - Secteurs en cours d'ajout : "+listSecteur);	
				LOGGER.info("Méthode doUploadPhotoSecteur - secteurCourant init: "+secteurCourant);
				LOGGER.info("Méthode doUploadPhotoSecteur - nbSecteurs init: "+nbSecteurs);

			} catch (NotFoundException e) {
				LOGGER.info("Méthode doUploadPhotoSecteur : Site/Secteurs non trouvés");
				this.addActionError("Erreur technique lors de l'ajout du site en BDD.");
				vResult=ActionSupport.ERROR;
			}

			if(!this.hasErrors()) {
			
				if(secteurCourant==null) {
					if(nbSecteurs==listSecteur.size()) {
						secteurCourant=1;
						LOGGER.info("Méthode doUploadPhotoSecteur - secteurCourant null :"+secteurCourant);	
					}else {
						secteurCourant=listSecteur.size()-nbSecteurs+1;
						nbSecteurs=listSecteur.size();
					}
				}
				
				if(fileSecteurUpload!=null) {
					int secteurId=listSecteur.get(secteurCourant-1).getId();
					int numPhotoSecteur=0;
					int nbFichiersUploades=0;
					LOGGER.info("Méthode doUploadPhotoSecteur - secteurId : "+secteurId);
					String destPathPhoto="";
					String[] tabString;	
					String nomPhotoSecteur="";
					Boolean bUploadPhotoSecteur;
					for(File fileSecteur :fileSecteurUpload) {
						LOGGER.info("Méthode doUploadPhotoSecteur - Src (Dossier Temp) File name : "+fileSecteur);
					}
					for(String fileNameSecteur :fileSecteurUploadFileName) {
						bUploadPhotoSecteur=true;
						LOGGER.info("Méthode doUploadPhotoSecteur - Nom initial du fichier : "+fileSecteurUploadFileName);
						numPhotoSecteur++;
						tabString=fileNameSecteur.split("\\.");

						//On change le nom du fichier à uploader, en reprenant l'extension du fichier initial.
						fileNameSecteur="secteur_"+secteurId+numPhotoSecteur+"."+tabString[tabString.length-1];
						LOGGER.info("Dst File name: " + fileNameSecteur);			

						//On définit le répertoire où sera uploadé la photo du site.
						destPathPhoto=servletRequest.getServletContext().getRealPath("/jsp/assets/images/");
						LOGGER.info("CHEMIN ABSOLU : "+destPathPhoto);
						
						File destFile  = new File(destPathPhoto, fileNameSecteur);
						
						//On copie le fichier dans ce répertoire.
						try {
							FileUtils.copyFile(fileSecteurUpload.get(numPhotoSecteur-1), destFile);
							nbFichiersUploades++;
						} catch (IOException e) {
							this.addActionError("Echec lors de l'upload du fichier lié à la photo "+numPhotoSecteur+ "du secteur.");
							bUploadPhotoSecteur=false;
				
						}
						
						if(bUploadPhotoSecteur) {
							//On définit le nom de la photo tel qu'il sera en base de données
							nomPhotoSecteur="jsp/assets/images/"+fileNameSecteur;
							LOGGER.info("Méthode doUploadPhotoSecteur - nomPhotoSecteur en BDD :" +nomPhotoSecteur);
							LOGGER.info("Méthode doUploadPhotoSecteur - secteur_id : "+secteurId);
							
							//Si le secteur n'a pas de photo en BDD, la photo sera ajoutée. Sinon, rien ne se passe, et
							//on affiche juste un message pour dire que le secteur a déjà une photo en BDD.
							try {
								managerFactory.getPhotoManager().insertPhotoSecteur(nomPhotoSecteur,secteurId);
							} catch (FunctionalException e) {
								LOGGER.info(e.getMessage());
							}
							
							
						}	
					}
					
					if(nbFichiersUploades==fileSecteurUploadFileName.size()) {
						LOGGER.info("Toutes les photos ont bien été uploadées.");	
						secteurCourant++;
					}
					
				}
				
				if(secteurCourant>nbSecteurs) {
					LOGGER.info("Les photos ont été ajoutées pour tous les secteurs!");
					vResult=ActionSupport.SUCCESS;
				}
			}
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
