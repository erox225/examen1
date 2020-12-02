package controladores;

import dao.dao;
import dao.librosDaoTreeMap;
import modelos.libro;

public class configuracion {
	public static dao<libro> dao = librosDaoTreeMap.getInstancia();
}
