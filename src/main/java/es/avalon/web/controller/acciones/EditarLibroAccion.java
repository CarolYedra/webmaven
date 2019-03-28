package es.avalon.web.controller.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;



public class EditarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Libro repo = new LibroRepositorioJPA().buscarUno(request.getParameter("titulo"));
					request.setAttribute("libro", repo);
		despachar(request, response, "formularioEditar.jsp");
		
}}
