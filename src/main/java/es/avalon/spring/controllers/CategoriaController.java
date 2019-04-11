package es.avalon.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Categoria;
import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/libros")
public class CategoriaController {
	
	
		
		@Autowired
		ServicioLibros miservicio;
		
		@RequestMapping("/listaCategoria")
		
		public String listar(Model modelo) {
			modelo.addAttribute("listaCategoria",miservicio.buscarTodosCategoria());
			return "libros/listaCategoria";
		}
		
	
		
	}
