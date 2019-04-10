package es.avalon.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/libros")
public class CapituloController {

	
	@Autowired
	ServicioLibros miservicio;

	@RequestMapping("/listaCapitulos")

	public String listar(Model modelo, String titulo) {
		modelo.addAttribute("listaCapitulos", miservicio.buscarTodosParaUnLibroCapitulo(new Libro(titulo)));
		return "libros/listaCapitulos";
	}

//	@RequestMapping("/formularioInsertarCapitulo")
//
//	public String formularioInsertarCapitulo() {
//		return "libros/formularioInsertarCapitulo";
//	}
//
//	@RequestMapping("/insertarCapitulo")
//
//	public String insertarCapitulo(@ModelAttribute Capitulo capitulo,Model modelo,  String Libro_Titulo) {
//		
//		capitulo.setLibro(miservicio.buscarUnoLibro(Libro_Titulo));
//		miservicio.insertarCapitulo(capitulo);
//		modelo.addAttribute("listaCapitulos",miservicio.buscarTodosParaUnLibroCapitulo(new Libro(Libro_Titulo))); 
//		return "libros/listaCapitulos"; 
//	}
	
	  @RequestMapping("/borrarCapitulo")
	  
	  public String borrarCapitulo(@ModelAttribute Capitulo capitulo, Model modelo,String Libro_Titulo){ 
		  miservicio.borrarCapitulo(capitulo);
		  modelo.addAttribute("listaCapitulos",miservicio.buscarTodosParaUnLibroCapitulo(new Libro(Libro_Titulo)));
		  return "libros/listaCapitulos"; 
	  }
	  
//	  @RequestMapping("/formularioEditar")
//	  
//	  public String formularioEditar( String titulo, Model modelo) {
//	  modelo.addAttribute("libro",miservicio.buscarUnoLibro(titulo)); return
//	  "libros/formularioEditar"; }
//	  
//	  @RequestMapping("/salvarlibro")
//	  
//	  public String salvarLibro(@ModelAttribute Libro libro, Model modelo) {
//	  miservicio.salvarLibro(libro);
//	  modelo.addAttribute("listaLibros",miservicio.buscarTodosLosLibros()); return
//	  "libros/lista"; }
	 
}
