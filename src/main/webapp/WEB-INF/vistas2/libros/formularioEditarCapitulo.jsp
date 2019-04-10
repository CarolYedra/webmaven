<!DOCTYPE html>
<%@page import="es.avalon.jpa.negocio.Capitulo"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="ServletControladorFrontal">

<p>Titulo: <input type="text" name="titulo" value="${capitulo.titulo}" /></p>
<p>Pagina: <input type="text" name="paginas" value="${capitulo.paginas}"/></p>
<p><input type="submit" value="enviar"></p>

<input name="tituloOriginal" type="hidden" value="${capitulo.titulo}" >
<input type="hidden" name="accion" value= "salvarCapitulo"/>


<input type="hidden" name="libroTitulo" value= "${param.libroTitulo}"/>

</form>

</body>
</html>