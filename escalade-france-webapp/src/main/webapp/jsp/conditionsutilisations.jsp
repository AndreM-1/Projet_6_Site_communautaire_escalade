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
			<h1 class="text-center">Conditions d'utilisation</h1>

			<!-- Section Bannière Image -->
			<section id="banniereImage">
				<div id="banniereDescription"> Site Communautaire dédié à l'escalade</div>	
			</section>
			
			<!-- Section explicative -->
			<section>
				<h2>Ajout/Mise à jour d'un site</h2>
				<p class="paraCutil text-justify">Le plagiat est bien entendu interdit ! Ne recopiez pas un topo papier ou un blog, 
					mais rédigez votre propre description à partir de vos observations de terrain.<br/> 
					Si celle-ci n'est pas parfaite du premier coup, pour la partie collaborative du site, d'autres contributeurs 
					l'enrichiront sûrement par la suite via leur commentaire.<br/> 
					De même, il n'est généralement pas autorisé de "récupérer" une photo pour la mettre sur ce site, sous le prétexte
					qu'elle est déjà disponible quelque part sur internet !<br/> 
					Si une image vous semble intéressante, il vous faudra obtenir l’autorisation de son auteur pour la diffuser sous
					la licence creative commons correspondante.
				</p>
				<h2>Contribution via les commentaires</h2>
				<p class="paraCutil text-justify">Si vous souhaitez contribuer via les commentaires, merci de le faire en respectant les règles de convivialité et de bienveillance.</p>
				
				<h2>Responsabilité lors de la pratique d'une activité en montagne</h2>
				<p class="paraCutil text-justify">La pratique des activités sportives de montagne exige une connaissance maîtrisée du terrain et l'acceptation d'un degré de risque
					adapté aux capacités de chacun.<br/>
					Vous êtes seul responsable des conséquences de l'utilisation des informations fournies sur ce site et de votre pratique en générale.<br/>
				</p>
			</section>
	
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	
	</body>
</html>