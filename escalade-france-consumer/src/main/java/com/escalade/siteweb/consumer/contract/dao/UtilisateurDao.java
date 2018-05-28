package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface UtilisateurDao {

	List<Utilisateur> getListUtilisateur();

	Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException;

	void updateUtilisateur(Utilisateur utilisateur) throws FunctionalException;

	void updateMdp(Utilisateur utilisateur);

	void insertUtilisateur(Utilisateur utilisateur) throws FunctionalException;

	Utilisateur getUtilisateur(String adresseMail) throws NotFoundException;

}
