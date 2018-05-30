<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<header class="row">
	<div class="col-lg-2" id="nomSiteWeb">
		<s:a action="index">escalade-france.com</s:a>
	</div>
	<div class="col-lg-7" id="barreDeRecherche">
		<s:form class="form-inline" method="POST">
			<div class="form-group">
				<label class="sr-only" for="selectPays">Pays</label>
			    <s:select id="selectPays" name="pays" list="#session.listPays" listKey="id" listValue="nomPays" onchange="onSelectPaysChange()" class="form-control"/>
		 	</div>
		 	<div class="form-group">			   				
   				<label class="sr-only" for="selectRegion">Region</label>
				<s:select id="selectRegion" name="region" list="#session.listRegion" listValue="nomRegion" onchange="onSelectRegionChange()" class="form-control"/>
			</div>	
			<div class="form-group">
				<label class="sr-only" for="selectDepartement">Departement</label>
				<s:select id="selectDepartement" name="departement" list="#session.listDepartement" listValue="nomDepartement" class="form-control" />
			</div>
			<div class="form-group">
				<s:textfield name="rechercheSite" placeholder="Rechercher un site" requiredLabel="true" />
			</div>
				<s:submit value="Rechercher" class="btn btn-primary" width="500px"/>
		
		</s:form>	
	</div>
	<div class="col-lg-1">
		<s:if test="#session.user">
			<s:a class="btn btn-primary dropdown-toggle btn-block" data-toggle="dropdown"><s:property value="#session.user.pseudo" /></s:a>
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
			<s:a action="connexion" class="btn btn-primary btn-block">Se connecter</s:a>
		</s:else>
	</div>
	<div class="col-lg-2">
		<s:a class="btn btn-primary btn-block" action="page_ajout_site">Ajouter un site</s:a>
	</div>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<!-- Javascript de Bootstrap -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- Section liée au chaînage des listes déroulantes -->
	<script>
    function onSelectPaysChange(){
   		// URL de l'action AJAX
   		var url = "<s:url action="page_ajout_site_ajax_getListRegion"/>";
    	
        // Paramètres de la requête AJAX
        var params = {
        		pays: jQuery("#selectPays").val()
        };
    	
    	// Action AJAX en POST
    	jQuery.post(
 			url,
 			params,
            function (data) {
                var $selectRegion = jQuery("#selectRegion");
                var $selectDepartement = jQuery("#selectDepartement");
                $selectRegion.empty();
                $selectDepartement.empty();
                jQuery.each(data, function (key, val) {
                    $selectRegion.append(
                        jQuery("<option>")
                            .text(val.nomRegion)
                            .val(val.nomRegion)
                            .val(val.id)
                    );
                });
            })
         .fail(function (data) {
             if (typeof data.responseJSON === 'object') {
                 console.log(data.responseJSON);
             } else {
                 console.log(data);
             }
             alert("Une erreur s'est produite.");
         });
    }
    
    function onSelectRegionChange(){
    	// URL de l'action AJAX
    	var url = "<s:url action="page_ajout_site_ajax_getListDepartement"/>";
    	
        // Paramètres de la requête AJAX
        var params = {
        		region: jQuery("#selectRegion").val()
        };
    	
    	// Action AJAX en POST
    	jQuery.post(
 			url,
 			params,
            function (data) {
                var $selectDepartement = jQuery("#selectDepartement");
                $selectDepartement.empty();
                jQuery.each(data, function (key, val) {
                    $selectDepartement.append(
                        jQuery("<option>")
                            .text(val.nomDepartement)
                            .val(val.nomDepartement)
                            .val(val.id)
                    );
                });
            })
         .fail(function (data) {
             if (typeof data.responseJSON === 'object') {
                 console.log(data.responseJSON);
             } else {
                 console.log(data);
             }
             alert("Une erreur s'est produite.");
         });
    }
      
   	</script>

</header>
