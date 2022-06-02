<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Ajudame :: Ranking </title>
			
			
			
		</head>

		<body>
			<h1 > Ajudame</h1>

			<h2 > Ranking </h2>
			<table border=0>
		
		<thead>
			<tr>

				<th>Nome</th>
				<th>Ranking</th>

			</tr>
			
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>

					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.ranking}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
