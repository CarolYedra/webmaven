package es.avalon.spring.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/webapi/libros")
public class LibroRestController {
	
	@Autowired
	ServicioLibros servicio;
	@RequestMapping
	@ResponseBody
	public Iterable <Libro> buscarTodos(){
		
		return servicio.buscarTodosLosLibros();
		
	}
	@RequestMapping ("/{titulo}/capitulos")
	@ResponseBody
	public Iterable <Capitulo> buscarTodosLosCapitulosParaUnLibro(@PathVariable("titulo") String titulo){
		
		return servicio.buscarTodosParaUnLibroCapitulo(new Libro(titulo));
		
	}
	@RequestMapping (method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void insertar(@RequestBody Libro libro) {
		
		System.out.println(libro.getTitulo());
		
		servicio.insertarLibro(libro);
	}
	@RequestMapping (value="/{titulo}", method=RequestMethod.DELETE)
	@ResponseBody
	public void borrar(@PathVariable("titulo") String titulo) {
		
		System.out.println(titulo);
		
		servicio.borrarLibro(new Libro(titulo));
	}

}
