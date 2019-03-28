package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;

import es.avalon.servicios.ServicioLibros;



public class BorrarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Libro milibro = new Libro(request.getParameter("titulo"));
		ServicioLibros serv=new ServicioLibros();
		serv.borrarLibro(milibro);
		List<Libro> lista= serv.buscarTodosLosLibros();
		request.setAttribute("listaLibros", lista);
		despachar(request, response, "listado.jsp");
		


	}

}
