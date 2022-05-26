<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Meus Cursos</title>
		<link rel="stylesheet" href="css/styleCursoAdd.css" />
	</head>

    <header>
    		<a class="menu_icon" href="/upe_20212_ajudame/cursos.jsp"><img src="img/back.png" style="width:42px;height:42px;" alt="add"></a>
            <h1>Add Curso</h1>
            <input class="searchMenu" type="search" name="search" placeholder="Procure um curso..." size="30" required>
            <a class="menu_icon" href="/upe_20212_ajudame/dashboard.jsp"><img src="img/user.png" style="width:42px;height:42px;" alt="add"></a>
    </header>

	<body>
        <div class="cursoAdd">
            <h2>Informações base do curso</h2>
            
			<form action="addCurso" method="post">
				<input type="text" id="nameCurso" name="nameCurso" placeholder="Nome do curso..." /><br />
				<input type="text" id="description" name="description" placeholder="Desrição do curso..." /><br />
				<input type="submit" value="Adicionar curso" />
			</form>
        </div>

	</body>

    <footer>
            Dev by: Bruno_npc
    </footer>
</html>