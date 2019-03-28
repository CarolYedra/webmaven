package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.repositorios.CapitulosRepositorioJPA;



public class SalvarCapitulosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		Capitulo c = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("pagina")));
		
		CapitulosRepositorioJPA repository= new CapitulosRepositorioJPA();
		repository.salvar(c);
		
		List<Capitulo> lista = repository.buscarTodos();
		request.setAttribute("listaCapitulos", lista);
		despachar(request, response, "listadoCapitulos.jsp");
		
	}

}
