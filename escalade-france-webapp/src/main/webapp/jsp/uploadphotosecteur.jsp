<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="_include/head.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<!-- Header -->
		<%@ include file="_include/header.jsp"%>
		<s:if test="#session.user.id==site.utilisateur.id">
			<div class="row">
				<div class="col-lg-offset-3 col-lg-6" id="divAjoutSite">
					<h1 class="text-center">Ajouter un site</h1>
					<h4 class="text-center">Site>>Photo du site>>Secteurs>>Voies>><span id="etapeEnCours">Photo secteur</span></h4>
					<p class="text-center">Les photos sont facultatives (bien que conseillées;).</p>
					<p class="text-center"> Si vous ne souhaitez pas ajouter de photos pour un secteur, vous pouvez directement cliquer sur <strong>Secteur suivant.</strong></p>
					<p class="text-center"> Si vous ne souhaitez pas du tout ajouter de photos, vous pouvez directement cliquer sur <strong>Terminer.</strong></p>
					<s:actionerror/>
					<h2 class="text-center"><s:property value="listSecteur[secteurCourant-1].nomSecteur"></s:property></h2>
					<!-- Section liée à l'upload de la photo d'un secteur -->
					<div class="row">
						<div class="col-lg-offset-4 col-lg-8">
							<s:form action="upload_photo_secteur" method="POST" enctype="multipart/form-data">
								<s:hidden name="id"/>
								<s:hidden name="nbSecteurs"/>
								<s:hidden name="secteurCourant"/>
								<s:file name="fileSecteurUpload" id="fileSecteurUpload1" label="Ajouter une première photo pour le secteur"></s:file>
								<s:file name="fileSecteurUpload" id="fileSecteurUpload2" label="Ajouter une deuxième photo pour le secteur"></s:file>
								<s:file name="fileSecteurUpload" id="fileSecteurUpload3" label="Ajouter une troisième photo pour le secteur"></s:file>
								<div class="row">
									<div class="col-lg-12">
										<s:submit value="Valider" class="btn btn-primary"/> 
										<s:a class="btn btn-primary" action="upload_photo_secteur">
											<s:param name="id" value="id"/>
											<s:param name="nbSecteurs" value="nbSecteurs"/>
											<s:param name="secteurCourant" value="secteurCourant+1"/>
											Secteur suivant
										 </s:a>
										<s:a class="btn btn-primary" action="page_site">
											<s:param name="id" value="id"/>
											Terminer
								 		</s:a>
									</div>
								</div>
							</s:form>
						</div>
					</div>
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