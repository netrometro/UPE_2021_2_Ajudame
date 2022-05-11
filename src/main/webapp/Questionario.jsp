<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="">
		<input type="text" id="tema" name="tema" />
		<input type="submit" value="Buscar"/>
	</form>

	<h1>Questionario</h1>
	<p>Tema: ${ questionario.tema }</p>
	<p>Total de Acertos: ${questionario.totalAcertos }</p>
	<p>Total de Erros: ${ questionario.totalErros }</p>
	<p>Usuario: ${ user.name }</p>
	<p>Pergunta: ${ questionario.questoes }</p>
	
	

</body>
</html>