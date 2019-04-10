package es.avalon.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	public String formularioInsertar() {
		return "libros/formularioInsertar";
	}
	@RequestMapping("/insertar")
	
	public String insertar(@ModelAttribute Libro libro, Model modelo) {
		miservicio.insertarLibro(libro);
		modelo.addAttribute("listaLibros",miservicio.buscarTodosLosLibros());
		return "libros/lista";
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
	
}
