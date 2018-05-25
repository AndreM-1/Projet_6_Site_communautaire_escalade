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
			
			<p><s:property value="fileUploadFileName"/></p>
			<p><s:property value="fileUploadContentType"/></p>
			<p><s:property value="fileUpload"/></p>
			<p><img src="jsp/assets/images/utilisateur_1.jpg" alt ="Photo de montagne"/></p>
			
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
	
		</div>
	</body>
</html>