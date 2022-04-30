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
	<form action="/upe_20212_ajudame/register" method="post">
		<input type="text" id="name" name="name" />
		<input type="password" id="password" name="password" />
		<input type="email" id="email" name="email" />
		<input type="submit" value="Registrar" />
	</form>
</body>
</html>