package es.avalon.web.controller.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;

import es.avalon.repositorios.CapitulosRepositorioJPA;




public class EditarCapitulosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		
			Capitulo repo = new CapitulosRepositorioJPA().buscarUno(request.getParameter("titulo"));
			request.setAttribute("capitulos", repo);
			despachar(request, response, "formularioEditarCapitulo.jsp");
		
			
	}

}
