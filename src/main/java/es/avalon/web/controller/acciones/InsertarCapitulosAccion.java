package es.avalon.web.controller.acciones;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;
import es.avalon.servicios.impl.ServicioLibrosImpl;

@Component
public class InsertarCapitulosAccion extends Accion {
	
	@Autowired
	ServicioLibros miservicio;

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ServicioLibros serv=new ServicioLibrosImpl();
		
		Libro libro=miservicio.buscarUnoLibro(request.getParameter("libroTitulo"));
		Capitulo c = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")), libro);
		c.setLibro(libro);
		
		miservicio.insertarCapitulo(c);
		

		
		response.sendRedirect("ServletControladorFrontal?accion=listaCapitulos&titulo="+request.getParameter("libroTitulo"));
		
		
		
		

	}

}
