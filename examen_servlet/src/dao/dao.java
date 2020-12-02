package dao;

public interface dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	void insertar(T objeto);
	void modificar(T objeto);
	void borrar(Long id);
}
