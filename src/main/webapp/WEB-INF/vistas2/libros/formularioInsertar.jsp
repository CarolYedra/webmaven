<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERTAR LIBRO</title>
</head>
<body>

<%-- <form action="insertar"> --%>
<!-- <p>Titulo: <input type="text" name="titulo"></p> -->
<!-- <p>Autor: <input type="text" name="autor"></p> -->
<!-- <p>Pagina: <input type="text" name="pagina"></p> -->
<!-- <p><input type="submit" value="enviar"></p> -->
<%-- </form> --%>

<form:form method="POST" action="insertar" modelAttribute="libro">
             <table>
                <tr>
                    <td><form:label path="titulo">Titulo</form:label></td>
                    <td><form:input path="titulo"/>
                    <form:errors path="titulo"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="autor">Autor</form:label></td>
                    <td><form:input path="autor"/></td>
                </tr>
                <tr>
                    <td><form:label path="pagina">Paginas</form:label></td>
                    <td><form:input path="pagina"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Enviar"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>