package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;


@Component
public class ListaCapitulosAccion extends Accion {
	
	@Autowired
	ServicioLibros miservicio;

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Iterable<Capitulo> lista = miservicio.buscarTodosParaUnLibroCapitulo(new Libro(request.getParameter("titulo")));
		request.setAttribute("listaCapitulos", lista);
		despachar(request, response, "listadoCapitulos.jsp");

	}

}
