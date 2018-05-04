package com.escalade.siteweb.consumer.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.escalade.siteweb.consumer.contract.DaoFactory;
import com.escalade.siteweb.consumer.contract.dao.CommentaireDao;
import com.escalade.siteweb.consumer.contract.dao.DepartementDao;
import com.escalade.siteweb.consumer.contract.dao.FormulaireContactDao;
import com.escalade.siteweb.consumer.contract.dao.PaysDao;
import com.escalade.siteweb.consumer.contract.dao.PhotoDao;
import com.escalade.siteweb.consumer.contract.dao.RegionDao;
import com.escalade.siteweb.consumer.contract.dao.SecteurDao;
import com.escalade.siteweb.consumer.contract.dao.SiteDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.contract.dao.VoieDao;

@Named
public class DaoFactoryImpl implements DaoFactory{

	@Inject
	private PaysDao paysDao;

	@Inject
	private RegionDao regionDao;

	@Inject
	private DepartementDao departementDao;
	
	@Inject
	private SiteDao siteDao;
	
	@Inject
	private SecteurDao secteurDao;
	
	@Inject
	private VoieDao voieDao;
	
	@Inject
	private CommentaireDao commentaireDao;
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	@Inject
	private FormulaireContactDao formulaireContactDao;
	
	@Inject
	private PhotoDao photoDao;

	
	@Override
	public PaysDao getPaysDao() {
		return paysDao;
	}

	@Override
	public void setPaysDao(PaysDao paysDao) {
		this.paysDao = paysDao;
	}

	@Override
	public RegionDao getRegionDao() {
		return regionDao;
	}

	@Override
	public void setRegionDao(RegionDao regionDao) {
		this.regionDao = regionDao;
	}

	@Override
	public DepartementDao getDepartementDao() {
		return departementDao;
	}

	@Override
	public void setDepartementDao(DepartementDao departementDao) {
		this.departementDao = departementDao;
	}
	
	@Override
	public SiteDao getSiteDao() {
		return siteDao;
	}

	@Override
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	@Override
	public SecteurDao getSecteurDao() {
		return secteurDao;
	}

	@Override
	public void setSecteurDao(SecteurDao secteurDao) {
		this.secteurDao = secteurDao;
	}

	@Override
	public VoieDao getVoieDao() {
		return voieDao;
	}

	@Override
	public void setVoieDao(VoieDao voieDao) {
		this.voieDao = voieDao;
	}

	@Override
	public CommentaireDao getCommentaireDao() {
		return commentaireDao;
	}

	@Override
	public void setCommentaireDao(CommentaireDao commentaireDao) {
		this.commentaireDao = commentaireDao;
	}
	
	@Override
	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	@Override
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public FormulaireContactDao getFormulaireContactDao() {
		return formulaireContactDao;
	}

	@Override
	public void setFormulaireContactDao(FormulaireContactDao formulaireContactDao) {
		this.formulaireContactDao = formulaireContactDao;
	}
	
	@Override
	public PhotoDao getPhotoDao() {
		return photoDao;
	}

	@Override
	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}

}
