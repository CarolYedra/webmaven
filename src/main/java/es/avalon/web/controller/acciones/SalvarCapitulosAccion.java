package es.avalon.web.controller.acciones;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

import es.avalon.servicios.ServicioLibros;



public class SalvarCapitulosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServicioLibros serv=new ServicioLibros();
		//System.out.println(request.getParameter("titulo") + request.getParameter("libroTitulo") + request.getParameter("paginas"));
		Libro libro=serv.buscarUnoLibro(request.getParameter("libroTitulo"));
		
		Capitulo c = new Capitulo(request.getParameter("tituloOriginal"), Integer.parseInt(request.getParameter("paginas")), libro);
		
		
		serv.salvarCapitulo(c);
		
		response.sendRedirect("ServletControladorFrontal?accion=listaCapitulos&titulo="+request.getParameter("libroTitulo"));
		
	}

}
