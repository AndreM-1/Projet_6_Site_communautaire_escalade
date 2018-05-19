package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface UtilisateurManager {

	List<Utilisateur> getListUtilisateur();

	Utilisateur getUtilisateur(String adresseMail, String motDePasse) throws NotFoundException;

	Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException;

	void updateUtilisateur(Utilisateur utilisateur) throws FunctionalException;

	void updateMdp(Utilisateur utilisateur) throws FunctionalException;

	void insertUtilisateur(Utilisateur utilisateur) throws FunctionalException;
}