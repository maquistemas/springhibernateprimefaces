package pe.com.maquistemas.app.dao;

import java.io.Serializable;
import java.util.List;

import pe.com.maquistemas.app.model.Proveedor;

public interface ProveedorDao {
	public Serializable guardar(Proveedor proveedor);

	public Proveedor buscarPorId(int id);

	public boolean actualizar(Proveedor proveedor);

	public List<Proveedor> listar();

	public boolean eliminar(Proveedor proveedor);

}
