package dao;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;



import modelos.producto;

public class productosDaoTreeMap implements dao<producto>{
	//INICIO SINGLETON
	private productosDaoTreeMap() {
		productos.put(1L, new producto("Toddy", "Lácteos", "bebida chocolateada","img1",1,4.5,2.5,1L));
		productos.put(2L,  new producto("cerelac", "cereales", "bebida de trigo","img2",1,4.5,2.5,1L));
	}
	
	private static productosDaoTreeMap instancia = new productosDaoTreeMap();
	
	public static productosDaoTreeMap getInstancia() {
		return instancia;
	}
	//FIN SINGLETON
	
	private TreeMap<Long, producto> productos = new TreeMap<>();
	
	@Override
	public Iterable<producto> obtenerTodos() {
//		tree_map.subMap(15, 30))));
		return productos.values();
	}
	

	
	public  SortedMap<Long, producto> productos(int filas) {
		long inicio = filas * 5; 
		long fin = filas *10;
		return productos.subMap(inicio, fin);
	}

	@Override
	public producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public void insertar(producto producto) {
		Long id = productos.lastKey() + 1;
		producto.setId(id);
		productos.put(producto.getId(), producto);
	}

	@Override
	public void modificar(producto producto) {
		if(!productos.containsKey(producto.getId())) {
			throw new AccesoDatosException("No existe ese id");
		}
		productos.put(producto.getId(), producto);
	}
	
	@Override
	public void borrar(Long id) {
		if(!productos.containsKey(id)) {
			throw new AccesoDatosException("No existe ese id");
		}
		productos.remove(id);
	}
}
