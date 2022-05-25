<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styleQuestionario.css" />
</head>
<body>

<h1 class="cabecalho">Criar Questionario</h1>
	<p>${user.email}</p>
	<div>
		<a href="/upe_20212_ajudame/questionario/list">Listar Questionarios</a>
	</div>
	<div>
		<a href="/upe_20212_ajudame/dashboard.jsp">Dashboard</a>
	</div>


	<form action="/upe_20212_ajudame/questionario" method="post" class="formulario">
		<input type="hidden" id="userId" name="userId" value="${user.id}"/> 
		<input type="text" id="curso" name="curso" placeholder="insira o curso"/> </br>
		<input type="text" id="pergunta" name="pergunta" placeholder="insira a pergunta" /> </br>
		<input type="text" id="resposta"name="resposta" placeholder="insira a resposta" /> </br>
		<input type="text" id="explicacao" name="explicacao" placeholder="insira a explicacao" /> </br>
		<input type="text" id="alternativa1" name="alternativa1" placeholder="alternativa A"/> </br>
		<input type="text" id="alternativa2" name="alternativa2" placeholder="alternativa B"/> </br>
		<input type="text" id="alternativa3" name="alternativa3" placeholder="alternativa C"/> </br>
		<input type="text" id="alternativa4" name="alternativa4" placeholder="alternativa D"/> </br>
		<input type="text" id="alternativa5" name="alternativa5" placeholder="alternativa E"/> </br>
		<input type="submit" value="Criar" /> </br>
	</form>
	
	



</body>
</html>