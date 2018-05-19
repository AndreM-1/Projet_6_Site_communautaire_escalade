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
		
			<s:if test="#session.user.administrateur==true">
				<!-- Visualisation des formulaires de contact. Uniquement réservé à l'administrateur -->
				<h1 class="text-center">Formulaires de contact reçus</h1>
				<s:iterator value="listFormulaireContact">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>Message reçu le <s:property value="dateFormContact"/> </h4>
								</div>
								<div class="panel-body">
									<strong>Nom ou Pseudo : </strong><s:property value="nomNa"/> <s:property value="utilisateur.pseudo"/> <br/>
									<strong>Adresse Mail : </strong><s:property value="adresseMailNa"/> <s:property value="utilisateur.adresseMail"/><br/>
									<strong>Objet :</strong> <s:property value="objet"/><br/>
									<strong>Message : </strong><s:property value="message"/><br/>
								</div>
							</div>
						</div>	
						
					</div>
				</s:iterator>
			</s:if>
			<s:else>
				<h1 class="text-center">Vous n'avez pas accès à cette page.</h1>
			</s:else>
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	
	</body>
</html>