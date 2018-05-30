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
			
			<!-- Section liée au détail d'un utilisateur-->
			<h1 class="text-center">
			<s:if test="%{utilisateur.photoUtilisateur!=null}">
				<img src="<s:property value="utilisateur.photoUtilisateur.nomPhoto"/>" alt="Photo utilisateur"  width=100px height=100px/>
			</s:if>
			<s:else>
				<s:if test="%{utilisateur.civilite=='Monsieur'}">
					<img src="jsp/assets/images/photo_profil_homme_anonyme.jpg" alt="Photo utilisateur" width=100px height=100px/>
				</s:if>
				<s:else>
					<img src="jsp/assets/images/photo_profil_femme_anonyme.jpg" alt="Photo utilisateur" width=100px height=100px/>
				</s:else>
			</s:else>
			<s:property value="utilisateur.pseudo"/></h1>
            
            <!-- Menu de navigation -->
            <s:if test="#session.user.pseudo==utilisateur.pseudo">
	            <nav id="navProfilUtilisateur">
		            <ul>
			            <li>
				            <s:a action="page_utilisateur_coord"> 
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
				            <s:a action="page_utilisateur_fa" id="filActivite"> 
				            	<s:param name="id" value="utilisateur.id"/>
				            	Mon fil d'activité
				            </s:a>
			            </li>
		             </ul>
	             </nav>
			</s:if>	
			<s:else>
				<h2>Fil d'activite</h2>
			</s:else>
			<!-- Section Fil d'activité de l'utilisateur sélectionné-->
			<section>
				<div class="row">
					<s:iterator value="listSite">
						<div class="col-lg-6">
							<div class="panel panel-info" id="panel">
								<div class="panel-heading">
									<s:if test="%{dateAjoutSite!=dateMajSite}">
										<h2 class="panel-title">
											<s:a action="page_utilisateur_fa">
												<s:param name="id" value="utilisateur.id"/>
												<s:property value="utilisateur.pseudo"/>
											</s:a> a mis à jour un site
										</h2>
									</s:if>
									<s:else>
										<h2 class="panel-title">
											<s:a action="page_utilisateur_fa">
												<s:param name="id" value="utilisateur.id"/>
												<s:property value="utilisateur.pseudo"/>
											</s:a> 
										a ajouté un site
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
											<img src="<s:property value="photoSite.nomPhoto"/>" alt="Photo d'un site" height=200px width=252px/>
										</div>
									</s:if>
									<s:else>
										<div class="col-lg-4 photoParDefaut"></div>
									</s:else>
								
									<s:iterator value="listPhotoAllSecteur" begin="0" end="1">
										<s:if test="%{listPhotoAllSecteur!=null}">
											<div class="col-lg-4">
												<img src="<s:property value="nomPhoto"/>" alt="Photo d'un secteur" height=200px width=252px/>
											</div>
										</s:if>
										<s:else>
											<div class="col-lg-4 photoParDefaut"></div>
										</s:else>
									</s:iterator>
								</div>
							</div>	
						</div>
					</s:iterator>
				</div>
			</section>
			<s:actionmessage/>
			
			
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		
		
		</div>
	</body>
</html>