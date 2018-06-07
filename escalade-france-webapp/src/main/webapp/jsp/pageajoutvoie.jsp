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
					<h4 class="text-center">Site>>Photo du site>>Secteurs>><span id="etapeEnCours">Voies</span>>>Photo secteur</h4>
					<p class="text-center">L'ajout de voies est facultatif.</p>
					<p class="text-center"> Si vous ne souhaitez pas ajouter de voies pour un secteur, vous pouvez directement cliquer sur <strong>Secteur suivant.</strong></p>
					<p class="text-center"> Si vous ne souhaitez pas du tout ajouter de voies, vous pouvez directement cliquer sur <strong>Etape suivante.</strong></p>
					<p class="text-center"> Sinon, veuillez saisir le nombre de voies souhaité pour chaque secteur (entre 1 et 20 voies maximum). </p>
					<p class="text-center">Si vous avez choisi d'ajouter des voies, tous les champs sont obligatoires</p>
					<s:actionerror/>
					
					<h2 class="text-center"><s:property value="listSecteur[secteurCourant-1].nomSecteur"></s:property></h2>
					
					<s:if test="%{nbVoies==null}">
						<s:form action="page_ajout_voie" method="POST">
							<label for="selectNbSecteurs">Veuillez saisir le nombre de voies</label>
							<s:hidden name="id"/>
							<s:hidden name="nbSecteurs"/>
							<s:hidden name="secteurCourant"/>
							<s:hidden name="nbSecteursInitial"/>
							<s:select id="selectNbVoies" name="nbVoies" list="listChoixNbVoies" />
							<p class="text-center">
								<s:submit value="Valider" class="btn btn-primary"/>
								<s:a class="btn btn-primary" action="page_ajout_voie">
									<s:param name="id" value="id"/>
									<s:param name="nbSecteurs" value="nbSecteurs"/>
									<s:param name="nbSecteursInitial" value="nbSecteursInitial"/>
									<s:param name="secteurCourant" value="secteurCourant+1"/>
									Secteur suivant
								 </s:a>
								<s:a class="btn btn-primary" action="upload_photo_secteur">
									<s:param name="id" value="id"/>
									<s:param name="nbSecteurs" value="nbSecteursInitial"/>
									Etape suivante
								 </s:a>
							</p>
						</s:form>
					</s:if>
					<s:else>
						<s:form action="page_ajout_voie" method="POST">
							<s:hidden name="id"/>
							<s:hidden name="nbSecteurs"/>
							<s:hidden name="secteurCourant"/>
							<s:hidden name="nbVoies"/>
							<s:hidden name="nbSecteursInitial"/>
							<h4><a href="#ajoutVoie1" data-toggle="collapse">Ajouter une voie</a></h4>
							<s:iterator var="counterVoie" status="rowstatusVoie" begin="1" end="nbVoies">
								<div id="ajoutVoie${counterVoie}" class="panel-collapse collapse">
									<div class="row">
										<div class="col-lg-3">
											<s:textfield name="listVoie[%{#rowstatusVoie.index}].nomVoie" label ="Nom de la voie" requiredLabel="true"/>
										</div>
										<div class="col-lg-3">
											<s:textfield name="listVoie[%{#rowstatusVoie.index}].cotation" label ="Cotation" requiredLabel="true"/>
										</div>
										<div class="col-lg-2">
											<s:textfield name="listVoie[%{#rowstatusVoie.index}].hauteur" label ="Hauteur" requiredLabel="true"/>
										</div>
										<div class="col-lg-2">
											<s:textfield name="listVoie[%{#rowstatusVoie.index}].nbPoints" label ="Nb points" requiredLabel="true"/>
										</div>
										<div class="col-lg-2">
											<s:textfield name="listVoie[%{#rowstatusVoie.index}].duree" label ="Durée" requiredLabel="true"/>
										</div>
									</div>
									<s:if test="#rowstatusVoie.last==false">
										<h4><a href="#ajoutVoie${counterVoie+1}" data-toggle="collapse">Ajouter une voie</a></h4>
									</s:if>	
								</div>
							</s:iterator>
							<p class="text-center">
								<s:submit value="Valider" class="btn btn-primary"/> 
							</p>
						</s:form>
					</s:else>	
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