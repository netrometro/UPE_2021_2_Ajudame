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
		<a href="/upe_20212_ajudame/questionario/questoes">Voltar a Listar Questoes</a>
	</h4> </br>

	<h2>Respoder Pergunta</h2>
	<form action="/upe_20212_ajudame/questionario/questao/responder"
		method="post">
		<h3>${ questao.pergunta }</h3>
		<input type="hidden" name="resposta" id="resposta"
			value="${ questao.resposta }" /> <input type="hidden"
			name="explicacao" id="explicacao" value="${ questao.explicacao }" />
		<input type="checkbox" id="alternativaA" name="alternativaA"
			value="${ questao.alternativas[0].alternativa }"> <label
			for="alternativaA"> ${ questao.alternativas[0].alternativa }
		</label><br> <input type="checkbox" id="alternativaB" name="alternativaB"
			value="${ questao.alternativas[1].alternativa }"> <label
			for="alternativaB"> ${ questao.alternativas[1].alternativa }
		</label><br> <input type="checkbox" id="alternativaC" name="alternativaC"
			value="${ questao.alternativas[2].alternativa }"> <label
			for="alternativaC"> ${ questao.alternativas[2].alternativa }
		</label><br> <input type="checkbox" id="alternativaD" name="alternativaD"
			value="${ questao.alternativas[3].alternativa }"> <label
			for="alternativaD"> ${ questao.alternativas[3].alternativa }
		</label><br> <input type="checkbox" id="alternativaE" name="alternativaE"
			value="${ questao.alternativas[4].alternativa }"> <label
			for="alternativaE"> ${ questao.alternativas[4].alternativa }
		</label><br> <input type="submit" onclick="alertar()" value="Responder" />
	</form>

</body>
</html>