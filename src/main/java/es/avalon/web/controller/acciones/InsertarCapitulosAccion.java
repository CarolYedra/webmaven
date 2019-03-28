package es.avalon.web.controller.acciones;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

import es.avalon.servicios.ServicioLibros;

public class InsertarCapitulosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServicioLibros serv=new ServicioLibros();
		
		Libro libro=serv.buscarUnoLibro(request.getParameter("libroTitulo"));
		Capitulo c = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")), libro);
		c.setLibro(libro);
		
		serv.insertarCapitulo(c);
		
//		request.setAttribute("listaCapitulos", repocap.buscarTodosParaUnLibro(libro));
//		despachar(request, response, "listadoCapitulos.jsp");
		
		response.sendRedirect("ServletControladorFrontal?accion=listaCapitulos&titulo="+request.getParameter("libroTitulo"));
		
		
		
		

	}

}
