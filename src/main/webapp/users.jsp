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
		<h2>Adicionar usuário</h2>
		<form action="add" method="post">
			<input type="text" id="name" name="name" placeholder="Digite o nome de usuário" /><br />
			<input type="text" id="email" name="email" placeholder="Digite o email" /><br />
			<input type="password" id="pass" name="pass" placeholder="Digite uma senha" /><br />
			<input type="submit" value="Adicionar" />
		</form>
		
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