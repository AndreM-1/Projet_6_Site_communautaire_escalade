package com.escalade.siteweb.webapp.action;

import java.util.List;

import javax.inject.Inject;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.site.Site;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;

public class GestionAffichageUtilisateur extends ActionSupport {

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

	// ----- Eléments en sortie
	private List<Site> listSite;

	//Eléments en entrée et sortie
	private Utilisateur utilisateur;

	private String pseudoInitial="",pseudoFinal="";

	private Boolean funcException=false;


	// ===================== Getters/Setters ===============
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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


	/**
	 * Action affichant les détails d'un {@link Utilisateur}
	 * @return success / error
	 */
	public String doDetailUtilisateur() {
		if (id == null) {
			this.addActionError("Vous devez indiquer un id d'utilisateur");
		} else {
			try {
				utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(id); 
				System.out.println("Utilisateur initial :"+utilisateur);
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

		String vResult = "";

		if(utilisateur==null) {
			this.addActionError("Aucun utilisateur n'a été récupéré");
			vResult="error";
		}else {
			try {
				pseudoInitial=managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPseudo();
				utilisateur.setMotDePasse(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getMotDePasse());
				utilisateur.setPhotoUtilisateur(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPhotoUtilisateur());
			} catch (NotFoundException e) {
				this.addActionError("Utilisateur non trouvé. ID = " + id);
				vResult="error";
			}
			System.out.println("Utilisateur récupéré"+utilisateur);
			System.out.println("pseudoInitial :"+pseudoInitial);
			try {
				managerFactory.getUtilisateurManager().updateUtilisateur(utilisateur);
			} catch (FunctionalException e) {
				funcException=true;
				this.addActionError(e.getMessage());
			}	
			pseudoFinal=utilisateur.getPseudo();
			System.out.println("pseudoFinal :"+pseudoFinal);

			if(!pseudoFinal.equals(pseudoInitial)&&!pseudoFinal.isEmpty()&&pseudoFinal.trim().length()!=0&&funcException!=true) {
				vResult="success-deconnexion-chgt-pseudo";
			}else {
				vResult=ActionSupport.SUCCESS;
			}

			System.out.println("vResult :"+vResult);
		}

		return vResult;
	}

	public String doUpdateMdp() {

		String vResult = ActionSupport.SUCCESS;
		System.out.println(utilisateur);
		System.out.println(ancienMotDePasse);
		System.out.println(nouveauMotDePasse);
		System.out.println(confirmationNouveauMotDePasse);
		if(utilisateur==null) {
			this.addActionError("Aucun utilisateur n'a été récupéré");
			vResult="error";
		}else {
			try {
				utilisateur.setCivilite(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getCivilite());
				utilisateur.setNom(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getNom());
				utilisateur.setPrenom(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPrenom());
				utilisateur.setPseudo(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPseudo());
				utilisateur.setAdresseMail(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getAdresseMail());
				utilisateur.setMotDePasse(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getMotDePasse());
				utilisateur.setPhotoUtilisateur(managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getId()).getPhotoUtilisateur());
			} catch (NotFoundException e) {
				this.addActionError("Utilisateur non trouvé. ID = " + id);
				vResult="error";
			}

			if(!ancienMotDePasse.equals(utilisateur.getMotDePasse())||!confirmationNouveauMotDePasse.equals(nouveauMotDePasse)) {
				this.addActionError("Champs erronés");
			}else {
				try {
					utilisateur.setMotDePasse(confirmationNouveauMotDePasse);
					managerFactory.getUtilisateurManager().updateMdp(utilisateur);
				} catch (FunctionalException e) {
					this.addActionError(e.getMessage());
				}	
			}
		}
		return vResult;
	}
}
