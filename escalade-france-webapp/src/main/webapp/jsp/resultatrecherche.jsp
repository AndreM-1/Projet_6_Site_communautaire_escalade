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
		
			
			<!-- Page de résultats de recherche -->
			<h1 class="text-center">Résultat de la recherche</h1>
			<s:if test="%{bSiteTrouve==true}">
				<s:iterator value="listSiteTrouve">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>Site correspondant à votre recherche :</h4>	
								</div>
								<div class="panel-body panelBodyResultatRecherche">
									<div>
										<s:if test="%{photoSite!=null}">
											<s:a action="page_site">
												<s:param name="id" value="id"/>
												<img src="<s:property value="photoSite.nomPhoto"/>" alt="Photo du site trouvé" height=60px width=60px/>
											</s:a>
										</s:if>
									</div>
									<p class="panelBodySiteTrouve">
										Site : 
										<s:a action="page_site">
											<s:param name="id" value="id"/>
											<s:property value="nomSite"/>
										</s:a>.<br/>
										Localisation : <s:property value="pays.nomPays"/> - <s:property value="region.nomRegion"/> - <s:property value="departement.nomDepartement"/> <br/>
										
										Mis en ligne par : 
										<s:if test="#session.user">
											<s:a action="page_utilisateur_fa">
												<s:param name="id" value="utilisateur.id"/>
												<s:property value="utilisateur.pseudo"/>
											</s:a>
										</s:if>
										<s:else>
											<s:a action="page_utilisateur_fa" data-toggle="tooltip" title="Vous devez être connecté pour avoir accès au profil d'un utilisateur">
												<s:param name="id" value="utilisateur.id"/>
												<s:property value="utilisateur.pseudo"/>
											</s:a>
										</s:else>
									</p>
									
								</div>
							</div>
						</div>
					</div>
				</s:iterator>
			</s:if>
			<s:else><h4 class="well">Aucun site ne correspond à votre recherche.</h4></s:else>
			
			<script>
				$(function (){
	   			$('a').tooltip();
				});
			</script>
		<!-- Pied de page -->
		<%@ include file="_include/footer.jsp"%>
		</div>
	</body>
</html>