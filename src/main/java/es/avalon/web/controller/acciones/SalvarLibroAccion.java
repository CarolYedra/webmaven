package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;
import es.avalon.servicios.impl.ServicioLibrosImpl;

@Component
public class SalvarLibroAccion extends Accion {
	
	@Autowired
	ServicioLibros miservicio;

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		Libro milibro = new Libro(request.getParameter("titulo"), request.getParameter("autor"),
				Integer.parseInt(request.getParameter("pagina")));
		
		
		miservicio.salvarLibro(milibro);
		
		List<Libro> lista = miservicio.buscarTodosLosLibros();
		request.setAttribute("listaLibros", lista);
		despachar(request, response, "listado.jsp");

}}
