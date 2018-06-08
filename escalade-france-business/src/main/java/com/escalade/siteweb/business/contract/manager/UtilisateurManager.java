package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.utilisateur.Utilisateur;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;

/**
 * Manager du package « Utilisateur »
 * @author André Monnier
 */
public interface UtilisateurManager {

	/**
	 * Méthode permettant de renvoyer la liste des utilisateurs.
	 * @return List
	 */
	List<Utilisateur> getListUtilisateur();

	/**
	 * Méthode permettant de renvoyer un utilisateur en fonction de son adresse mail et de son mot de passe.
	 * @param adresseMail : L'adresse mail de l'utilisateur
	 * @param motDePasse : Le mot de passe de l'utilisateur
	 * @return Un objet de type {@link Utilisateur}
	 * @throws NotFoundException
	 */
	Utilisateur getUtilisateur(String adresseMail, String motDePasse) throws NotFoundException;

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
	 * @throws FunctionalException
	 */
	void updateMdp(Utilisateur utilisateur) throws FunctionalException;

	/**
	 * Méthode permettant d'enregistrer un utilisateur en base de données.
	 * @param utilisateur : L'utilisateur
	 * @throws FunctionalException
	 */
	void insertUtilisateur(Utilisateur utilisateur) throws FunctionalException;
}