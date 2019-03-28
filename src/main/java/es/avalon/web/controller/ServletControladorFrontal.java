package es.avalon.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.avalon.web.controller.acciones.Accion;
import es.avalon.web.controller.acciones.BorrarCapitulosAccion;
import es.avalon.web.controller.acciones.BorrarLibroAccion;
import es.avalon.web.controller.acciones.EditarCapitulosAccion;
import es.avalon.web.controller.acciones.EditarLibroAccion;
import es.avalon.web.controller.acciones.FormularioCapituloInsertar;
import es.avalon.web.controller.acciones.FormularioLibroInsertar;
import es.avalon.web.controller.acciones.InsertarCapitulosAccion;
import es.avalon.web.controller.acciones.InsertarLibroAccion;
import es.avalon.web.controller.acciones.ListaCapitulosAccion;
import es.avalon.web.controller.acciones.ListaLibrosAccion;
import es.avalon.web.controller.acciones.OrdenarLibroAccion;
import es.avalon.web.controller.acciones.SalvarCapitulosAccion;
import es.avalon.web.controller.acciones.SalvarLibroAccion;

public class ServletControladorFrontal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipoAccion = request.getParameter("accion");
		Accion accion = null;
		if (tipoAccion == null || tipoAccion.equals("")) {
			accion = new ListaLibrosAccion();
		} else {
			if (tipoAccion.equals("formularioInsertar")) {
				accion = new FormularioLibroInsertar();
			} else if (tipoAccion.equals("insertar")) {
				accion = new InsertarLibroAccion();
			} else if (tipoAccion.equals("borrar")) {
				accion = new BorrarLibroAccion();
			} else if (tipoAccion.equals("formularioEditar")) {
				accion = new EditarLibroAccion();
			} else if (tipoAccion.equals("salvar")) {
				accion = new SalvarLibroAccion();
			} else if (tipoAccion.equals("ordenar")) {
				accion = new OrdenarLibroAccion();
			} else if (tipoAccion.equals("listaCapitulos")) {
				accion = new ListaCapitulosAccion();
			} else if (tipoAccion.equals("formularioInsertarCapitulo")) {
				accion = new FormularioCapituloInsertar();
			} else if (tipoAccion.equals("insertarCapitulo")){
				accion = new InsertarCapitulosAccion();
			} else if (tipoAccion.equals("borrarCapitulo")) {
				accion = new BorrarCapitulosAccion();
			} else if (tipoAccion.equals("listadoLibros")) {
				accion = new ListaLibrosAccion();
				
			} else if (tipoAccion.equals("salvarCapitulo")) {
				accion = new SalvarCapitulosAccion();
			} else if (tipoAccion.equals("formularioEditarCapitulo")) {
				accion = new EditarCapitulosAccion();
			}else {
				
			}
		
		}
		accion.ejecutar(request, response);
	}
	}

