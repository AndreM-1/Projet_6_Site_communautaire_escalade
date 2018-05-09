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
			<h1 class="text-center">Mentions légales</h1>

			<!-- Section Bannière Image -->
			<section id="banniereImage">
				<div id="banniereDescription"> Site Communautaire dédié à l'escalade</div>	
			</section>
			
			<!-- Section explicative -->
			<section>
				<h2>Editeur</h2>
				<p class="paraMl text-justify">Le présent site est exploité par le particulier M. André Monnier.<br/>
				Le directeur de la publication est M. André Monnier.
				</p>
				<h2>Déclaration CNIL</h2>
				<p class="paraMl text-justify">Conformément aux dispositions de la loi n°78‐17 du 6 Janvier 1978 relative à l'informatique, aux fichiers et aux libertés,
				ce site a fait l'objet d'une déclaration auprès de la Commission Nationale de l'Informatique et des Libertés.</p>
				
				<h2>Données personnelles</h2>
				<p class="paraMl text-justify">Conformément aux dispositions de la loi n° 78‐17 du 6 Janvier 1978 relative à l'informatique, aux fichiers et aux libertés,
				vous disposez d'un droit d'accès, de modification, de rectification et de suppression des données qui vous concernent. Pour exercer ce droit, 
				contactez‐nous via le formulaire de contact.
				</p>
			</section>
	
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	
	</body>
</html>