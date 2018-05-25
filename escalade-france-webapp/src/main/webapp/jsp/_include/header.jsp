<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<header class="row">
	<div class="col-lg-2" id="nomSiteWeb">
		<s:a action="index">escalade-france.com</s:a>
	</div>
	<div class="col-lg-7">
		<s:form class="form-inline">
			<div class="form-group">
				<label class="sr-only" for="selectPays">Pays</label>
			    <s:select id="selectPays" name="pays.id" list="#session.listPays" listKey="id" listValue="nomPays" class="form-control"/>
			    			   				
   				<label class="sr-only" for="selectRegion">Region</label>
				<s:select id="selectRegion" name="region.id" list="#session.listRegion" listKey="id" listValue="nomRegion" class="form-control"/>
				
				<label class="sr-only" for="selectDepartement">Departement</label>
				<s:select id="selectDepartement" name="departement.id" list="#session.listDepartement" listKey="id" listValue="nomDepartement"
				class="form-control"/>
				<s:textfield name="rechercheSite" placeholder="Rechercher un site" requiredLabel="true" />
				<s:submit value="Rechercher" class="btn btn-primary"/>
			</div>
		</s:form>	
	</div>
	<div class="col-lg-1">
		<s:if test="#session.user">
			<s:a class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><s:property value="#session.user.pseudo" /></s:a>
			<ul class="dropdown-menu">
				<s:if test="#session.user.administrateur==true">
					<li><s:a action="visu_formulaire_contact">Formulaire Contact</s:a></li>
				</s:if>
				<li>
					<s:a action="page_utilisateur_fa">
						<s:param name="id" value="#session.user.id"/>
						Fil d'activité
					</s:a>
				</li>
				<li><s:a action="deconnexion">Déconnexion</s:a></li>
			</ul>	
		</s:if>
		<s:else>
			<s:a action="connexion" class="btn btn-primary">Se connecter</s:a>
		</s:else>
	</div>
	<div class="col-lg-1">
		<s:a class="btn btn-primary" action="page_ajout_site">Ajouter un site</s:a>
	</div>
	<div class="col-lg-1">	
		<select id="selectLangue" name="langue" class="form-control">
			<option value="france">FR</option>
			<option value="anglais">EN</option>
		</select>
   
	</div>
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<!-- Javascript de Bootstrap -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</header>
