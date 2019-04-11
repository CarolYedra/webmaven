<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="es.avalon.jpa.negocio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>CAPITULOS</title>
<link rel=stylesheet type="text/css" href="../resources/css/estilo.css"> 
</head>
<body>

<table>
		<tr>
			<th><a href="ordenarCapitulo?orden=titulo?libroTitulo=${param.titulo}">Titulo</a></th>
			<th><a href="ordenarCapitulo?orden=paginas?libroTitulo=${param.titulo}">Paginas</a></th>
		</tr>
		
		<c:forEach items="${listaCapitulos}" var="capitulo">
			<tr>
				<td>${capitulo.titulo}</td>
				<td>${capitulo.paginas}</td>
				<td><a href="borrarCapitulo?titulo=${capitulo.titulo}&libroTitulo=${param.titulo}" > Borrar </a></td>
				<td><a href="formularioEditarCapitulo?titulo=${capitulo.titulo}&libroTitulo=${param.titulo}" >Editar </a></td>
				
			</tr>
		</c:forEach>
	</table>
<a href="formularioInsertarCapitulo?libroTitulo=${param.titulo}"> Insertar </a>

<a href="lista"> Volver </a>
</body>
</html>