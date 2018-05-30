package com.escalade.siteweb.consumer.contract;

import com.escalade.siteweb.consumer.contract.dao.CommentaireDao;
import com.escalade.siteweb.consumer.contract.dao.DepartementDao;
import com.escalade.siteweb.consumer.contract.dao.FormulaireContactDao;
import com.escalade.siteweb.consumer.contract.dao.PaysDao;
import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.RegionDao;
import com.escalade.siteweb.consumer.contract.dao.ReservationTopoDao;
import com.escalade.siteweb.consumer.contract.dao.SecteurDao;
import com.escalade.siteweb.consumer.contract.dao.SiteDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.contract.dao.VoieDao;

public interface DaoFactory {

	void setDepartementDao(DepartementDao departementDao);

	DepartementDao getDepartementDao();

	void setRegionDao(RegionDao regionDao);

	RegionDao getRegionDao();

	void setPaysDao(PaysDao paysDao);

	PaysDao getPaysDao();

	void setCommentaireDao(CommentaireDao commentaireDao);

	CommentaireDao getCommentaireDao();

	void setVoieDao(VoieDao voieDao);

	VoieDao getVoieDao();

	void setSecteurDao(SecteurDao secteurDao);

	SecteurDao getSecteurDao();

	void setSiteDao(SiteDao siteDao);

	SiteDao getSiteDao();

	void setFormulaireContactDao(FormulaireContactDao formulaireContactDao);

	FormulaireContactDao getFormulaireContactDao();

	void setUtilisateurDao(UtilisateurDao utilisateurDao);

	UtilisateurDao getUtilisateurDao();

	void setPhotoDao(PhotoDao photoDao);

	PhotoDao getPhotoDao();

	void setReservationTopoDao(ReservationTopoDao reservationTopoDao);

	ReservationTopoDao getReservationTopoDao();

	
}
