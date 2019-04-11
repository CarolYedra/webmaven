<!DOCTYPE html>
<%@page import="es.avalon.jpa.negocio.Capitulo"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>EDITAR CAPITULO</title>
</head>
<body>


<form action="salvarcapitulo">

<p>Titulo: <input type="text" name="titulo" value="${capitulo.titulo}" /></p>
<p>Pagina: <input type="text" name="paginas" value="${capitulo.paginas}"/></p>

<input type="hidden" name="libro_Titulo" value= "${param.libroTitulo}"/>

<p><input type="submit" value="enviar"></p>

<%-- <input type="hidden" name="tituloOriginal" value="${capitulo.titulo}" > --%>
<!-- <input type="hidden" name="accion" value= "salvarCapitulo"/>  -->


</form>

</body>
</html>