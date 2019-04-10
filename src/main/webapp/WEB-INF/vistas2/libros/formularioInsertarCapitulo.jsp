<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="insertarCapitulo">
<p>Titulo: <input type="text" name="titulo"></p>
<p>Paginas: <input type="text" name="paginas"></p>

<p><input type="submit" value="enviar"></p>


<input type="hidden" name="Libro_Titulo" value= "${param.libroTitulo}"/> 
</form>
</body>
</html>