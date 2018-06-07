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

	
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6" id="divAjoutSite">
				
				<h1 class="text-center">Ajouter un site</h1>
				<h4 class="text-center"><span id="etapeEnCours">Site</span>>>Photo du site>>Secteurs>>Voies>>Photo secteur</h4>
				<s:actionerror/>
				<!-- Section liée à la localisation -->
				<h2>Localisation</h2>
		
				<s:form action="page_ajout_site" method="POST">
					<s:select id="selectPaysPaj" name="site.pays" label="Pays" list="listPays" listKey="id" listValue="nomPays" onchange="onSelectPaysPajChange()" requiredLabel="true" />
			
					<s:select id="selectRegionPaj" name="site.region" label="Region" list="listRegion" listValue="nomRegion" onchange="onSelectRegionPajChange()" requiredLabel="true" />
					
					<s:select id="selectDepartementPaj" name="site.departement" label ="Departement" list="listDepartement" listValue="nomDepartement" requiredLabel="true"/>
				
					<!-- Section liée au descriptif et à la photo du site -->
					<h2>Descriptif du site</h2>
					<s:textfield name="site.nomSite" label="Nom du site" requiredLabel="true"/>
					<s:textarea name="site.descriptif" label="Descriptif du site" rows="4"/>															
						
					<!-- Section liée aux commentaires personnels -->
					<h2>Commentaires personnels</h2>
					<s:textarea name="site.commentairePersonnel" rows="4"/>
					<s:checkbox type="checkbox" name="site.topoDisponible" id="site.topoDisponible" label="Je souhaite mettre à disposition une topo pour ce site." />
					
					<!-- Validation de l'ensemble du formulaire d'ajout de site -->
					<p class="text-center">
						<s:submit value="Valider" class="btn btn-primary btn-lg"/> 
					</p>
				</s:form>
			</div>
		</div>
				
		<!-- Section liée au chaînage des listes déroulantes -->
		<script>
        function onSelectPaysPajChange(){
        	// URL de l'action AJAX
        	var url = "<s:url action="page_ajout_site_ajax_getListRegion"/>";
        	
            // Paramètres de la requête AJAX
            var params = {
            		pays: jQuery("#selectPaysPaj").val()
            };
        	
        	// Action AJAX en POST
        	jQuery.post(
     			url,
     			params,
                function (data) {
                    var $selectRegion = jQuery("#selectRegionPaj");
                    var $selectDepartement = jQuery("#selectDepartementPaj");
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
        
        function onSelectRegionPajChange(){
        	// URL de l'action AJAX
        	var url = "<s:url action="page_ajout_site_ajax_getListDepartement"/>";
        	
            // Paramètres de la requête AJAX
            var params = {
            		region: jQuery("#selectRegionPaj").val()
            };
        	
        	// Action AJAX en POST
        	jQuery.post(
     			url,
     			params,
                function (data) {
                    var $selectDepartement = jQuery("#selectDepartementPaj");
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

		<!-- Pied de page -->
		<%@ include file="_include/footer.jsp"%>
	</div>

</body>
</html>