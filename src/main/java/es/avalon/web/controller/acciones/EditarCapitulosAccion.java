package es.avalon.web.controller.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.servicios.ServicioLibros;



@Component
public class EditarCapitulosAccion extends Accion {
	
	@Autowired
	ServicioLibros miservicio;

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Capitulo repo = miservicio.buscarUnoCapitulo(request.getParameter("titulo"));
		request.setAttribute("capitulo", repo);
		despachar(request, response, "formularioEditarCapitulo.jsp");


	}

}
