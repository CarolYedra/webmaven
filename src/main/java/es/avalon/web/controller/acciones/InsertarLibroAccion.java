package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;

import es.avalon.servicios.ServicioLibros;



public class InsertarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		Libro libro = new Libro(request.getParameter("titulo"), request.getParameter("autor"),
				Integer.parseInt(request.getParameter("pagina")));
		
		ServicioLibros serv=new ServicioLibros();
		serv.insertarLibro(libro);
		List<Libro> lista = serv.buscarTodosLosLibros();
		request.setAttribute("listaLibros", lista);
		despachar(request, response, "listado.jsp");

	}

}
