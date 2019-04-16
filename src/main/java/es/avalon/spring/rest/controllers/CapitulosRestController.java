package es.avalon.spring.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/webapi/capitulos")
public class CapitulosRestController {
	
		
		@Autowired
		ServicioLibros servicio;
		@RequestMapping
		@ResponseBody
		public Iterable <Capitulo> buscarTodos(){
			
			return servicio.buscarTodosCapitulo();
			
		}

}
