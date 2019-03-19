package pe.com.maquistemas.app.dao;

import java.io.Serializable;
import java.util.List;

import pe.com.maquistemas.app.model.Empleado;

public interface EmployeeDao {

	public Serializable guardar(Empleado empleado);

	public Empleado buscarPorId(int id);

	public boolean actualizar(Empleado empleado);

	public List<Empleado> listar();

	public boolean eliminar(Empleado empleado);

}
