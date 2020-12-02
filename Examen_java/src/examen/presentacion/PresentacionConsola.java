package examen.presentacion;

import examen.accesodatos.AccesoDatosException;
import examen.accesodatos.BorrarException;
import examen.accesodatos.InsertarException;
import examen.accesodatos.LibroTreeMapDAO;
import examen.entidades.EntidadesException;
import examen.entidades.Libro;
import static bibliotecas.Consola.*;

public class PresentacionConsola {

	public static void main(String[] args) {
		try {
			int opcion;
			do {
				menu();
				opcion = pedirOpcion();
				procesarOpcion(opcion);
			} while (opcion != 0);
			cerrarConsola();
		} catch (Exception e) {
			p("\nError no esperado");
			p(e.getMessage());
			p("\n\nllame al 684-1734-80 para que arreglemos su problema\n\n"); //LLAMEN A LOS POWER RANGERS X_X

		}
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			anadir();
			break;
		case 2:
			modificar();
			break;
		case 3:
			borrar();
			break;
		case 4:
			listar();
			break;
		case 0:
			p("\nAdios :)\n");
			break;
		default:
			p("\nNo se reconoce esa opcion\n");
		}
	}

	private static void listar() {
		listado();
	}

	private static Long buscar() {
		p("\nLibros:\n");
		listar();
		Long id = pedirLong("¿Que id buscas?");

		Libro libro = LibroTreeMapDAO.obtenerPorId(id);
		
		if(libro != null) {
			return id;
		} else {
			p("\nEl id introducido no coincide con ningun registro. Intente nuevamente\n");
			return null;
		}
	}

	private static void anadir() {
		Libro libro = pedirDatosLibro(LibroTreeMapDAO.ObtenerUltimoId());
		try {
			if(libro != null)
			{
				LibroTreeMapDAO.insertar(libro);
				p("\nLibro guardado con éxito\n");
			}
			else {
				p("\nOperacion Cancelada\n");
			}
		} catch (InsertarException e) {
			p(e.getMessage());
			p(LibroTreeMapDAO.obtenerPorId(libro.getId()));
		}
	}

	private static void modificar() {
		Long id=null;
		do {
			id = buscar();
		}while(id==null);
		try {
			Libro libro = pedirDatosLibro(id);
			if(libro != null)
			{
				LibroTreeMapDAO.modificar(libro);
				p("\nLibro Modificado con éxito\n");
			}
			else {
				p("\nOperacion Cancelada\n");
			}
		} catch (AccesoDatosException e) {
			p(e.getMessage());
		}
	}
	
	private static Libro pedirDatosLibro(Long id) {
		Libro libro = new Libro(id);
		do {
			try {
				libro.setTitulo(pedirTexto("Nombre"));
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (libro.getTitulo() == null);
		
		do {
			try {
				libro.setIsbn(pedirLong("ISBN"));
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (libro.getIsbn() == null);
		
		do {
			try {
				libro.setN_paginas(pedirInteger("Número de páginas"));
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (libro.getN_paginas() == null);
		
		do {
			try {
				Integer aux = pedirInteger("\nSelecciona el formato:\n1 para digital\n2 para papel:\n");
				if(aux == 1 || aux == 2)
				{
					if(aux == 1)
					{
						libro.setFormato(true);
					}
					else {
						libro.setFormato(false);
					}
				}
				else {
					p("\nDebes ingresar un 1 o un 2\n");
				}
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (libro.isFormato() == null);
		
		Integer aux2 = null;
		do {
			try {
				aux2 = pedirInteger("\n\n¿Deseas guardar este libro?\n"+libro.toString()+"\n\nSelecciona 1 para confirmar \nSelecciona 2 para rechazar");
					if(aux2 == 2)
					{
						libro = null;
					}
					else if(aux2 != 1){
						aux2 = null;
					}
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (aux2 == null);
		
		
		return libro;
	}

	private static void borrar() {
		Long id=null;
		do {
			id = buscar();
		}while(id==null);
		try {
			LibroTreeMapDAO.borrar(id);
		} catch (BorrarException e) {
			p(e.getMessage());
		}
	}

	private static int pedirOpcion() {
		return pedirInteger("¿Que opcion quieres?");
	}

	private static void menu() {
		p("Menú:");
		p("1. Añadir");
		p("2. Modificar");
		p("3. Borrar");
		p("4. Listar todos los Libros");
		
		p();
		p("0. Salir");
	}

	private static void listado() {
		p("-------");
		for (Libro libro : LibroTreeMapDAO.obtenerTodos()) {
			p(libro.toString());
		}
		p("-------");
	}


}
