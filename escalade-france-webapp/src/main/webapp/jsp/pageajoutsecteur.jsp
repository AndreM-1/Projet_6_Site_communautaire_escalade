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
					<h4 class="text-center">Site>>Photo du site>><span id="etapeEnCours">Secteurs</span>>>Voies>>Photo secteur</h4>
					<p class="text-center">L'ajout de secteurs est facultatif.</p>
					<p class="text-center"> Si vous ne souhaitez pas ajouter de secteurs, vous pouvez directement cliquer sur <strong>Terminer.</strong></p>
					<p class="text-center"> Sinon, veuillez saisir le nombre de secteurs souhaité (entre 1 et 20 secteurs maximum) </p>
					<s:actionerror/>
					
					<s:if test="%{nbSecteurs==null}">
						<s:form action="page_ajout_secteur" method="POST">
							<label for="selectNbSecteurs">Veuillez saisir le nombre de secteurs</label>
							<s:hidden name="id"/>
							<s:select id="selectNbSecteurs" name="nbSecteurs" list="listChoixNbSecteurs" />
							<p class="text-center">
								<s:submit value="Valider" class="btn btn-primary"/>
								<s:a class="btn btn-primary" action="page_site">
									<s:param name="id" value="id"/>
									Terminer
								</s:a>
							</p>
						</s:form>
					</s:if>
				
					<s:else >
						<s:form action="page_ajout_secteur" method="POST">
							<s:hidden name="id"/>
							<s:hidden name="nbSecteurs"/>
							<h4><a href="#ajoutSecteur1" data-toggle="collapse">Ajouter un secteur</a></h4>
							<s:iterator var="counterSecteur" status="rowstatusSecteur" begin="1" end="nbSecteurs">
								<div id="ajoutSecteur${counterSecteur}" class="panel-collapse collapse">
									<s:textfield name="listSecteur[%{#rowstatusSecteur.index}].nomSecteur" label="Nom du secteur %{counterSecteur}" requiredLabel="true"/>
									<s:if test="#rowstatusSecteur.last==false">
										<h4><a href="#ajoutSecteur${counterSecteur+1}" data-toggle="collapse">Ajouter un secteur</a></h4>
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