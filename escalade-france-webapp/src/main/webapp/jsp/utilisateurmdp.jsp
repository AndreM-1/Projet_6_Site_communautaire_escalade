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
			
			<s:if test="#session.user.id==utilisateur.id">
				<!-- Section liée au détail d'un utilisateur-->
				<h1 class="text-center">
				<s:if test="%{utilisateur.photoUtilisateur!=null}">
					<img src="<s:property value="utilisateur.photoUtilisateur.nomPhoto"/>" alt="Photo utilisateur"  width=100px height=100px/>
				</s:if>
				<s:else>
					<s:if test="%{utilisateur.civilite=='Monsieur'}">
						<img src="jsp/assets/images/photo_profil_homme_anonyme.jpg" alt="Photo utilisateur" width=100px height=100px/>
					</s:if>
					<s:else>
						<img src="jsp/assets/images/photo_profil_femme_anonyme.jpg" alt="Photo utilisateur" width=100px height=100px/>
					</s:else>
				</s:else>
				<s:property value="utilisateur.pseudo"/></h1>
	            
	            <!-- Menu de navigation -->
	            <nav id="navProfilUtilisateur">
		            <ul>
			            <li>
				            <s:a action="page_utilisateur_coord"> 
				            	<s:param name="id" value="utilisateur.id"/>
				            	Mes coordonnées
				            </s:a>
			            </li>
			            <li>
				            <s:a action="page_utilisateur_mdp" id="monmotdepasse">
				           		<s:param name="id" value="utilisateur.id"/>
				           		Modifier mon mot de passe
				            </s:a>
			            </li>
			            <li>
				            <s:a action="page_utilisateur_fa"> 
				            	<s:param name="id" value="utilisateur.id"/>
				            	Mon fil d'activité
				            </s:a>
			            </li>
		             </ul>
	             </nav>
				
				<s:actionerror/>
				
				<!-- Section permettant à l'utilisateur de changer son mot de passe -->
				<s:form id="formUtilisateurMdp" action="update_mdp" method="POST">
					<div class="row">
						<div class="col-lg-4">
							<div id="idUtilisateur">
								<s:textfield name="utilisateur.id" label="Id" />
							</div>
						 	<s:password name="ancienMotDePasse" label="Mot de passe actuel" requiredLabel="true"/>
						 	<s:password name="nouveauMotDePasse" label="Nouveau mot de passe" requiredLabel="true"/>
						 	<s:password name="confirmationNouveauMotDePasse" label="Confirmation du nouveau mot de passe" requiredLabel="true"/>
				 		</div>
				 	</div>
					<div class="row">
						<div class="col-lg-4">
							<div class="row">
								<div class="col-lg-offset-6 col-lg-6">
									<s:submit value="Confirmer" class="btn btn-primary btn-block"/>	
								</div>
							</div>
						</div>
					</div>
				</s:form>
			</s:if>
			<s:else>
				<h1 class="text-center">Vous n'avez pas accès à cette page.</h1>
			</s:else>
			
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		
		
		</div>
	</body>
</html>