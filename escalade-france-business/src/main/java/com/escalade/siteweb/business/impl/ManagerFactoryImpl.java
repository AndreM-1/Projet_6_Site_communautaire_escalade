package com.escalade.siteweb.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.escalade.siteweb.business.contract.ManagerFactory;
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
 * Implémentation de la {@link ManagerFactory}.
 */
@Named
public class ManagerFactoryImpl implements ManagerFactory {

	@Inject
	private PaysManager paysManager;

	@Inject
	private RegionManager regionManager;

	@Inject
	private DepartementManager departementManager;

	@Inject
	private SiteManager siteManager;

	@Inject
	private SecteurManager secteurManager;

	@Inject
	private VoieManager voieManager;

	@Inject
	private CommentaireManager commentaireManager;
	
	@Inject
	private UtilisateurManager utilisateurManager;
	
	@Inject
	private FormulaireContactManager formulaireContactManager;
	
	@Inject
	private PhotoManager photoManager;
	
	@Inject
	private ReservationTopoManager reservationTopoManager;

	@Override
	public PaysManager getPaysManager() {
		return paysManager;
	}

	@Override
	public void setPaysManager(PaysManager paysManager) {
		this.paysManager = paysManager;
	}

	@Override
	public RegionManager getRegionManager() {
		return regionManager;
	}

	@Override
	public void setRegionManager(RegionManager regionManager) {
		this.regionManager = regionManager;
	}

	@Override
	public DepartementManager getDepartementManager() {
		return departementManager;
	}

	@Override
	public void setDepartementManager(DepartementManager departementManager) {
		this.departementManager = departementManager;
	}

	@Override
	public SiteManager getSiteManager() {
		return siteManager;
	}

	@Override
	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;
	}

	@Override
	public SecteurManager getSecteurManager() {
		return secteurManager;
	}

	@Override
	public void setSecteurManager(SecteurManager secteurManager) {
		this.secteurManager = secteurManager;
	}

	@Override
	public VoieManager getVoieManager() {
		return voieManager;
	}

	@Override
	public void setVoieManager(VoieManager voieManager) {
		this.voieManager = voieManager;
	}

	@Override
	public CommentaireManager getCommentaireManager() {
		return commentaireManager;
	}

	@Override
	public void setCommentaireManager(CommentaireManager commentaireManager) {
		this.commentaireManager = commentaireManager;
	}
	
	@Override
	public UtilisateurManager getUtilisateurManager() {
		return utilisateurManager;
	}

	@Override
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public FormulaireContactManager getFormulaireContactManager() {
		return formulaireContactManager;
	}

	@Override
	public void setFormulaireContactManager(FormulaireContactManager formulaireContactManager) {
		this.formulaireContactManager = formulaireContactManager;
	}
	
	@Override
	public PhotoManager getPhotoManager() {
		return photoManager;
	}

	@Override
	public void setPhotoManager(PhotoManager photoManager) {
		this.photoManager = photoManager;
	}

	@Override
	public ReservationTopoManager getReservationTopoManager() {
		return reservationTopoManager;
	}

	@Override
	public void setReservationTopoManager(ReservationTopoManager reservationTopoManager) {
		this.reservationTopoManager = reservationTopoManager;
	}
}