package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface UtilisateurDao {

	List<Utilisateur> getListUtilisateur();

	Utilisateur getUtilisateur(String adresseMail, String motDePasse) throws NotFoundException;

	Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException;

	void updateUtilisateur(Utilisateur utilisateur);

	void updateMdp(Utilisateur utilisateur);

}
