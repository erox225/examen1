package dao;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import modelos.libro;


public class librosDaoTreeMap implements dao<libro>{
	//INICIO SINGLETON
	private librosDaoTreeMap() {
	}
	
	private static librosDaoTreeMap instancia = new librosDaoTreeMap();
	
	public static librosDaoTreeMap getInstancia() {
		return instancia;
	}
	//FIN SINGLETON
	
	private TreeMap<Long, libro> libros = new TreeMap<>();
	
	@Override
	public Iterable<libro> obtenerTodos() {
		return libros.values();
	}
	
	@Override
	public libro obtenerPorId(Long id) {
		return libros.get(id);
	}

	@Override
	public void insertar(libro libro) {
		Long id;
		if(libros.isEmpty())
		{
			id=1L;
		}
		else {
			id = libros.lastKey() + 1;
		}
		libro.setId(id);
		libros.put(libro.getId(), libro);
	}

	@Override
	public void modificar(libro libro) {
		if(!libros.containsKey(libro.getId())) {
			throw new AccesoDatosException("No existe ese id");
		}
		libros.put(libro.getId(), libro);
	}
	
	@Override
	public void borrar(Long id) {
		if(!libros.containsKey(id)) {
			throw new AccesoDatosException("No existe ese id");
		}
		libros.remove(id);
	}
}
