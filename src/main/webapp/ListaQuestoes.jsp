<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="/upe_20212_ajudame/questionario/list">Lista de Questionarios</a>

 <h2>Tela de Listar Questões</h2>
 
 <table border=1>
			<thead>
				<tr>
					<th>Id</th>
					<th>pergunta</th>
					<th>Atualizar</th>
					<th>Deletar</th>
					<th>Responder</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${questoes}" var="questao">
				<tr>
					<td><c:out value="${questao.id}"/></td>
					<td><c:out value="${questao.pergunta}"/></td>
					
					<form action="/upe_20212_ajudame/questionario/questao/buscar" method="post">
						<td>
							<input type="hidden" name="questao" id="questao" value="${questao.id}" />
							<input type="submit" value="Atualizar"/>
						</td>
					</form>
					
					<form action="/upe_20212_ajudame/questionario/questao/deletar" method="post">
						<td>
							<input type="hidden" name="questao" id="questao" value="${questao.id}" />
							<input type="submit" value="Deletar" />
						</td>
					</form>
					<form action="/upe_20212_ajudame/questionario/questao/buscarPergunta" method="post">
						<td>
							<input type="hidden" name="questao" id="questao" value="${questao.id}"/>
							<input type="submit" value="Responder"/>
						</td>
					</form> 
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
 

</body>
</html>