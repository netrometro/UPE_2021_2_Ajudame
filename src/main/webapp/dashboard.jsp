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
			<h2>Ol�  ${user.name}</h2>
			<nav>
				<a href="usuario.html">Usu�rio</a>
				<a href="forum.html">F�rum</a>
				<a href="questionario.html">Question�rio</a>
				<a href="sair">SAIR</a>
			</nav>
		</div>
		
		<footer class="bottombar">
		
		</footer>
	</body>
</html>

</c:if>