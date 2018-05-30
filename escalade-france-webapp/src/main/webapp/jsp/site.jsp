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
			
			<!-- Section liée au détail d'un site -->
			<h1 class="text-center"><s:property value="site.nomSite"/></h1>
			
			<h2>Ajouté par : <s:property value="site.utilisateur.pseudo"/></h2>
			<h2>Localisation 
				<s:if test="#session.user.pseudo==site.utilisateur.pseudo">
					<s:a class="pull-right lienModification"><span class="glyphicon glyphicon-pencil"></span>Modifier</s:a>
				</s:if>
			</h2>
			<p><s:property value="site.pays.nomPays"/></p>
			<p><s:property value="site.region.nomRegion"/></p>
			<p><s:property value="site.departement.nomDepartement"/></p>
			<h2>Descriptif du site 
				<s:if test="#session.user.pseudo==site.utilisateur.pseudo">
					<s:a class="pull-right lienModification"><span class="glyphicon glyphicon-pencil"></span>Modifier</s:a>
				</s:if>
			</h2>
			<p><s:property value="site.descriptif"/></p>
		
			<s:if test="%{site.photoSite!=null}">
				<img src="<s:property value="site.photoSite.nomPhoto"/>" alt="Photo d'un site"   />
			</s:if>
	
			<s:iterator value="site.listSecteur">
				<h2>Secteur <s:property value="nomSecteur"/>
					<s:if test="#session.user.pseudo==site.utilisateur.pseudo">
						<s:a class="pull-right lienModification"><span class="glyphicon glyphicon-pencil"></span>Modifier</s:a>
					</s:if>
				</h2>
				<s:iterator value="listVoie">
					<p><s:property value="nomVoie"/> : <s:property value="cotation"/> - <s:property value="hauteur"/>
					- <s:property value="nbPoints"/> - <s:property value="duree"/></p>
				</s:iterator>
				
				<p>
					<s:iterator value="listPhotoSecteur">
						<img src="<s:property value="nomPhoto"/>" alt="Photo d'un site"  height=500px />
					</s:iterator>
				</p>
			</s:iterator>
			
			<h2>Commentaires personnels
				<s:if test="#session.user.pseudo==site.utilisateur.pseudo">
					<s:a class="pull-right lienModification"><span class="glyphicon glyphicon-pencil"></span>Modifier</s:a>
				</s:if>
			</h2>
			<p class="text-justify"><s:property value="site.commentairePersonnel"/></p>
			
			<h2>Espace de prêt de topo
				<s:if test="#session.user.pseudo==site.utilisateur.pseudo">
					<s:a class="pull-right lienModification"><span class="glyphicon glyphicon-pencil"></span>Modifier</s:a>
				</s:if>
			</h2>
			<s:if test="#session.user.pseudo!=null">
				<s:if test="#session.user.pseudo!=site.utilisateur.pseudo">
					<s:if test="%{site.topoDisponible==true}">
						<p><s:a class="btn btn-primary" data-toggle="modal" href="#formReservationTopo">Réserver une topo</s:a></p>
						<div class="modal fade" id="formReservationTopo">
							<div class="modal-dialog modal-md">
								<div class="modal-content">
									<div class="modal-header">
					              		<button type="button" class="close" data-dismiss="modal">x</button>
              							<h4 class="modal-title text-center">Réservation de topo</h4>
									</div>
									<div class="modal-body">
										<s:form action="reservation_topo" method="POST">
											<s:hidden name="site.id" label="Site id"/>
											<s:actionerror/>
											<div class="form-group">
												<p class="text-center">Veuillez saisir les dates de réservation pour la topo.</p>
												<p class="text-center">Les topo ne peuvent être réservées que pour une journée.</p>
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
							</div>
						</div>
						
					</s:if>
					<s:else>
						<p>Topo indisponible pour ce site</p>
					</s:else>
				</s:if>
				<s:elseif test="#session.user.pseudo==site.utilisateur.pseudo">
					<s:if test="%{site.topoDisponible==true}">
						<p>Vous avez mis à disposition une topo pour ce site</p>
					</s:if>
					<s:else>
						<p>Vous n'avez pas mis de topo à disposition pour ce site</p>
					</s:else>	
				</s:elseif>
			</s:if>
			<s:else>
				<s:if test="%{site.topoDisponible==true}">
					<p><s:a action="connexion" class="btn btn-primary">Se connecter pour réserver une topo</s:a></p>
				</s:if>
				<s:else>
					<p>Pas de topo disponible pour ce site</p>
				</s:else>	
			</s:else>
			<div id="sectionCommentaires">
				<h2 >Commentaires</h2>
				<s:if test="#session.user">
					<div>
						<s:if test="#session.user.photoUtilisateur==null">
							<s:if test="#session.user.civilite=='Monsieur'">
								<img src="jsp/assets/images/photo_profil_homme_anonyme.jpg" alt="Photo utilisateur" width=40px height=40px/>
							</s:if>
							<s:else>
								<img src="jsp/assets/images/photo_profil_femme_anonyme.jpg" alt="Photo utilisateur" width=40px height=40px/>
							</s:else>
						</s:if>
						<s:else>
							<img src="<s:property value="#session.user.photoUtilisateur.nomPhoto" />" alt="Photo utilisateur" width=40px height=40px/>
						</s:else>
						<a href="#ajoutCommentaire" data-toggle="collapse">Ajouter un commentaire</a>
					</div>
					<div>
						<s:form id="ajoutCommentaire" class="panel-collapse collapse" action="ajout_commentaire">
							<div class="form-group">
								<s:hidden name="site.id" label="Site id" />
								<s:textarea name="commentaire.commentaire" class="form-control" rows="4"> </s:textarea>
								<s:submit value="Valider" class="btn btn-primary"/>
							</div>
						</s:form>
					</div>
				</s:if>
				<s:else>
					<s:a action="connexion">Se connecter pour poster un commentaire</s:a>
				</s:else>
			</div>
			<s:iterator value="site.listCommentaire">
				<p>
					<s:if test="%{utilisateur.photoUtilisateur==null}">
						<s:if test="%{utilisateur.civilite=='Monsieur'}">
							<img src="jsp/assets/images/photo_profil_homme_anonyme.jpg" alt="Photo utilisateur" width=40px height=40px/>
						</s:if>
						<s:else>
							<img src="jsp/assets/images/photo_profil_femme_anonyme.jpg" alt="Photo utilisateur" width=40px height=40px/>
						</s:else>			
					</s:if>
					<s:else>
						<img src="<s:property value="utilisateur.photoUtilisateur.nomPhoto"/>" alt="Photo utilisateur"  width=40px height=40px/>
					</s:else>
					<strong><s:property value="utilisateur.pseudo"/></strong> <s:property value="commentaire"/>
				</p>
			</s:iterator>
			
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
		
	</body>
</html>