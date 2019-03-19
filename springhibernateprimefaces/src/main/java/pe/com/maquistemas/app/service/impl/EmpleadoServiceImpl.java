package pe.com.maquistemas.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.maquistemas.app.dao.EmployeeDao;
import pe.com.maquistemas.app.model.Empleado;
import pe.com.maquistemas.app.service.EmpleadoService;

/**
 * 
 * @author Ing. Ronald Angulo
 * 
 */
@Service("employeeService")
@Transactional(readOnly = false)
public class EmpleadoServiceImpl implements EmpleadoService {

	final static Logger logger = Logger.getLogger(EmpleadoServiceImpl.class);

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public boolean guardar(Empleado empleado) {

		Integer id = (Integer) employeeDao.guardar(empleado);
		logger.debug("Id del nuevo empleado: " + id);
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Empleado buscarPorId(int id) {

		logger.debug("Buscar empleado con id " + id);
		return employeeDao.buscarPorId(id);
	}

	@Override
	public boolean actualizar(Empleado empleado) {
		
		logger.debug("Actualizar empleado con id " + empleado.getId());
		return employeeDao.actualizar(empleado);
	}

	@Override
	public List<Empleado> listar() {
		
		logger.debug("Listar los empleados.");
		return employeeDao.listar();
	}

	@Override
	public boolean eliminar(Empleado empleado) {
		
		logger.debug("Eliminar empleado con id " + empleado.getId());
		return employeeDao.eliminar(empleado);
	}

}
