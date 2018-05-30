package com.escalade.siteweb.consumer.impl.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.escalade.siteweb.consumer.contract.dao.ReservationTopoDao;
import com.escalade.siteweb.consumer.contract.dao.UtilisateurDao;
import com.escalade.siteweb.consumer.impl.rowmapper.site.ReservationTopoRM;
import com.escalade.siteweb.model.bean.site.ReservationTopo;
import com.escalade.siteweb.model.exception.NotFoundException;

@Named
public class ReservationTopoDaoImpl extends AbstractDaoImpl implements ReservationTopoDao {
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	@Override
	public List<ReservationTopo> getListReservationTopo() {
        String vSQL = "SELECT * FROM public.reservation_topo";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<ReservationTopo> vRowMapper=new ReservationTopoRM(utilisateurDao);

        List<ReservationTopo> vListReservationTopo = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListReservationTopo;
    }
	
	@Override
	public List<ReservationTopo> getListReservationTopo(int siteId) throws NotFoundException {
        String vSQL = "SELECT * FROM public.reservation_topo WHERE site_id="+siteId+" ORDER BY date_de_debut, heure_de_debut";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource()); 
        
        RowMapper<ReservationTopo> vRowMapper=new ReservationTopoRM(utilisateurDao);

        List<ReservationTopo> vListReservationTopo = vJdbcTemplate.query(vSQL, vRowMapper);
        
		if(vListReservationTopo.size()!=0)	
			return vListReservationTopo;
		else
			throw new NotFoundException("Consumer - Pas de réservation de topo pour ce site.");
    }
	
	@Override
	public void insertReservationTopo(Date dateDeDebut, String heureDeDebut, Date dateDeFin, String heureDeFin, int utilisateurId, int siteId, Date dateReservation) {
		
		JdbcTemplate vJdbcTemplate=new JdbcTemplate(getDataSource());
		vJdbcTemplate.update("INSERT INTO public.reservation_topo(date_de_debut,heure_de_debut,date_de_fin,heure_de_fin,utilisateur_id,site_id,date_reservation) VALUES(?,?,?,?,?,?,?)", 
				dateDeDebut,heureDeDebut,dateDeFin,heureDeFin,utilisateurId,siteId,dateReservation);
		
	}

}
