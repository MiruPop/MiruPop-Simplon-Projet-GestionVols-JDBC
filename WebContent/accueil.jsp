<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GestionVols</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
</head>
<body>
	<p>Bienvenu sur l'application de gestion de la companie aérienne "ZBOR"</p>
	<div class="container text-left">
		<a href="<c:url value="/avions"/>"><input type="button" value="Gestion appareils"/></a>
		<a href="<c:url value="/pilotes"/>"><input type="button" value="Gestion pilotes"/></a>
		<a href="<c:url value="/vols"/>"><input type="button" value="Gestion vols"/></a>
	</div>

</body>
</html>