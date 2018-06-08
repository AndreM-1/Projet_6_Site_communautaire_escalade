package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;

/**
 * Dao du package « Utilisateur »
 * @author André Monnier
 */
public interface UtilisateurDao {

	/**
	 * Méthode permettant de renvoyer la liste des utilisateurs.
	 * @return List
	 */
	List<Utilisateur> getListUtilisateur();

	/**
	 * Méthode permettant de renvoyer un utilisateur en fonction de son identifiant.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @return Un objet de type {@link Utilisateur}
	 * @throws NotFoundException
	 */
	Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException;

	/**
	 * Méthode permettant de mettre à jour les informations relatives à l'utilisateur.
	 * @param utilisateur : L'utilisateur
	 * @throws FunctionalException
	 */
	void updateUtilisateur(Utilisateur utilisateur) throws FunctionalException;
	
	/**
	 * Méthode permettant de mettre à jour le mot de passe de l'utilisateur.
	 * A noter que le mot de passe est crypté en base de données.
	 * @param utilisateur : L'utilisateur
	 */
	void updateMdp(Utilisateur utilisateur);

	/**
	 * Méthode permettant d'enregistrer un utilisateur en base de données.
	 * @param utilisateur : L'utilisateur
	 * @throws FunctionalException
	 */
	void insertUtilisateur(Utilisateur utilisateur) throws FunctionalException;

	/**
	 * Méthode permettant de renvoyer un utilisateur en fonction de son adresse mail.
	 * @param adresseMail : L'adresse mail de l'utilisateur
	 * @return Un objet de type {@link Utilisateur}
	 * @throws NotFoundException
	 */
	Utilisateur getUtilisateur(String adresseMail) throws NotFoundException;
}
