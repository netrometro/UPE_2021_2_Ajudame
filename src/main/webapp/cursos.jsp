<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Meus Cursos</title>
		<link rel="stylesheet" href="css/styleCursos.css" />
	</head>

    <header>
            <h1>Cursos</h1>
            <input class="searchMenu" type="search" name="search" placeholder="Procure um curso..." size="30" required>
            <a class="menu_icon" href="/upe_20212_ajudame/cursosAdd.jsp"><img src="img/add.png" style="width:42px;height:42px;" alt="add"></a>
            <a class="menu_icon" href="/upe_20212_ajudame/dashboard.jsp"><img src="img/user.png" style="width:42px;height:42px;" alt="login"></a>
            <a class="menu_icon" href="/upe_20212_ajudame/ListaCursos.jsp"><img src="img/all.png" style="width:42px;height:42px;" alt="all"></a>
    </header>

	<body>
        <div class="aluno">
            <h2>Area do aluno</h2>
            <div class="cards">
                <div class="cards__item">
                    <h3>Java</h3>
                    <img class="card_img" src="img/java.png" alt="Java">
                    <p class="card_description">Curso de java</p>
                    <button type="button" class="verCurso">Ver curso</button>
                </div>
                <div class="cards__item">
                    <h3>Java</h3>
                    <img class="card_img" src="img/java.png" alt="Java">
                    <p class="card_description">Curso de java</p>
                    <button type="button" class="verCurso">Ver curso</button>
                </div>
                <div class="cards__item">
                    <h3>Java</h3> 
                    <img class="card_img" src="img/java.png" alt="Java">
                    <p class="card_description">Curso de java</p>
                    <button type="button" class="verCurso">Ver curso</button>
                </div>
            </div>
        </div>

		<div class="prof">
		    <h2>Area do Professor</h2>
            <div class="cards">
                <div class="cards__item">
                    <h3>Java</h3>
                    <img class="card_img" src="img/java.png" alt="Java">
                    <p class="card_description">Curso de java</p>
                    <button type="button" class="verCurso">Ver curso</button>
                </div>
            </div>
		</div>
	</body>

    <footer>
            Dev by: Bruno_npc
    </footer>
</html>