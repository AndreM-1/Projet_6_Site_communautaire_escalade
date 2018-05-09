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
			<div class="row">
				<div class="col-lg-offset-4 col-lg-4" id="divConnexion">
					<h1 class="text-center">Se connecter</h1>
					<s:form action="connexion">
				        <s:textfield name="adresseMail" label="Adresse mail" requiredLabel="true"/>
				        <s:password name="motDePasse" label="Mot de passe" requiredLabel="true"/>
				        <s:checkbox name="seSouvenirDeMoi" label="Se souvenir de moi"/>
				        <s:submit value="Connexion" class="btn btn-primary"/><s:a class="btn btn-primary">Pas encore de compte?</s:a>
		 			</s:form>	
	 			</div>
			</div>
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	
	</body>
</html>