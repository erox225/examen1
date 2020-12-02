package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.producto;
/**
 * Servlet implementation class registrarProducto
 */
@WebServlet("/admin/registrar_producto")
public class registrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/admin/registrar.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre_producto");
		String tipo = request.getParameter("tipo_producto");
		String descripcion = request.getParameter("descripcion_producto");
		String cantidad = request.getParameter("cantidad_producto");
		String precio = request.getParameter("precio_producto");
		String oferta = request.getParameter("oferta_producto");
	
		producto Producto= new producto(nombre,tipo,descripcion," ",cantidad,precio,oferta);
		if(Producto.isCorrecto())
		{
			System.out.println(Producto.toString());
			System.out.println("entro en bien");
			configuracion.dao.insertar(Producto);
			response.sendRedirect(request.getContextPath() + "/inicio");
		}
		else {
			request.setAttribute("producto", Producto);
			System.out.println("entro en mal");
			System.out.println(Producto.toString());
			request.getRequestDispatcher("/WEB-INF/vistas/admin/registrar.jsp").forward(request, response);
		}
	}

}
