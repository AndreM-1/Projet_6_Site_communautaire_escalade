package com.escalade.siteweb.business.impl.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.escalade.siteweb.business.contract.manager.ReservationTopoManager;
import com.escalade.siteweb.model.bean.site.ReservationTopo;
import com.escalade.siteweb.model.exception.FunctionalException;
import com.escalade.siteweb.model.exception.NotFoundException;
import com.escalade.siteweb.model.exception.TechnicalException;

@Named
public class ReservationTopoManagerImpl extends AbstractManager implements ReservationTopoManager {
	
	private List<ReservationTopo> listReservationTopo = new ArrayList<>();
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(ReservationTopoManagerImpl.class);

	@Override
	public List<ReservationTopo> getListReservationTopo() {
		listReservationTopo=getDaoFactory().getReservationTopoDao().getListReservationTopo();
		return this.listReservationTopo;
	}
	
	
	@Override
	public void insertReservationTopo(Date dateDeDebut, String heureDeDebut, Date dateDeFin, String heureDeFin, int utilisateurId, int siteId, Date dateReservation) 
			throws FunctionalException,TechnicalException{
		List<ReservationTopo> listReservationTopo=null;
		
		if(!dateDeDebut.equals(dateDeFin)) {
			throw new FunctionalException("Les topos ne peuvent être réservées que pour une seule journée.");
		}
		
		if(heureDeDebut.equals(heureDeFin)) {
			throw new FunctionalException("L'heure de début et l'heure de fin de réservation doivent être différentes.");
		}
		
		
		int heureDeDebutInt, heureDeFinInt;
		
		try {
			heureDeDebutInt=Integer.valueOf(heureDeDebut.split(":")[0]);
			heureDeFinInt=Integer.valueOf(heureDeFin.split(":")[0]);
			LOGGER.info("Business - Méthode insertReservationTopo - heureDeDebutInt : "+heureDeDebutInt);
			LOGGER.info("Business - Méthode insertReservationTopo - heureDeFinInt : "+heureDeFinInt);
			
		} catch (NumberFormatException e) {
			throw new TechnicalException("Erreur Technique - Impossible de convertir l'heure saisie.");
		}
		
		if(heureDeFinInt<heureDeDebutInt) {
			throw new FunctionalException("L'heure de fin de réservation ne peut pas être située avant l'heure de début.");
		}
		
		try {
			listReservationTopo=getDaoFactory().getReservationTopoDao().getListReservationTopo(siteId);
			LOGGER.info("Business - Méthode insertReservationTopo - Liste des Topos réservées pour ce site : "+listReservationTopo);
		} catch (NotFoundException e) {
			LOGGER.info("Pas de réservation de topo pour ce site");
		}
		
		if(listReservationTopo!=null) {
			for(ReservationTopo reservationTopo:listReservationTopo) {
				int heureDeDebutResTopo=Integer.valueOf(reservationTopo.getHeureDeDebut().split(":")[0]);
				int heureDeFinResTopo=Integer.valueOf(reservationTopo.getHeureDeFin().split(":")[0]);
				if(dateDeDebut.equals(reservationTopo.getDateDeDebut())){
					if((heureDeDebutInt<heureDeDebutResTopo&&heureDeFinInt<=heureDeDebutResTopo) || (heureDeDebutInt>=heureDeFinResTopo&&heureDeFinInt>heureDeFinResTopo )) {
						LOGGER.info("La topo peut être réservée pour ce créneau horaire");
					}
					else {
						LOGGER.info("Topo déjà réservée à cet horaire pour ce site. Veuillez choisir un autre créneau horaire pour la réservation");
						throw new FunctionalException("Topo déjà réservée à cet horaire pour ce site. Veuillez choisir un autre créneau horaire pour la réservation");
					}	
				}
				LOGGER.info("La topo peut être réservée pour ce créneau horaire");
			}
		}
	
		TransactionTemplate vTransactionTemplate=new TransactionTemplate(getPlatformTransactionManager());
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
				getDaoFactory().getReservationTopoDao().insertReservationTopo(dateDeDebut,heureDeDebut,dateDeFin,heureDeFin,utilisateurId,siteId,dateReservation);	
			}   
		});
	}

}
