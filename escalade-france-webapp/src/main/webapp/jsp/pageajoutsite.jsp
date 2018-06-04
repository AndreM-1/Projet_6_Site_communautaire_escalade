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
				<s:actionerror/>
				<!-- Section liée à la localisation -->
				<h2>Localisation</h2>
		
				<s:form action="page_ajout_site" method="POST" enctype="multipart/form-data" id="form_one">
					<s:form></s:form>
					<s:select id="selectPaysPaj" name="site.pays" label="Pays" list="listPays" listKey="id" listValue="nomPays" onchange="onSelectPaysPajChange()" requiredLabel="true" />
			
					<s:select id="selectRegionPaj" name="site.region" label="Region" list="listRegion" listValue="nomRegion" onchange="onSelectRegionPajChange()" requiredLabel="true" />
					
					<s:select id="selectDepartementPaj" name="site.departement" label ="Departement" list="listDepartement" listValue="nomDepartement" requiredLabel="true"/>
				
					<!-- Section liée au descriptif et à la photo du site -->
					<h2>Descriptif du site</h2>
					<s:textfield name="site.nomSite" label="Nom du site" requiredLabel="true"/>
					<s:textfield name="site.descriptif" label="Descriptif du site"/>
					
					<p><strong>Ajouter une photo pour le site</strong> </p>
					<p class="text-center">
						<s:a data-toggle="modal" href="#formUploadPhotoSite">
							<s:if test="%{site.photoSite.nomPhoto!=null}">
								<s:hidden name="site.photoSite.nomPhoto"/>
								<img src="<s:property value="site.photoSite.nomPhoto"/>" alt="Photo utilisateur"  width=100px height=100px/>
							</s:if>
							<s:else>
								<img src="jsp/assets/images/ajout_site_secteur.png" alt="Photo site" />
							</s:else>
						</s:a>
					</p>
					
					<!-- Boîte de dialogue modale pour uploader la photo d'un site -->
					<div class="modal fade" id="formUploadPhotoSite">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
				             		<button type="button" class="close" data-dismiss="modal">x</button>
		   							<h4 class="modal-title text-center">Ajouter une photo de site</h4>
								</div>
								<div class="modal-body">
									<s:form action="upload_photo_site" method="POST" enctype="multipart/form-data" id="form_two">
										<p class="text-center"><label for="fileSiteUpload">Sélectionner une photo :</label></p>
										<s:hidden name="site.photoSite.nomPhoto"/>
										<s:file name="fileSiteUpload" id="fileSiteUpload"></s:file>	
										<div class="text-center">							
											<s:submit value="Valider" class="btn btn-primary"/>
										</div>
									</s:form>
								</div>
							</div>
						</div>
					</div>	
					
					<!-- Section liée au secteur -->
					<h2>Secteur</h2>
					<h4><a href="#ajoutSecteur1" data-toggle="collapse">Ajouter un secteur</a></h4>
					<s:iterator var="counterSecteur" status="rowstatusSecteur" begin="1" end="3">
						<div id="ajoutSecteur${counterSecteur}" class="panel-collapse collapse" >
							<s:textfield name="site.listSecteur[%{#rowstatusSecteur.index}].nomSecteur"><h4>Nom du secteur ${counterSecteur} *</h4> </s:textfield>
							
							<!-- Section liée aux voies d'un secteur, d'où 2 boucles avec deux indices -->	
							<p><a href="#ajoutVoie${counterSecteur}1" data-toggle="collapse">Ajouter une voie</a></p>
							<s:iterator var="counterVoie" status="rowStatusVoie" begin="1" end="3">
								<div id="ajoutVoie${counterSecteur}${counterVoie}" class="panel-collapse collapse">
									<p><strong>Topo de la voie ${counterVoie}</strong></p>
									<div class="row">
										<div class="col-lg-3">
											<s:textfield name="site.listSecteur[%{#rowstatusSecteur.index}].listVoie[%{#rowStatusVoie.index}].nomVoie" value="Nom de la voie *"/> 
										</div>
										<div class="col-lg-3">
											<s:textfield name="site.listSecteur[%{#rowstatusSecteur.index}].listVoie[%{#rowStatusVoie.index}].cotation" value="Cotation"/>
										</div>
										<div class="col-lg-2">
											<s:textfield name="site.listSecteur[%{#rowstatusSecteur.index}].listVoie[%{#rowStatusVoie.index}].hauteur" value="Hauteur"/> 
										</div>
										<div class="col-lg-2">
											<s:textfield name="site.listSecteur[%{#rowstatusSecteur.index}].listVoie[%{#rowStatusVoie.index}].nbPoints" value="Nb points"/>
										</div>
										<div class="col-lg-2">
											<s:textfield name="site.listSecteur[%{#rowstatusSecteur.index}].listVoie[%{#rowStatusVoie.index}].duree" value="Durée"/>
										</div>
									</div>
									<s:if test="#rowStatusVoie.last==false">
										<p><a href="#ajoutVoie${counterSecteur}${counterVoie+1}" data-toggle="collapse">Ajouter une voie</a></p>
									</s:if>
								</div>
							</s:iterator>
								
							<!-- Section liée aux photos d'un secteur, d'où 2 boucles avec deux indices -->
							<p><strong>Ajouter des photos pour le secteur (3 photos max)</strong></p>	
							
							<div class="row">
								<div class="col-lg-offset-2 col-lg-10">
									<s:iterator var="counterPhotoSecteur" status="rowStatusPhotoSecteur" begin="1" end="3">
										<s:a data-toggle="modal" href="#formUploadPhotoSecteur%{counterSecteur}%{counterPhotoSecteur}">
											<img src="jsp/assets/images/ajout_site_secteur.png" alt="Photo utilisateur anonyme" />
										</s:a>
										<!-- Boîte de dialogue modale pour uploader les photos d'un secteur  -->
										<div class="modal fade" id="formUploadPhotoSecteur${counterSecteur}${counterPhotoSecteur}">
											<div class="modal-dialog modal-sm">
												<div class="modal-content">
													<div class="modal-header">
										             		<button type="button" class="close" data-dismiss="modal">x</button>
								     						<h4 class="modal-title text-center">Ajouter une photo de secteur ${counterSecteur}${counterPhotoSecteur}</h4>
													</div>
													<div class="modal-body">
														<s:form action="" method="POST" namespace="/" enctype="multipart/form-data">
															<p class="text-center"><label for="filePhotoSecteurUpload${counterSecteur}${counterPhotoSecteur}">Sélectionner une photo :</label></p>
															<s:file name="filePhotoSecteurUpload%{counterSecteur}%{counterPhotoSecteur}" id="filePhotoSecteurUpload%{counterSecteur}%{counterPhotoSecteur}"></s:file>	
															<div class="text-center">							
																	<s:submit value="Valider" class="btn btn-primary"/>
															</div>
														</s:form>
													
													</div>
												</div>
											</div>
										</div>	
									</s:iterator>
								</div>
							</div>
							
							<s:if test="#rowstatusSecteur.last==false">
								<h4><a href="#ajoutSecteur${counterSecteur+1}" data-toggle="collapse">Ajouter un secteur</a></h4>
							</s:if>
						</div>	
					</s:iterator>
				
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