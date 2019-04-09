package es.avalon.web.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.avalon.configuracion.ConfiguracionSpring;
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
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext();
		contexto.register(ConfiguracionSpring.class);
		contexto.refresh();
			
		String tipoAccion = request.getParameter("accion");
		Accion accion = null;
		if (tipoAccion == null || tipoAccion.equals("")) {
			accion = contexto.getBean(ListaLibrosAccion.class);
		} else {
			if (tipoAccion.equals("formularioInsertar")) {
			accion = contexto.getBean(FormularioLibroInsertar.class);
			} else if (tipoAccion.equals("insertar")) {
			accion = contexto.getBean(InsertarLibroAccion.class);
			} else if (tipoAccion.equals("borrar")) {
			accion = contexto.getBean(BorrarLibroAccion.class);
			} else if (tipoAccion.equals("formularioEditar")) {
			accion = contexto.getBean(EditarLibroAccion.class);
			} else if (tipoAccion.equals("salvar")) {
			accion = contexto.getBean(SalvarLibroAccion.class);
			} else if (tipoAccion.equals("ordenar")) {
			accion = contexto.getBean(OrdenarLibroAccion.class);
			} else if (tipoAccion.equals("listaCapitulos")) {
			accion = contexto.getBean(ListaCapitulosAccion.class);
			} else if (tipoAccion.equals("formularioInsertarCapitulo")) {
			accion = contexto.getBean(FormularioCapituloInsertar.class);
			} else if (tipoAccion.equals("insertarCapitulo")){
			accion = contexto.getBean(InsertarCapitulosAccion.class);
			} else if (tipoAccion.equals("borrarCapitulo")) {
			accion = contexto.getBean(BorrarCapitulosAccion.class);
			} else if (tipoAccion.equals("listadoLibros")) {
			accion = contexto.getBean(ListaLibrosAccion.class);
			} else if (tipoAccion.equals("salvarCapitulo")) {
			accion = contexto.getBean(SalvarCapitulosAccion.class);
			} else if (tipoAccion.equals("formularioEditarCapitulo")) {
			accion = contexto.getBean(EditarCapitulosAccion.class);
			}else {
			}	
		}
		accion.ejecutar(request, response);
	}
	}

