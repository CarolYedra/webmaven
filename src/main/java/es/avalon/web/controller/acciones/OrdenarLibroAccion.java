package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;

import es.avalon.servicios.ServicioLibros;

public class OrdenarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Libro> lista = new ServicioLibros().buscarTodosOrdenadosLibro(request.getParameter("orden"));
		request.setAttribute("listaLibros", lista);
		despachar(request, response, "listado.jsp");

	}

}
