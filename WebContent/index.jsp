<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Advert" %>
<%@ page import="java.util.List" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adverts</title>
</head>
<body>
	<h1>Adverts</h1>
	
	<h3>Menu</h3>
	<ul>
		<li><a href="addAdvert">Ajouter une annonce</a></li>
	</ul>
	
	
	<hr/>
	
	
	<% List<Advert> list = (List<Advert>) request.getAttribute("listAd"); %>
	<h2>Liste des annonces</h2>
	<ul>
		<% for(Advert advert : list){ %>
			<li>
				<h2><%= advert.getId() %> - <a href="Advert?id=<%= advert.getId() %>"><%= advert.getTitle() %></a></h2>
			 </li>
		<% } %>
	</ul>
	
</body>
</html>