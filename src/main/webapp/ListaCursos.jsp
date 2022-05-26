<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Lista de Cursos</title>
		<link rel="stylesheet" href="css/styleListaCursos.css" />
</head>
<body>

	<header>
		<a class="menu_icon" href="/upe_20212_ajudame/cursos.jsp"><img src="img/back.png" style="width:42px;height:42px;" alt="add"></a>
		<h1>Lista de cursos</h1>
		<input class="searchMenu" type="search" name="search" placeholder="Procure um curso..." size="30" required>
        <a class="menu_icon" href="/upe_20212_ajudame/dashboard.jsp"><img src="img/user.png" style="width:42px;height:42px;" alt="add"></a>
	</header>
	
	<div class="listaCursos">
			<table border=1>
			<thead>
				<tr>
					<th>Nome do curso</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${cursos}" var="user">
				<tr>
					<td><c:out value="${cursos.id}"/></td>
					<td><c:out value="${cursos.nameCurso}"/></td>
					<td><c:out value="${curso.description}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
    <footer>
            Dev by: Bruno_npc
    </footer>
    
</html>