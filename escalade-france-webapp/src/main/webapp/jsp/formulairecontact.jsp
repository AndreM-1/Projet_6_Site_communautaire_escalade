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
		
			
			<!-- Formulaire de contact -->
			<div class="row">
				<div class="col-lg-offset-4 col-lg-4" id="divConnexion">
					<h1 class="text-center">Formulaire de contact</h1>
					<s:form action="page_formulaire_contact">
						<s:actionerror/>
						<s:if test="#session.user">
							<s:textfield name="#session.user.pseudo" label="Nom ou Pseudo" requiredLabel="true"/>
						</s:if>
						<s:else>
							<s:textfield name="formulaireContact.nomNa" label="Nom ou Pseudo" requiredLabel="true"/>
						</s:else>
				        <div class="row">
					        <div class="col-lg-6">
					        	<s:if test="#session.user">
					        		<s:textfield name="#session.user.adresseMail" label="Adresse e-mail" requiredLabel="true"/>
					        	</s:if>
					        	<s:else>
					        		<s:textfield name="formulaireContact.adresseMailNa" label="Adresse e-mail" requiredLabel="true"/>
					        	</s:else>
							</div>
							 <div class="col-lg-6">
								<s:select name="formulaireContact.objet" label="Objet" list="#{'Contacter l’administrateur':'Contacter l’administrateur','Remonter un bug':'Remonter un bug',
								'Proposer une amélioration':'Proposer une amélioration','Proposer une nouvelle catégorie':'Proposer une nouvelle catégorie','Autre':'Autre'}"
							  	emptyOption="false" requiredLabel="true" value="formulaireContact.objet" />
							</div>
					  	</div>
				      	<s:textarea name="formulaireContact.message" class="form-control" rows="4" label="Votre message" requiredLabel="true"/>
						<s:submit value="Envoyer le formulaire" class="btn btn-primary"/>
		 			</s:form>	
	 			</div>
			</div>
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	
	</body>
</html>