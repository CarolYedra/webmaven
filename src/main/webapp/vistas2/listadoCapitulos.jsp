<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="es.avalon.jpa.negocio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}
th, td {
	text-align: left;
	padding: 8px;
}
tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			
			<th>Titulo</th>
			<th>Paginas</th>

		<c:forEach items="${listaCapitulos}" var="capitulo">
			<tr>
				
				<td>${capitulo.titulo}</td>
				<td>${capitulo.paginas}</td>
				<td><a 
					href="ServletControladorFrontal?accion=borrarCapitulo&titulo=${capitulo.titulo}&libroTitulo=${param.titulo}" />
					Borrar </a></td>
				<td><a
					href="ServletControladorFrontal?accion=formularioEditarCapitulo&titulo=${capitulo.titulo}" />
					Editar </a></td>
				
			</tr>
		</c:forEach>
	</table>
<a href="ServletControladorFrontal?accion=formularioInsertarCapitulo&libroTitulo=${param.titulo}"/> Insertar </a>
<a href="ServletControladorFrontal?accion=listadoLibros"/> Volver </a>
</body>
</html>