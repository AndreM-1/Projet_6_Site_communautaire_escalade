package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.NotFoundException;

public interface UtilisateurDao {

	List<Utilisateur> getListUtilisateur();

	Utilisateur getUtilisateur(int utilisateurId);

	Utilisateur getUtilisateur(String adresseMail, String motDePasse) throws NotFoundException;

}
