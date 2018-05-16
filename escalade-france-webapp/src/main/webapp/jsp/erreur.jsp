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
		    <h1 class="text-center">Une erreur s'est produite</h1>
		    <s:actionerror />
		    
			<!-- Pied de page -->
			<%@ include file="_include/footer.jsp"%>
	    </div>
	</body>
</html>