<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h4>
		<a href="/upe_20212_ajudame/questionario/questoes">Voltar a Listar Questoes</a>
	</h4> </br>

	<h1>Atualizar Questao</h1>
	
	<form method="post" action="/upe_20212_ajudame/questionario/questao/atualizar">
		<input type="hidden" name="id" id="id" value="${ questao.id }"/>
		<input type="text" name="pergunta" id="pergunta" value="${ questao.pergunta }" placeholder="Digite a Pergunta"/> </br>
		<input type="text" name="resposta" id="resposta" value="${ questao.resposta }" placeholder="Digite a resposta"/> </br>
		<input type="text" name="explicacao" id="explicacao" value="${ questao.explicacao }" placeholder="Digite a Explicação"/> </br>
		
		<input type="hidden" name="idAlternativaA" id="idAlternativaA" value="${ questao.alternativas[0].id }"/>
		<input type="text" name="alternativaA" id="alternativaA" value="${ questao.alternativas[0].alternativa }"/> </br>
		
		<input type="hidden" name="idAlternativaB" id="idAlternativaB" value="${ questao.alternativas[1].id }"/>
		<input type="text" name="alternativaB" id="alternativaB" value="${ questao.alternativas[1].alternativa }"/> </br>
		
		<input type="hidden" name="idAlternativaC" id="idAlternativaC" value="${ questao.alternativas[2].id }"/>
		<input type="text" name="alternativaC" id="alternativaC" value="${ questao.alternativas[2].alternativa }"/> </br>
		
		<input type="hidden" name="idAlternativaD" id="idAlternativaD" value="${ questao.alternativas[3].id }"/>
		<input type="text" name="alternativaD" id="alternativaD" value="${ questao.alternativas[3].alternativa }"/> </br>
		
		<input type="hidden" name="idAlternativaE" id="idAlternativaE" value="${ questao.alternativas[4].id }"/>
		<input type="text" name="alternativaE" id="alternativaE" value="${ questao.alternativas[4].alternativa }"/> </br>
		<input type="submit" value="Atualizar" />
	</form>
 	
</body>
</html>