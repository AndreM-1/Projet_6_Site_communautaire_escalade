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
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
									<div class="modal-header">
					              		<button type="button" class="close" data-dismiss="modal">x</button>
              							<h4 class="modal-title">Réservation de topo</h4>
									</div>
									<div class="modal-body">
										<s:form>
											<div class="form-group">
												<s:textfield name="site.dateDeDebut" label="Date de début :"></s:textfield>
												<s:textfield name="site.dateDeFin" label="Date de fin :" ></s:textfield>
											</div>
												<s:submit value="Valider" class="btn btn-primary"/>
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
						<s:form id="ajoutCommentaire" class="panel-collapse collapse">
							<div class="form-group">
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
				<p><img src="<s:property value="utilisateur.photoUtilisateur.nomPhoto"/>" alt="Photo utilisateur"  width=40px height=40px/>
				<s:property value="commentaire"/></p>
			</s:iterator>
			
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
		
	</body>
</html>