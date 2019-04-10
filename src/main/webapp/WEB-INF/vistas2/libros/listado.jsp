<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="es.avalon.jpa.negocio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th><a href="ServletControladorFrontal?accion=ordenar&orden=titulo">Titulo</a></th>
			<th><a href="ServletControladorFrontal?accion=ordenar&orden=autor">Autor</a></th>
			<th><a href="ServletControladorFrontal?accion=ordenar&orden=paginas">Paginas</a></th>
		</tr>
		<c:forEach items="${listaLibros}" var="libro">
			<tr>

				<td>${libro.titulo}</td>
				<td>${libro.autor}</td>
				<td>${libro.pagina}</td>
				<td><a 
					href="ServletControladorFrontal?accion=borrar&titulo=${libro.titulo}" />
					Borrar </a></td>
				<td><a
					href="ServletControladorFrontal?accion=formularioEditar&titulo=${libro.titulo}" />
					Editar </a></td>
				<td><a href="ServletControladorFrontal?accion=listaCapitulos&titulo=${libro.titulo}">ver capitulos</a></td>
			</tr>
		</c:forEach>


	</table>

	<a href="ServletControladorFrontal?accion=formularioInsertar"/> Insertar
	</a>

</body>
</html>
