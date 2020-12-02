package controladores;
import dao.dao;
import modelos.producto;
import dao.productosDaoTreeMap;

public class configuracion {
	public static dao<producto> dao = productosDaoTreeMap.getInstancia();
}
