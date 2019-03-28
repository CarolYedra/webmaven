package es.avalon.web.controller.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;


import es.avalon.servicios.ServicioLibros;




public class EditarCapitulosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Capitulo repo = new ServicioLibros().buscarUnoCapitulo(request.getParameter("titulo"));
		request.setAttribute("capitulo", repo);
		despachar(request, response, "formularioEditarCapitulo.jsp");


	}

}
