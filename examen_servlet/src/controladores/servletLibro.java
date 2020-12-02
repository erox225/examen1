package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.libro;

/**
 * Servlet implementation class servletLibro
 */
@WebServlet("/servletLibro")
public class servletLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("libros", configuracion.dao.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/lista_productos.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Parámetros
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");	
		//Parámetros
		
		libro libro= new libro(nombre,precio,descuento);
		if(libro.isCorrecto())
		{
			configuracion.dao.insertar(libro);
			response.sendRedirect(request.getContextPath() + "/servletLibro");
		}
		else {
			request.setAttribute("libro_error", libro);
			doGet(request, response);
		}
	}

}
