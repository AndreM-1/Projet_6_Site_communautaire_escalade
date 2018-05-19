package com.escalade.siteweb.webapp.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;

import com.escalade.siteweb.business.contract.ManagerFactory;
import com.escalade.siteweb.model.bean.utilisateur.FormulaireContact;
import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.opensymphony.xwork2.ActionSupport;

public class GestionFormulaireContact extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ----- Eléments en entrée
	private FormulaireContact formulaireContact;
	
	//----- Eléments en sortie.
	private List<FormulaireContact> listFormulaireContact;

	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	
	// ===================== Getters/Setters =====================
	public FormulaireContact getFormulaireContact() {
		return formulaireContact;
	}

	public void setFormulaireContact(FormulaireContact formulaireContact) {
		this.formulaireContact = formulaireContact;
	}
	
	public List<FormulaireContact> getListFormulaireContact() {
		return listFormulaireContact;
	}

	public void setListFormulaireContact(List<FormulaireContact> listFormulaireContact) {
		this.listFormulaireContact = listFormulaireContact;
	}
	
	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;
		
	}
	
	// ===================== Méthodes =====================
	/**
	 * Action permettant d'envoyer un formulaire de contact
	 * @return input/success
	 */
	public String doEnvoiFormContact() {
		// Si (this.formulaireContact == null) c'est que l'on entre dans le formulaire de contact
		// Sinon, c'est que l'on vient de valider le formulaire de contact
		
		// Par défaut, le result est "input
		String vResult=ActionSupport.INPUT;
		Utilisateur utilisateur=(Utilisateur)session.get("user");
		Boolean bUtil;
		
		//Validation du formulaire de contact (formulaireContact != null)
		if(formulaireContact!=null) {
			if (utilisateur==null) {
				try {
					System.out.println(formulaireContact.getNomNa());
					System.out.println(formulaireContact.getAdresseMailNa());
					System.out.println(formulaireContact.getObjet());
					System.out.println(formulaireContact.getMessage());
					bUtil=false;
					formulaireContact.setDateFormContact(new Date());
					managerFactory.getFormulaireContactManager().insertFormulaireContact(formulaireContact,bUtil);
					vResult=ActionSupport.SUCCESS;
				} catch (FunctionalException e) {
					this.addActionError(e.getMessage());
				}
				
			}else {
				try {
					formulaireContact.setNomNa(utilisateur.getPseudo());
					formulaireContact.setAdresseMailNa(utilisateur.getAdresseMail());
					formulaireContact.setUtilisateur(utilisateur);
					formulaireContact.setDateFormContact(new Date());
					System.out.println(utilisateur.getId());
					System.out.println(formulaireContact.getNomNa());
					System.out.println(formulaireContact.getAdresseMailNa());
					System.out.println(formulaireContact.getObjet());
					System.out.println(formulaireContact.getMessage());	
					bUtil=true;
					managerFactory.getFormulaireContactManager().insertFormulaireContact(formulaireContact,bUtil);
					vResult=ActionSupport.SUCCESS;
				} catch (FunctionalException e) {
					this.addActionError(e.getMessage());;
				}
			}	
		}
		return vResult;
	}
	
	
	public String doVisuFormContact() {
		listFormulaireContact=managerFactory.getFormulaireContactManager().getListFormulaireContact();
		return ActionSupport.SUCCESS;
	}

}
