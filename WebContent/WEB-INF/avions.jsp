<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des appareils de vol</title>
</head>
<body>

		<table class="table table-bordered  table-hover table-responsive">
			<thead>
				<tr style="background-color: lightgrey">
					<th>ID</th>
					<th>Constructeur</th>
					<th>Modele</th>
					<th>Capacite</th>
					<th>Site</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="avion" items="${liste}">
					<tr>
						<td><c:out value="${avion.id}"/></td>
						<td><c:out value="${avion.constructeur}"/></td>
						<td><c:out value="${avion.modele}"/></td>
						<td><c:out value="${avion.capacite}"/></td>
						<td><c:out value="${avion.site}"/></td>
						<td><a href=
								"<c:url value="updateForm">
									<c:param name="id" value="${avion.id}"/>
								</c:url>"
						>Modifier</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="<c:url value="/addForm"></c:url>">Ajouter un appareil</a>

</body>
</html>