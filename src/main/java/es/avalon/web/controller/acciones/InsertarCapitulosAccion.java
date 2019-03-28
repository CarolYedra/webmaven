package es.avalon.web.controller.acciones;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.CapitulosRepositorioJPA;
import es.avalon.repositorios.LibroRepositorioJPA;

public class InsertarCapitulosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibroRepositorioJPA repolibro = new LibroRepositorioJPA();
		CapitulosRepositorioJPA repocap= new CapitulosRepositorioJPA();
		
		Libro libro=repolibro.buscarUno(request.getParameter("libroTitulo"));
		Capitulo c = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")), libro);
		c.setLibro(libro);
		
		repocap.insertar(c);
		
//		request.setAttribute("listaCapitulos", repocap.buscarTodosParaUnLibro(libro));
//		despachar(request, response, "listadoCapitulos.jsp");
		
		response.sendRedirect("ServletControladorFrontal?accion=listaCapitulos&titulo="+request.getParameter("libroTitulo"));
		
		
		
		

	}

}
