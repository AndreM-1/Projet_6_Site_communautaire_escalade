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
			
			<!-- Section Bannière Image -->
			<section id="banniereImage">
				<div id="banniereDescription"> Site Communautaire dédié à l'escalade</div>	
			</section>

			<!-- Section Fil d'activité -->
			<section>
				<h1>Fil d'activité</h1>
				<div class="row" id=rowFilActivite>
					<s:iterator value="listSite">
						<div class="col-lg-6">
							<div class="panel panel-info" id="panel">
								<div class="panel-heading">
									<s:if test="%{dateAjoutSite!=dateMajSite}">
										<h2 class="panel-title">
											<s:if test="#session.user">
												<s:a action="page_utilisateur_fa">
													<s:param name="id" value="utilisateur.id"/>
													<s:property value="utilisateur.pseudo"/>
												</s:a> a mis à jour un site

											</s:if>
											<s:else>
												<s:a action="page_utilisateur_fa" data-toggle="tooltip" 
												title="Vous devez être connecté pour avoir accès au profil d'un utilisateur">
													<s:param name="id" value="utilisateur.id"/>
													<s:property value="utilisateur.pseudo"/>
												</s:a> a mis à jour un site
											</s:else>
										</h2>
									</s:if>
									<s:else>
										<h2 class="panel-title">
											<s:if test="#session.user">
												<s:a action="page_utilisateur_fa">
													<s:param name="id" value="utilisateur.id"/>
													<s:property value="utilisateur.pseudo"/>
												</s:a> 
												a ajouté un site
											</s:if>
											<s:else>
												<s:a action="page_utilisateur_fa" data-toggle="tooltip"
												title="Vous devez être connecté pour avoir accès au profil d'un utilisateur">
													<s:param name="id" value="utilisateur.id"/>
													<s:property value="utilisateur.pseudo"/>
												</s:a> 
												a ajouté un site											
											</s:else>
										</h2>
									</s:else>	
								</div>
								
								<p class="paraFilActivite">
									<s:a action="page_site">
										<s:param name="id" value="id"/>
										<s:property value="nomSite"/>
									</s:a>
								</p>
								<p class="paraFilActivite"><s:property value="pays.nomPays"/> - <s:property value="region.nomRegion"/> - 
								<s:property value="departement.nomDepartement"/></p>
								
								<div class="row" id="rowPhoto">
									<s:if test="%{photoSite!=null}">
										<div class="col-lg-4">
											<img src="<s:property value="photoSite.nomPhoto"/>" alt="Photo d'un site" height=200px  />
										</div>
									</s:if>
								
									<s:iterator value="listPhotoAllSecteur" begin="0" end="1">
										<s:if test="%{listPhotoAllSecteur!=null}">
											<div class="col-lg-4">
												<img src="<s:property value="nomPhoto"/>" alt="Photo d'un secteur" height=200px/>
											</div>
										</s:if>
									</s:iterator>
									<s:if test="%{photoSite==null&&listPhotoAllSecteur==null}">
										<div id="photoParDefaut"></div>
									</s:if>	
								</div>
								
							</div>	
						</div>
					</s:iterator>
				
				</div>
			</section>
			
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