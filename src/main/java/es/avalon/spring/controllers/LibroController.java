package es.avalon.spring.controllers;

import javax.persistence.Column;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;


@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	ServicioLibros miservicio;
	
	@RequestMapping("/lista")
	
	public String listar(Model modelo) {
		modelo.addAttribute("listaLibros",miservicio.buscarTodosLosLibros());
		return "libros/lista";
	}
	@RequestMapping("/formularioInsertar")
	
	public String formularioInsertar( Model modelo) {
		
		modelo.addAttribute("libro", new Libro());
		return "libros/formularioInsertar";
	}
	@RequestMapping(value="/insertar", method=RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute Libro libro, BindingResult resultado, Model modelo) {
		if(resultado.hasErrors()) {
			return "libros/formularioInsertar";
		}else {
			miservicio.insertarLibro(libro);
			modelo.addAttribute("listaLibros", miservicio.buscarTodosLosLibros());
			return "libros/lista";
		}
	
	}
	@RequestMapping("/borrar")
	
	public String borrar(@ModelAttribute Libro libro, Model modelo) {
		miservicio.borrarLibro(libro);
		modelo.addAttribute("listaLibros",miservicio.buscarTodosLosLibros());
		return "libros/lista";
	}
	@RequestMapping("/formularioEditar")
	
	public String formularioEditar( String titulo, Model modelo) {
		modelo.addAttribute("libro",miservicio.buscarUnoLibro(titulo));
		return "libros/formularioEditar";
	}
	@RequestMapping("/salvarlibro")
	
	public String salvarLibro(@ModelAttribute Libro libro, Model modelo) {
		miservicio.salvarLibro(libro);
		modelo.addAttribute("listaLibros",miservicio.buscarTodosLosLibros());
		return "libros/lista";
	}
	@RequestMapping("/ordenarPorTitulo")
	public String ordenarPorTitulo( Model modelo) {
		
		modelo.addAttribute("listaLibros",miservicio.buscarLibrosOrdenadorPorTituloAsc());
		return "libros/lista";
	}
	@RequestMapping("/ordenarPorAutor")
	public String ordenarPorAutor(  Model modelo) {
		modelo.addAttribute("listaLibros",miservicio.buscarLibrosOrdenadorPorAutorAsc());
		return "libros/lista";
	}
	
	
	
}
