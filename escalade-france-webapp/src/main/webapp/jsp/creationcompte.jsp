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
		
			
			<!-- Formulaire de création de compte -->
			<div class="row">
				<div class="col-lg-offset-4 col-lg-4" id="divConnexion">
					<h1 class="text-center">S'inscrire</h1>
					<s:form action="page_creation_compte">
						<s:actionerror/>
						<s:select name="utilisateur.civilite" label="Civilité" list="#{'Monsieur':'Monsieur','Madame':'Madame'}"
					  	emptyOption="false" requiredLabel="true" value="utilisateur.civilite" />
						<s:textfield name="utilisateur.nom" label="Nom" requiredLabel="true"/>
						<s:textfield name="utilisateur.prenom" label="Prénom" requiredLabel="true"/>
				        <s:textfield name="utilisateur.pseudo" label="Pseudo" requiredLabel="true"/>
				        <s:textfield name="utilisateur.adresseMail" label="Adresse e-mail" requiredLabel="true"/>
				        <s:password name="utilisateur.motDePasse" label="Mot de passe" requiredLabel="true"/>
				       	<s:checkbox type="checkbox" name="conditionsUtilisation" id="conditionsUtilisation" label="J'ai lu et accepté les conditions d'utilisation" /> 
						<s:submit value="S'inscrire" class="btn btn-primary"/><s:a class="btn btn-primary" action="connexion">Déjà inscrit?</s:a> 
		 			</s:form>	
	 			</div>
			</div>
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	
	</body>
</html>