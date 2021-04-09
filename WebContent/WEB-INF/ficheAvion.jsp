<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<c:choose>
		<c:when test="${adherent != null}"><h2>Modifier informations appareil</h2></c:when>
		<c:otherwise><h2>Ajouter nouvel appareil</h2></c:otherwise>
	</c:choose>	
	
	
	<c:choose>
		<c:when test="${adherent != null}"><form method="post" action="update"></c:when>
		<c:otherwise><form method="post" action="add"></c:otherwise>
	</c:choose>	

	<p>
		<label>ID</label>
		<input type="text" name="id" placeholder="ex: 123" value="<c:out value="${avion.id}"/>"></input>
	</p>
	<p>
		<label>Constructeur</label>
		<input type="text" name="constructeur" placeholder="ex: AIRBUS" value="<c:out value="${avion.constructeur}"/>"></input>
	</p>
	<p>
		<label>Modele</label>
			<input type="text" name="modele" placeholder="ex: A123" value="<c:out value="${avion.modele}"/>"></input>
	</p>
	<p>
		<label>Capacite</label>
			<input type="text" name="capacite" placeholder="ex: 100" value="<c:out value="${avion.capacite}"/>"></input>
	</p>
	<p>
		<label>Site</label>
			<input type="text" name="site" placeholder="ex: Paris" value="<c:out value="${avion.site}"/>"></input>
	</p>
		<button type="submit">Sauvegarder</button>
	</form>

</body>
</html>