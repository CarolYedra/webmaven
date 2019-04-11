<!DOCTYPE html>
<%@page import="es.avalon.jpa.negocio.Libro"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>EDITAR LIBRO</title>
</head>
<body>


<form action="salvarlibro">
<p>Autor: <input type="text" name="autor" value="${libro.autor}"/></p>
<p>Titulo: <input type="text" name="titulo" value="${libro.titulo}" /></p>
<p>Pagina: <input type="text" name="pagina" value="${libro.pagina}"/></p>
<p><input type="submit" value="enviar"></p>


</form>

</body>
</html>