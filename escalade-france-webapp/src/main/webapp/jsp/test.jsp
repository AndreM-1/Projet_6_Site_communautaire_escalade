<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>escalade-france</title>
		<meta name="description" content="Site communautaire au sujet de l'escalade">
		
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->

		<s:head/>
		<link rel="stylesheet" href="../css/style.css" />
		
	</head>
	<body>
		<!-- Header -->
		<header class="row">
			<div class="col-lg-2" id="nomSiteWeb">
				<s:a action="index">escalade-france.com</s:a>
			</div>
			<div class="col-lg-7">
				<s:form class="form-inline" action="test">
					<div class="form-group">
						<label class="sr-only" for="selectPays">Pays</label>
					    <s:select id="selectPays" name="pays.id" list="#session.listPays" listKey="id" listValue="nomPays" class="form-control"/>
								   				
						<label class="sr-only" for="selectRegion">Region</label>
						<s:select id="selectRegion" name="region.id" list="#session.listRegion" listKey="id" listValue="nomRegion" class="form-control"/>
						
						<label class="sr-only" for="selectRegion">Departement</label>
						<s:select id="selectDepartement" name="departement.id" list="#session.listDepartement" listKey="id" listValue="nomDepartement"
						class="form-control"/>
						<s:textfield name="rechercheSite" placeholder="Rechercher un site" requiredLabel="true" />
						<s:submit value="Lancer la recherche" class="btn btn-primary"/>
					</div>
				</s:form>	
			</div>
			<div class="col-lg-1">
				<s:if test="#session.user">
					<s:a class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><s:property value="#session.user.pseudo" /></s:a>
					<ul class="dropdown-menu">
						<li><s:a action="deconnexion">Déconnexion</s:a></li>
					</ul>	
				</s:if>
				<s:else>
					<s:a action="connexion" class="btn btn-primary">Se connecter</s:a>
				</s:else>
			</div>
			<div class="col-lg-1">
				<a class="btn btn-primary">Ajouter un site</a>	
			</div>
			<div class="col-lg-1">	
				<select id="selectLangue" name="langue" class="form-control">
					<option value="france">FR</option>
					<option value="anglais">EN</option>
				</select>  
			</div>
			<!-- jQuery -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
			<!-- Javascript de Bootstrap -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		</header>


		<div class="container-fluid">

			<div class="row">
				<div class="col-lg-2">
					<s:select id="selectSite" name="site" list="listSite" listKey="id" listValue="nomSite" class="form-control"/>
				</div>
				<div class="col-lg-2">
					<s:select id="selectSecteur" name="secteur" list="listSecteur" listKey="id" listValue="nomSecteur" class="form-control"/>
				</div>
				<div class="col-lg-2">
					<s:select id="selectVoie" name="voie" list="listVoie" listKey="id" listValue="nomVoie" class="form-control"/>
				</div>
				<div class="col-lg-2">
					<s:select id="selectCommentaire" name="commentaire" list="listCommentaire" listKey="id" listValue="commentaire" class="form-control"/>
				</div>
				<div class="col-lg-2">
					<s:select id="selectUtilisateur" name="commentaire" list="listUtilisateur" listKey="id" listValue="adresseMail" class="form-control"/>
				</div>
				<div class="col-lg-2">
					<s:select id="selectFormulaireContact" name="formulaireContact" list="listFormulaireContact" listKey="id" listValue="message" class="form-control"/>
				</div>

				<div class="col-lg-2">
					<s:select id="selectPhoto" name="photo" list="listPhoto" listKey="id" listValue="nomPhoto" class="form-control"/>
				</div>	
			</div>
			
		</div>

	</body>
</html>