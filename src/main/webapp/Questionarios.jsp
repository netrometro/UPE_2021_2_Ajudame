<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajudame :: Questionarios</title>
</head>
<body>

<h1>Ajudame</h1>
		<h2>Lista de Questionarios</h2>
		<table border=1>
			<thead>
				<tr>
					<th>Tema</th>
					<th>Total de Acertos</th>
					<th>Total de Erros</th>
					<th>Usuario</th>
					<th>Pergunta</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${questionarios}" var="questionario">
				<tr>
					<td><c:out value="${questionario.tema}"/></td>
					<td><c:out value="${questionario.totalAcertos}"/></td>
					<td><c:out value="${questionario.totalErros}"/></td>
					<td><c:out value="${questionario.user}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

</body>
</html>