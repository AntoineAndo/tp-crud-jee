<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Advert" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% Advert advert = (Advert) request.getAttribute("advert"); %>

	<form method="POST" action="editAdvert">
		<input type="hidden" name="id" value="<%= advert.getId()%>">
		<input type="text" name="title" value="<%= advert.getTitle()%>" ><br/>
		<input type="text" name="description" value="<%= advert.getDescription()%>" ><br/>
		<input type="submit" >
	</form>
</body>
</html>