package com.escalade.siteweb.webapp.action;

import java.io.File;
import java.io.IOException;
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
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;

public class GestionAffichageUtilisateur extends ActionSupport implements SessionAware, ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres en entrée
	private Integer id;
	private String ancienMotDePasse;
	private String nouveauMotDePasse;
	private String confirmationNouveauMotDePasse;
	private Photo photoUtilisateur;

	// ----- Eléments en sortie
	private List<Site> listSite;

	//Eléments en entrée et sortie
	private Utilisateur utilisateur;

	private String pseudoInitial="",pseudoFinal="";

	private Boolean funcException=false;

	//Eléments liés  l'upload
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;

	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAffichageUtilisateur.class);

	// ===================== Getters/Setters ===============
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Photo getPhotoUtilisateur() {
		return photoUtilisateur;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public void setPhotoUtilisateur(Photo photoUtilisateur) {
		this.photoUtilisateur = photoUtilisateur;
	}

	public List<Site> getListSite() {
		return listSite;
	}


	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}

	public String getAncienMotDePasse() {
		return ancienMotDePasse;
	}


	public void setAncienMotDePasse(String ancienMotDePasse) {
		this.ancienMotDePasse = ancienMotDePasse;
	}


	public String getNouveauMotDePasse() {
		return nouveauMotDePasse;
	}


	public void setNouveauMotDePasse(String nouveauMotDePasse) {
		this.nouveauMotDePasse = nouveauMotDePasse;
	}


	public String getConfirmationNouveauMotDePasse() {
		return confirmationNouveauMotDePasse;
	}


	public void setConfirmationNouveauMotDePasse(String confirmationNouveauMotDePasse) {
		this.confirmationNouveauMotDePasse = confirmationNouveauMotDePasse;
	}

	public File getFileUpload() {
		return fileUpload;
	}


	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}


	public String getFileUploadContentType() {
		return fileUploadContentType;
	}


	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}


	public String getFileUploadFileName() {
		return fileUploadFileName;
	}


	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;

	}

	@Override
	public void setServletRequest(HttpServletRequest pRequest) {
		this.servletRequest=pRequest;

	}


	/**
	 * Action affichant les détails d'un {@link Utilisateur}
	 * @return success / error
	 */
	public String doDetailUtilisateur() {
		LOGGER.info("Entrée dans la méthode doDetailUtilisateur");
		if (id == null) {
			this.addActionError("Vous devez indiquer un id d'utilisateur");
		} else {
			try {
				utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(id); 
				LOGGER.info("Utilisateur initial :"+utilisateur);
			} catch (NotFoundException pE) {
				this.addActionError("Utilisateur non trouvé. ID = " + id);
			}

			try {
				listSite=managerFactory.getSiteManager().getListSite(id);
			} catch (NotFoundException e) {
				this.addActionMessage("L'utilisateur n'a pas encore posté de site");
			}
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	public String doUpdateUtilisateur() {

		String vResult = ActionSupport.INPUT;

		LOGGER.info("Entrée dans la méthode doUpdateUtilisateur");

		if(utilisateur==null) {
			this.addActionError("Aucun utilisateur n'a été récupéré");
			vResult="error";
		}else {
			try {
				pseudoInitial=managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPseudo();
				utilisateur.setMotDePasse("MotDePasse");
				utilisateur.setPhotoUtilisateur(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPhotoUtilisateur());
			} catch (NotFoundException e) {
				this.addActionError("Utilisateur non trouvé. ID = " + id);
				vResult="error";
			}
			LOGGER.info("Utilisateur récupéré : "+utilisateur);
			LOGGER.info("pseudoInitial :"+pseudoInitial);
			try {
				managerFactory.getUtilisateurManager().updateUtilisateur(utilisateur);
			} catch (FunctionalException e) {
				funcException=true;
				this.addActionError(e.getMessage());
			}	
			pseudoFinal=utilisateur.getPseudo();
			LOGGER.info("pseudoFinal :"+pseudoFinal);

			if(!pseudoFinal.equals(pseudoInitial)&&!pseudoFinal.isEmpty()&&pseudoFinal.trim().length()!=0&&funcException!=true) {
				vResult="success-deconnexion-chgt-pseudo";
			}else {
				if(pseudoFinal.isEmpty()||pseudoFinal.trim().length()==0||funcException)
					utilisateur.setPseudo(pseudoInitial);
				vResult=ActionSupport.SUCCESS;
			}

			LOGGER.info("vResult :"+vResult);
		}

		return vResult;
	}

	public String doUpdateMdp() {

		String vResult = ActionSupport.SUCCESS;
		String adresseMail="";
		Boolean funcExc=false;
		LOGGER.info("Méthode doUpdateMdp - Utilisateur :"+utilisateur);
		LOGGER.info("Méthode doUpdateMdp - Ancien mot de Passe :"+ancienMotDePasse);
		LOGGER.info("Méthode doUpdateMdp - Nouveau mot de Passe :"+nouveauMotDePasse);
		LOGGER.info(confirmationNouveauMotDePasse);
		if(utilisateur==null) {
			this.addActionError("Aucun utilisateur n'a été récupéré");
			vResult="error";
		}else {
			try {
				utilisateur.setCivilite(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getCivilite());
				utilisateur.setNom(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getNom());
				utilisateur.setPrenom(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPrenom());
				utilisateur.setPseudo(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPseudo());
				adresseMail=managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getAdresseMail();
				utilisateur.setAdresseMail(adresseMail);
				utilisateur.setPhotoUtilisateur(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPhotoUtilisateur());
			} catch (NotFoundException e) {
				this.addActionError("Utilisateur non trouvé. ID = " + id);
				vResult="error";
			}

			try {
				utilisateur=managerFactory.getUtilisateurManager().getUtilisateur(adresseMail, ancienMotDePasse);
				LOGGER.info("Méthode doUpdateMdp - Utilisateur :"+utilisateur);
			} catch (NotFoundException e1) {
				this.addActionError("Votre mot de passe actuel n'est pas correct.");
				funcExc=true;
			}

			if(!funcExc) {
				if(!confirmationNouveauMotDePasse.equals(nouveauMotDePasse)) {
					this.addActionError("Incohérence dans la saisie du nouveau mot de passe");
				}else {
					try {
						utilisateur.setMotDePasse(confirmationNouveauMotDePasse);
						managerFactory.getUtilisateurManager().updateMdp(utilisateur);
					} catch (FunctionalException e) {
						this.addActionError(e.getMessage());
					}	
				}
			}


		}
		return vResult;
	}

	public String doUploadPhotoUtil() {

		String destPath="";
		String[] tabString;	
		String vResult="";
		String nomPhoto="";

		try {
			LOGGER.info("Utilisateur récupéré suite à l'upload d'une nouvelle photo: "+utilisateur);
			LOGGER.info("Src (Dossier Temp) File name: " + fileUpload);
			LOGGER.info("Nom initial du fichier :"+fileUploadFileName);
			tabString=fileUploadFileName.split("\\.");

			//On change le nom du fichier à uploader, en reprenant l'extension du fichier initial.
			fileUploadFileName="utilisateur_"+utilisateur.getId()+"."+tabString[tabString.length-1];
			LOGGER.info("Dst File name: " + fileUploadFileName);

			//On définit le répertoire où sera uploadé le fichier.
			destPath=servletRequest.getServletContext().getRealPath("/jsp/assets/images/");
			LOGGER.info("CHEMIN ABSOLU : "+destPath);

			File destFile  = new File(destPath, fileUploadFileName);

			//On copie le fichier dans ce répertoire.
			FileUtils.copyFile(fileUpload, destFile);

			//On définit le nom de la photo tel qu'il sera en base de données
			nomPhoto="jsp/assets/images/"+fileUploadFileName;
			LOGGER.info("nom_photo :" +nomPhoto);
			LOGGER.info("utilisateur_id :" +utilisateur.getId());

			//Si l'utilisateur n'a pas de photo en BDD, la photo sera ajoutée. Sinon, rien ne se passe, et
			//on affiche juste un message pour dire que l'utilisateur a déjà une photo en BDD.
			try {
				managerFactory.getPhotoManager().insertPhotoUtilisateur(nomPhoto,utilisateur.getId());
			} catch (FunctionalException fEx) {
				LOGGER.info(fEx.getMessage());

			}

			//On récupère l'utilisateur (i.e. l'ensemble de ces attributs) qui correspond à notre Id d'utilisateur
			try {
				utilisateur=managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId());
			} catch (NotFoundException e) {
				LOGGER.info("Utilisateur non trouvé. ID = " + utilisateur.getId());
				vResult=ActionSupport.ERROR;
			}

			vResult=ActionSupport.SUCCESS;

		} catch(IOException e) {
			e.printStackTrace();
			this.addActionError("Echec lors de l'upload du fichier");
			return ActionSupport.ERROR;
		}

		LOGGER.info("vResult : "+vResult);
		return vResult;

	}
}
