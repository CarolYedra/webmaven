
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JavaScript :)</title>
<link rel=stylesheet type="text/css" href="../resources/css/estilo.css">
<script type="text/javascript" src="../resources/jquery-3.4.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#ajax").click(function(){
		
		$.get("../webapi/libros",function(datos){
						
			datos.forEach((libro)=> {
				$(`<option>\${libro.titulo}</option>`).appendTo("#listaLibros");
			})
			
		})
	});
		
	$("#listaLibros").change(function(){
		var libro=$(this).val();
		
		$.get(`../webapi/libros/\${libro}/capitulos`,function(datos){
			
			var $miselect = $("<select id='listaCap'/>");
			$('#listaCap').remove();
			datos.forEach((capitulo)=> {
				$(`<option>\${capitulo.titulo}</option>`).appendTo($miselect);
			})
			$("body").append($miselect);
		})
		
	});
	$("#botonInsertar").click(function(){
		/* console.log($("#titulo").val());
		console.log($("#autor").val());
		console.log($("#paginas").val()); */
		var libro={};
		libro.titulo=$("#titulo").val();
		libro.autor=$("#autor").val();
		libro.paginas=$("#paginas").val();
		console.log(libro);
		console.log(JSON.stringify(libro));
		
		$.ajax({
			url:'../webapi/libros',
			type:'post',
			dataType:'json',
			contentType:'application/json',
			success: function(data){
				console.log("todo ok");
			},
			data:JSON.stringify(libro)
		});
		
	})
	$("#botonBorar").click(function(){
		var libro =$("listaLibros").val();
		console.log(libro);
		$.ajax({
			url:'../webapi/libros/'+libro,
			type:'delete',
			dataType:'json',
			contentType:'application/json',
			success: function(data){
				console.log("todo ok");
			},
			
		});
		
	})
	});		
</script>
</head>
<body>

	Mira que libros!!
	<select id="listaLibros"></select>

	<input type="button" id="ajax" value="Ver" />
	<input type="button" id="botonBorrar" value="Borrar" />
	<form>
	<p><label for="titulo">titulo:</label><input type="text" name="titulo" id="titulo"/></p>
	<p><label for="autor">autor:</label><input type="text" name="autor" id="autor"/></p>
	<p><label for="paginas">paginas:</label><input type="text" name="paginas" id="paginas"/></p>
	<input type="button" id="botonInsertar" value="aceptar" />
	
	</form>

</body>
</html>
