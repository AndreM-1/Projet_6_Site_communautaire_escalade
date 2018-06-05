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

	
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6" id="divAjoutSite">
				<h1 class="text-center">Ajouter un site</h1>
				<p class="text-center">La photo est facultative. Si vous ne souhaitez pas ajouter de photo, vous pouvez directement cliquer sur <strong>Etape suivante.</strong></p>
				<s:actionerror/>
				
				<h2 class="text-center"><s:property value="listSecteur[0].nomSecteur"></s:property></h2>
				<!-- Section liée à l'upload de la photo d'un secteur -->
				<div class="row">
					<div class="col-lg-offset-4 col-lg-8">
						<s:form action="upload_photo_secteur" method="POST" enctype="multipart/form-data">
							<s:hidden name="id"/>
							<s:file name="fileSecteurUpload" id="fileSecteurUpload" label="Ajouter une première photo pour le secteur"></s:file>
							<s:file name="fileSecteurUpload" id="fileSecteurUpload" label="Ajouter une deuxième photo pour le secteur"></s:file>
							<s:file name="fileSecteurUpload" id="fileSecteurUpload" label="Ajouter une troisième photo pour le secteur"></s:file>
							<div class="row">
								<div class="col-lg-6">
									<s:submit value="Valider" class="btn btn-primary"/> 
								</div>
							</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>

		<!-- Pied de page -->
		<%@ include file="_include/footer.jsp"%>
	</div>

</body>
</html>