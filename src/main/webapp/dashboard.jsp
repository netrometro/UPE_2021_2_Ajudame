<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${user != null}">

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ajudame</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<header class="topbar">
			<h1 class="brand">Ajudame ;)</h1>
		</header>
		
		<div class="card">
			<h2>Olá  ${user.name}</h2>
			<nav>
				<a href="usuario.html">Usuário</a>
				<a href="forum.html">Fórum</a>
				<form action="/upe_20212_ajudame/questionario/buscarUser" method="post" style="width: 200px;">
					<input type="hidden" name="id" id="id" value="${user.id}" />
					<input type="hidden" name="email" id="email" value="${user.email}" />
					<input type="submit" style="color: blue" value="Questionario" />
				</form>
				
				<a href="sair">SAIR</a>
			</nav>
		</div>
		
		<footer class="bottombar">
		
		</footer>
	</body>
</html>

</c:if>