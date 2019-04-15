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
			<th>Nombre</th>

		<c:forEach items="${listaCategoria}" var="categoria">
			<tr>
				
				<td>${categoria.id}</td>
				<td>${categoria.nombre}</td>
				<td><a href="verlibros?id=${categoria.id}">Ver libros</a></td>
				<td><a href="listaLibrosQ?categoriaId=${categoria.id}">Ver lib</a></td>
	
		
			</tr>
		</c:forEach>
	</table>


</body>
</html>