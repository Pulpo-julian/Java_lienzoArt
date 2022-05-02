<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>

<% List<Integer> numeros = (List<Integer>) request.getAttribute("listNumeros"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
	<%for(int i = 0; i < numeros.size(); i++){ %>
		
		<h1><% out.print("servidor hecho en: " + i);%></h1>
		
	<%} %>
		
		
	</body>
</html>