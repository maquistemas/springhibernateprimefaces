package pe.com.maquistemas.app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.maquistemas.app.dao.ProveedorDao;
import pe.com.maquistemas.app.model.Proveedor;
import pe.com.maquistemas.app.service.ProveedorService;

@Service
@Transactional(readOnly = false)
public class ProveedorServiceImpl  implements ProveedorService{
	
	@Autowired
	ProveedorDao proveedorDao;
	

	@Override
	public Serializable guardar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorDao.guardar(proveedor);
	}

	@Override
	public Proveedor buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Proveedor> listar() {
		// TODO Auto-generated method stub
		return proveedorDao.listar();
	}

	@Override
	public boolean eliminar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return false;
	}

}
