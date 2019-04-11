<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="es.avalon.jpa.negocio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>CATEGORIAS</title>
<link rel=stylesheet type="text/css" href="../resources/css/estilo.css"> 
</head>
<body>

<table>
		<table>
		<tr>
			
			<th>ID</th>
			<th>Titulo</th>

		<c:forEach items="${listaCategoria}" var="categoria">
			<tr>
				
				<td>${categoria.id}</td>
				<td>${categoria.titulo}</td>
				
		
			</tr>
		</c:forEach>
	</table>


<a href="lista"> Volver </a>
</body>
</html>