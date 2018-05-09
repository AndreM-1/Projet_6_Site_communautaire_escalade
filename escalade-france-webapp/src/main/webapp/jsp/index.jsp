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
			<section id="filActivite">
				<h1>Fil d'activité</h1>
				<div class="row" id=rowFilActivite>
					<s:iterator value="listSite">
						<div class="col-lg-6">
							<div class="panel panel-info" id="panel">
								<div class="panel-heading">
									<s:if test="%{dateAjoutSite!=dateMajSite}">
										<h2 class="panel-title"><s:property value="utilisateur.pseudo"/> a mis à jour un site</h2>
									</s:if>
									<s:else>
										<h2 class="panel-title"><s:property value="utilisateur.pseudo"/> a ajouté un site</h2>
									</s:else>	
								</div>
								<p><s:property value="nomSite"/></p>
								<p><s:property value="pays.nomPays"/> - <s:property value="region.nomRegion"/> - <s:property value="departement.nomDepartement"/></p>
								
								<div class="row" id="rowPhoto">
									<s:if test="%{photoSite!=null}">
										<div class="col-lg-4">
											<img src="<s:property value="photoSite.nomPhoto"/>" alt="Photo d'un site" height=200px  />
										</div>
									</s:if>
								
									<s:iterator value="listPhotoSecteur" begin="0" end="1">
										<s:if test="%{listPhotoSecteur!=null}">
											<div class="col-lg-4">
												<img src="<s:property value="nomPhoto"/>" alt="Photo d'un secteur" height=200px/>
											</div>
										</s:if>
									</s:iterator>
									<s:if test="%{photoSite==null&&listPhotoSecteur==null}">
										<div id="photoParDefaut"></div>
									</s:if>	
								</div>
							</div>	
						</div>
					</s:iterator>
				
				</div>
			</section>
			
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>

	</body>
</html>