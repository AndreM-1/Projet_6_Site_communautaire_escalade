package com.escalade.siteweb.business.contract;

import com.escalade.siteweb.business.contract.manager.CommentaireManager;
import com.escalade.siteweb.business.contract.manager.DepartementManager;
import com.escalade.siteweb.business.contract.manager.FormulaireContactManager;
import com.escalade.siteweb.business.contract.manager.PaysManager;
import com.escalade.siteweb.business.contract.manager.PhotoManager;
import com.escalade.siteweb.business.contract.manager.RegionManager;
import com.escalade.siteweb.business.contract.manager.ReservationTopoManager;
import com.escalade.siteweb.business.contract.manager.SecteurManager;
import com.escalade.siteweb.business.contract.manager.SiteManager;
import com.escalade.siteweb.business.contract.manager.UtilisateurManager;
import com.escalade.siteweb.business.contract.manager.VoieManager;

/**
 * Factory des Managers
 * @author André Monnier
 */
public interface ManagerFactory {

	void setDepartementManager(DepartementManager departementManager);

	DepartementManager getDepartementManager();

	void setRegionManager(RegionManager regionManager);

	RegionManager getRegionManager();

	void setPaysManager(PaysManager paysManager);

	PaysManager getPaysManager();

	void setCommentaireManager(CommentaireManager commentaireManager);

	CommentaireManager getCommentaireManager();

	void setVoieManager(VoieManager voieManager);

	VoieManager getVoieManager();

	void setSecteurManager(SecteurManager secteurManager);

	SecteurManager getSecteurManager();

	void setSiteManager(SiteManager siteManager);

	SiteManager getSiteManager();

	void setFormulaireContactManager(FormulaireContactManager formulaireContactManager);

	FormulaireContactManager getFormulaireContactManager();

	void setUtilisateurManager(UtilisateurManager utilisateurManager);

	UtilisateurManager getUtilisateurManager();

	void setPhotoManager(PhotoManager photoManager);

	PhotoManager getPhotoManager();

	void setReservationTopoManager(ReservationTopoManager reservationTopoManager);

	ReservationTopoManager getReservationTopoManager();
}
