<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h4>
		<a href="/upe_20212_ajudame/questionario/list">Voltar Listar Questionarios</a>
	</h4> </br>

	<h1>Atualizar Questionario</h1>
	
	<form method="post" action="/upe_20212_ajudame/questionario/atualizar">
		<input type="hidden" name="questionario" id="questionario" value="${questionario}" />
		<input type="text" name="nameCurso" id="nameCurso" value="${ curso.nameCurso }"/>
		<input type="submit" value="Atualizar"/>
	</form>
	

</body>
</html>