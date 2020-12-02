package examen.accesodatos;

import java.util.TreeMap;

import examen.entidades.Libro;

public class LibroTreeMapDAO {
	private static TreeMap<Long, Libro> Libros = new TreeMap<>();
	
	static {
		//Libros de prueba
		Libros.put(1L, new Libro(1L, "Peter pan", 1234567891L,1,true));
		Libros.put(2L, new Libro(2L, "Narnia", 1234567892L,20,false));
	}
	
	public static Iterable<Libro> obtenerTodos() {
		return Libros.values();
	}
	
	public static Libro obtenerPorId(Long id) {
		return Libros.get(id);
	}
	
	public static void insertar(Libro Libro) {
		if(Libros.containsKey(Libro.getId())) {
			throw new InsertarException("Ese id ya esta en uso");
		}
		
		Libros.put(Libro.getId(), Libro);
	}
	
	public static void modificar(Libro Libro) {
		if(!Libros.containsKey(Libro.getId())) {
			throw new ModificarException("No existe ese id");
		}
		
		Libros.put(Libro.getId(), Libro);
	}
	
	public static void borrar(Long id) {
		if(!Libros.containsKey(id)) {
			throw new BorrarException("No existe ese id");
		}
		
		Libros.remove(id);
	}
	
	public static Long ObtenerUltimoId()
	{
		 
		if(Libros.size()>0)
		{
			Libro libro = Libros.lastEntry().getValue();
			if(libro==null)
			{
				return 1L;
			}else {
				return libro.getId()+1;
			}
		}
		else {
			return 1L;
		}
	
	}
}
