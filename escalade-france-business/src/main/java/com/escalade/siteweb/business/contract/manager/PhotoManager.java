package com.escalade.siteweb.business.contract.manager;

import java.util.List;

import com.escalade.siteweb.model.bean.photo.Photo;
import com.escalade.siteweb.model.exception.FunctionalException;

/**
 * Manager du package « Photo »
 * @author André Monnier
 */
public interface PhotoManager {

	/**
	 * Méthode permettant de renvoyer la liste des photos.
	 * @return List
	 */
	List<Photo> getListPhoto();

	/**
	 * Méthode permettant d'insérer une photo de l'utilisateur en base de données.
	 * @param nomPhoto : Le nom de la photo ou plus exactement le chemin relatif vers le fichier.
	 * @param utilisateurId : L'identifiant de l'utilisateur
	 * @throws FunctionalException
	 */
	void insertPhotoUtilisateur(String nomPhoto, int utilisateurId) throws FunctionalException;

	/**
	 * Méthode permettant d'insérer une photo du site en base de données.
	 * @param nomPhoto : Le nom de la photo ou plus exactement le chemin relatif vers le fichier
	 * @param siteId : L'identifiant du site
	 * @throws FunctionalException
	 */
	void insertPhotoSite(String nomPhoto, int siteId) throws FunctionalException;

	/**
	 * Méthode permettant d'insérer une photo du secteur en base de données.
	 * Un secteur peut comporter entre 0 et 3 photos.
	 * @param nomPhotoSecteur : Le nom de la photo ou plus exactement le chemin relatif vers le fichier
	 * @param secteurId : L'identifiant du secteur
	 * @throws FunctionalException
	 */
	void insertPhotoSecteur(String nomPhotoSecteur, int secteurId) throws FunctionalException;
}