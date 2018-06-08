package com.escalade.siteweb.consumer.contract.dao;

import java.util.List;

import com.escalade.siteweb.model.bean.photo.Photo;
import com.escalade.siteweb.model.exception.FunctionalException;

/**
 * Dao du package « Photo »
 * @author André Monnier
 */
public interface PhotoDao {

	/**
	 * Méthode permettant de renvoyer la liste des photos.
	 * @return List
	 */
	List<Photo> getListPhoto();

	/**
	 * Méthode permettant de renvoyer un objet de type Photo
	 * pour un site donné.
	 * @param siteId : L'identifiant du site
	 * @return Un objet de type {@link Photo}
	 */
	Photo getPhotoSite(int siteId);

	/**
	 * Méthode permettant de renvoyer un objet de type Photo
	 * pour un utilisateur donné.
	 * @param utilisateurId : L'identifiant de l'utilisateur
	 * @return Un objet de type {@link Photo}
	 */
	Photo getPhotoUtilisateur(int utilisateurId);

	/**
	 * Méthode permettant de renvoyer la liste des photos
	 * de tous les secteurs d'un site.
	 * @param siteId : L'identifiant du site
	 * @return List
	 */
	List<Photo> getListPhotoAllSecteur(int siteId);
	
	/**
	 * Méthode permettant de renvoyer la liste des photos d'un secteur.
	 * @param secteurId : L'identifiant du secteur.
	 * @return List
	 */
	List<Photo> getListPhotoSecteur(int secteurId);

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