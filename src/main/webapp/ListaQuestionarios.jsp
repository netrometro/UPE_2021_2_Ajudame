<%@ page language="java" 
contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajudame :: Questionarios</title>
<link rel="stylesheet" href="css/styleQuestionario.css" />
</head>
<body>

<h1>Ajudame</h1> </br>

<h4>
	<a href="/upe_20212_ajudame/CadastrarQuestionario.jsp">Criar Questionario</a>
</h4> </br>

		<h2>Lista de Questionarios</h2>
		<table border=1 class="tabelaListaQuestionarios">
			<thead>
				<tr>
					<th>Id</th>
					<th>curso</th>
					<th>Descricao</th>
					<th>user</th>
					<th>Atualizar</th>
					<th>Deletar</th>
					<th>Questões</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${questionarios}" var="questionario">
				<tr>
					<td><c:out value="${questionario.id}"/></td>
					<td><c:out value="${questionario.curso.nameCurso}"/></td>
					<td><c:out value="${questionario.curso.description}"/></td>
					<td><c:out value="${questionario.user.name}"/></td>
					<form action="/upe_20212_ajudame/questionario/buscar" method="post">
						<td>
							<input type="hidden" name="questionario" id="questionario" value="${questionario.id}" />
							<input type="hidden" name="curso" id="curso" value="${questionario.curso.nameCurso}" />
							<input type="submit" value="Atualizar"/>
						</td>
					</form>
					
					<form action="/upe_20212_ajudame/questionario/deletar" method="post">
						<td>
							<input type="hidden" name="questionario" id="questionario" value="${questionario.id}" />
							<input type="submit" value="Deletar" />
						</td>
					</form>
					<form action="/upe_20212_ajudame/questionario/questoes" method="post">
						<td>
							<input type="hidden" name="curso" id="curso" value="${questionario.curso.id}"/>
							<input type="submit" value="Questões"/>
						</td>
					</form> 
					
				</tr>
			</c:forEach>
			</tbody>
		</table>

</body>
</html>