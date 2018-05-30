<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<%@ include file="_include/head.jsp"%>
	</head>
	<body>
		<div class="container-fluid">
			<!-- Header -->
			<%@ include file="_include/header.jsp"%>
		
			<s:if test="#session.user.id!=site.utilisateur.id">
				<!-- Formulaire de réservation de topo -->
				<div class="row">
					<div class="col-lg-offset-4 col-lg-4" id="divConnexion">
						<h1 class="text-center">Espace de réservation de topo</h1>
						<s:form action="reservation_topo" method="POST">
							<s:actionerror/>
							<s:hidden name="site.id" label="Site id"/>
							<s:hidden name="site.utilisateur.id" label="Site id"/>
							<div class="form-group">
								<p class="text-center">Veuillez saisir les dates de réservation pour la topo.</p>
								<p class="text-center">Les topo ne peuvent être réservées que pour une journée.</p>
								<s:if test="%{site.listReservationTopo!=null}">
									<p class="text-center">A noter que les créneaux horaires indiquées ci-dessous sont déjà pris :</p>
									<p class="text-center">
										<s:iterator value="site.listReservationTopo">
											- <s:property value="dateDeDebut"/> : <s:property value="heureDeDebut"/> à <s:property value="heureDeFin"/><br/>
										</s:iterator>
									</p>
								</s:if>
								<s:else>
									<p class="text-center">Cette topo n'a pas été réservée pour le moment.</p>
								</s:else>
									
								<div class="row">
									<div class="col-lg-6">
										<label for="reservationTopo.dateDeDebut">Date de début</label>
										<input type="date" name="reservationTopo.dateDeDebut" class="form-control" id= "reservationTopo.dateDeDebut"/>
									</div>
									<div class="col-lg-6">
										<label for="reservationTopo.heureDeDebut">Heure de début</label>
										<select name="reservationTopo.heureDeDebut" id="reservationTopo.heureDeDebut" class="form-control">
								        	<option value="08:00">08:00</option>
								           	<option value="09:00">09:00</option>
								          	<option value="10:00">10:00</option>
								           	<option value="11:00">11:00</option>											      	 
						      		   		<option value="12:00">12:00</option>
						      		   		<option value="13:00">13:00</option>
								           	<option value="14:00">14:00</option>
								           	<option value="15:00">15:00</option>
								           	<option value="16:00">16:00</option>
								           	<option value="17:00">17:00</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-lg-6">
										<label for="reservationTopo.dateDeFin">Date de fin</label>
										<input type="date" name="reservationTopo.dateDeFin" id="reservationTopo.dateDeFin" class="form-control"/>
									</div>
									<div class="col-lg-6">
										<label for="reservationTopo.heureDeFin">Heure de fin</label>
										<select name="reservationTopo.heureDeFin" id="reservationTopo.heureDeFin" class="form-control">
								           	<option value="09:00">09:00</option>
								          	<option value="10:00">10:00</option>
								           	<option value="11:00">11:00</option>											      	 
						      		   		<option value="12:00">12:00</option>
						      		   		<option value="13:00">13:00</option>
								           	<option value="14:00">14:00</option>
								           	<option value="15:00">15:00</option>
								           	<option value="16:00">16:00</option>
								           	<option value="17:00">17:00</option>
								           	<option value="18:00">18:00</option>														
										</select>
									</div>
								</div>
							</div> 
							<div class="row">
								<div class="col-lg-offset-2 col-lg-8">
									<s:submit value="Valider" class="btn btn-primary btn-block"/>
								</div>
							</div>			
			 			</s:form>	
		 			</div>
				</div>
			</s:if>
			<s:else>
				<h1 class="text-center">Vous n'avez pas accès à cette page.</h1>
			</s:else>
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	
	</body>
</html>