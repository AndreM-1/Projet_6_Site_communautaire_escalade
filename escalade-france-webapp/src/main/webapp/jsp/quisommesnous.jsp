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
			<h1 class="text-center">Qui sommes-nous?</h1>
	
			<!-- Section Bannière Image -->
			<section id="banniereImage">
				<div id="banniereDescription"> Site Communautaire dédié à l'escalade</div>	
			</section>
			
			<!-- Section explicative -->
			<section id="sectionQsn">
				<div>
					<h2>Bienvenue sur escalade-france.com, un site communautaire dédié à l'escalade</h2>
					<p class="paraQsn">Ce site communautaire a pour vocation de : </p>
					<ul>
						<li>partager des informations sur les sites, leurs secteurs et les voies de chaque secteur</li>
						<li>de présenter les topo qui existent et les sites/secteurs qu'ils couvrent</li>
						<li>de proposer un espace de prêt de topo</li>
						<li>permettre d'échanger avec les autres membres du site dans la section commentaire</li>	
					</ul>
					<p>Bonne grimpe à tous et à toutes !</p>
				</div>
				<div id="sousSectionQsn">
					<img src="<s:property value="utilisateur.photoUtilisateur.nomPhoto"/>" alt="Photo profil"
					height=100px width=166px/>
					<p><s:property value="utilisateur.pseudo"/></p>
				</div>
			
			</section>
		
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	
	</body>
</html>