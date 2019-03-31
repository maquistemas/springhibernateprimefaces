package pe.com.maquistemas.app.dao;

import java.io.Serializable;
import java.util.List;

import pe.com.maquistemas.app.model.MaterialProveedor;

public interface MaterialProveedorDao {
	public Serializable guardar(MaterialProveedor materialProveedor);

	public MaterialProveedor buscarPorId(int id);

	public boolean actualizar(MaterialProveedor materialProveedor);

	public List<MaterialProveedor> listar();

	public boolean eliminar(MaterialProveedor materialProveedor);

}
