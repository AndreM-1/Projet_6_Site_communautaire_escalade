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
				
				<s:a data-toggle="modal" href="#formUploadPhotoUtilisateur">
					<s:if test="%{utilisateur.photoUtilisateur!=null}">
						<img src="<s:property value="utilisateur.photoUtilisateur.nomPhoto"/>" alt="Photo utilisateur"  width=100px height=100px/>
					</s:if>
					<s:else>
						<s:if test="%{utilisateur.civilite=='Monsieur'}">
							<img src="jsp/assets/images/photo_profil_homme_anonyme.jpg" alt="Photo utilisateur anonyme" width=100px height=100px/>
						</s:if>
						<s:else>
							<img src="jsp/assets/images/photo_profil_femme_anonyme.jpg" alt="Photo utilisateur anonyme" width=100px height=100px/>
						</s:else>
					</s:else>
				</s:a>
				
				<s:property value="utilisateur.pseudo"/></h1>
				
				<div class="modal fade" id="formUploadPhotoUtilisateur">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">
							<div class="modal-header">
			              		<button type="button" class="close" data-dismiss="modal">x</button>
         						<h4 class="modal-title text-center">Modifier la photo</h4>
							</div>
							<div class="modal-body">
								<s:form action="upload_photo_util" method="POST" enctype="multipart/form-data">
									<p class="text-center"><label for="upload">Sélectionner une photo :</label></p>
									<s:hidden name="utilisateur.id" label="Utilisateur Id :"></s:hidden>
									<s:file name="fileUpload" id="upload"></s:file>	
									<div class="text-center">							
											<s:submit value="Valider" class="btn btn-primary"/>
									</div>
								</s:form>
							</div>
						</div>
					</div>
				</div>				
		     
	            <!-- Menu de navigation -->
	           
	            <nav id="navProfilUtilisateur">
		            <ul>
			            <li>
				            <s:a action="page_utilisateur_coord" id="mescoordonnees"> 
				            	<s:param name="id" value="utilisateur.id"/>
				            	Mes coordonnées
				            </s:a>
			            </li>
			            <li>
				            <s:a action="page_utilisateur_mdp">
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
				
				<!-- Section comportant les coordonnées de l'utilisateur sélectionné -->
				<s:form id="formUtilisateurCoord" action="update_utilisateur" method="POST">
					<div class="row">
						<div class="col-lg-6">
								<s:hidden name="utilisateur.id" label="Id"/>
								<s:if test="%{utilisateur.photoUtilisateur!=null}">
									<s:hidden name="utilisateur.photoUtilisateur.nomPhoto" label="Photo Utilisateur"/>
								</s:if>
							<div class="row">
								<div class="col-lg-12">
									<div class="row">
										<div class="col-lg-4">
										
											<s:select name="utilisateur.civilite" label="Civilité" list="#{'Monsieur':'Monsieur','Madame':'Madame'}"
										  	emptyOption="false" requiredLabel="true" value="utilisateur.civilite" />  
		
							  			</div>
							  			<div class="col-lg-8">
											<s:textfield name="utilisateur.nom" label="Nom" requiredLabel="true"/>
										</div>
									</div>
									<s:textfield name="utilisateur.prenom" label="Prénom" requiredLabel="true"/>
									<s:textfield name="utilisateur.pseudo" label="Pseudo" requiredLabel="true"/>
									<s:textfield name="utilisateur.adresseMail" label="Adresse e-mail" requiredLabel="true"/>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="row">
								<div class="col-lg-12">
									<s:textfield name="utilisateur.telephone" label="Téléphone (XX-XX-XX-XX-XX)"/>
									<s:textfield name="utilisateur.dateNaissance" label="Date de naissance (JJ/MM/AAAA ou JJ/MM/AA)"/>
									<s:textfield name="utilisateur.adresse" label="Adresse"/>
									<div class="row">
										<div class="col-lg-4">
											<s:textfield name="utilisateur.codePostal" label="Code Postal"/>
										</div>
										<div class="col-lg-4">
											<s:textfield name="utilisateur.ville" label="Ville"/>
										</div>
										<div class="col-lg-4">
											<s:textfield name="utilisateur.pays" label="Pays"/>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-offset-5 col-lg-2">
							<s:submit value="Valider" class="btn btn-primary btn-block"/>
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