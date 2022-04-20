<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ajudame :: Users</title>
	</head>
	
	<body>
		<h1>Ajudame</h1>
		<h2>Lista de Usuários</h2>
		<table border=1>
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>E-mail</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.id}"/></td>
					<td><c:out value="${user.name}"/></td>
					<td><c:out value="${user.email}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</body>
</html>