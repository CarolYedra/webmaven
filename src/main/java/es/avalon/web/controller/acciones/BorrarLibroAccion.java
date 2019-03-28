package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;



public class BorrarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Libro milibro = new Libro(request.getParameter("titulo"));
		LibroRepositorioJPA repo =new LibroRepositorioJPA();
		repo.borrar(milibro);
		List<Libro> lista= repo.buscarTodos();
		request.setAttribute("listaLibros", lista);
		despachar(request, response, "listado.jsp");
		


	}

}
