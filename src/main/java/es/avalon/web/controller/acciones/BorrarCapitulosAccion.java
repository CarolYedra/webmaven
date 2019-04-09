package es.avalon.web.controller.acciones;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.servicios.ServicioLibros;
import es.avalon.servicios.impl.ServicioLibrosImpl;

@Component
public class BorrarCapitulosAccion extends Accion {
	
	@Autowired
	ServicioLibros miservicio;

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ServicioLibros serv=new ServicioLibrosImpl();
		miservicio.borrarCapitulo(new Capitulo(request.getParameter("titulo")));
		
		response.sendRedirect("ServletControladorFrontal?accion=listaCapitulos&titulo="+request.getParameter("libroTitulo"));
		
	}
	
	


}
