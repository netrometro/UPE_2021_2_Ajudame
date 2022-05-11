<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ajudame</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<header class="topbar">
			<h1 class="brand">Ajudame ;)</h1>
		</header>
		<section class="content">
			<article class="card">
			<h2 class="card-title">Possui conta</h2>
				<form class="card-form" action="entrar" method="POST">
					<input type="email" name="email" id="email" placeholder="Digite seu e-mail" />
					<input type="password" name="pass" id="pass" placeholder="Digite uma senha" />
					<input type="submit" value="Entrar"/>
				</form>
			</article>
			<article class="card">
			<h2 class="card-title">Criar conta</h2>
				<form class="card-form" action="registrar" method="POST">
					<input type="text" name="nome" id="nome" placeholder="Digite seu nome" />
					<input type="email" name="email" id="email" placeholder="Digite seu e-mail" />
					<input type="password" name="pass" id="pass" placeholder="Digite uma senha" />
					<input type="submit" value="Registrar-se"/>
				</form>
			</article>
		</section>
		</div>
		<footer class="bottombar">
		
		</footer>
	</body>
</html>