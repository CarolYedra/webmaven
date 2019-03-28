package es.avalon.web.controller.acciones;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;

import es.avalon.repositorios.CapitulosRepositorioJPA;


public class BorrarCapitulosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CapitulosRepositorioJPA repo= new CapitulosRepositorioJPA();
		repo.borrar(new Capitulo(request.getParameter("titulo")));
		
		response.sendRedirect("ServletControladorFrontal?accion=listaCapitulos&titulo="+request.getParameter("libroTitulo"));
		
	}
	
	


}
