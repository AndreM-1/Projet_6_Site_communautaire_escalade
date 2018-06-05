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
				
				<!-- Section liée à l'upload de la photo d'un site -->
				<div class="row">
					<div class="col-lg-offset-4 col-lg-8">
						<s:form action="upload_photo_site" method="POST" enctype="multipart/form-data">
							<s:hidden name="id"/>
							<s:file name="fileSiteUpload" id="fileSiteUpload" label="Ajouter une photo pour le site"></s:file>
							<div class="row">
								<div class="col-lg-6">
									<s:submit value="Valider" class="btn btn-primary"/> 
									<s:a class="btn btn-primary" action="page_ajout_secteur">
										<s:param name="id" value="id"/>
										Etape suivante
									 </s:a>
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