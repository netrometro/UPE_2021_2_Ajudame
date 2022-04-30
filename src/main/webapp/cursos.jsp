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
                <div>
                    <input class="menu_add" type="image" src="img/add.png" alt="add"/>
                    <input class="menu_login" type="image" src="img/user.png" alt="login"/>
                </div>
    </header>

	<body>
        <div class="aluno">
            <h2>Area do aluno</h2>
            <div class="cards">
                <div class="cards__item">
                    <h3>Java</h3>
                    <img src="img/java.png" alt="Java">
                    <p class="card_description">Curso de java</p>
                </div>
                <div class="cards__item">
                    <h3>Java</h3>
                    <img src="img/java.png" alt="Java">
                    <p class="card_description">Curso de java</p>
                </div>
                <div class="cards__item">
                    <h3>Java</h3> 
                    <img src="img/java.png" alt="Java">
                    <p class="card_description">Curso de java</p>
                </div>
            </div>
        </div>

		<div class="prof">
		    <h2>Area do Professor</h2>
            <div class="cards">
                <div class="cards__item">
                    <h3>Java</h3>
                    <img src="img/java.png" alt="Java">
                    <p class="card_description">Curso de java</p>
                </div>
            </div>
		</div>
	</body>

    <footer>
        <p>
            Dev by: Bruno_npc
        </p>
    </footer>
</html>