<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajouter une annonce</h1>
	<a href="AdvertServlet">Retour à l'accueil</a>
	<hr/>
	<form method="POST" action="addAdvert">
		<input type="text" name="title" placeholder="TITLE"><br/>
		<input type="text" name="description" placeholder="DESCRIPTION"><br/>
		<input type="submit" >
	</form>
</body>
</html>