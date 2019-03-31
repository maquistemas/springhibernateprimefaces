package pe.com.maquistemas.app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.maquistemas.app.dao.MaterialProveedorDao;
import pe.com.maquistemas.app.model.MaterialProveedor;
import pe.com.maquistemas.app.service.MaterialProveedorService;

@Service
@Transactional(readOnly=false)
public class MaterialProveedorServiceImpl implements MaterialProveedorService {
	@Autowired
	MaterialProveedorDao materialProveedorDao;

	@Override
	public Serializable guardar(MaterialProveedor materialProveedor) {
		// TODO Auto-generated method stub
		return materialProveedorDao.guardar(materialProveedor);
	}

	@Override
	public MaterialProveedor buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(MaterialProveedor materialProveedor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MaterialProveedor> listar() {
		// TODO Auto-generated method stub
		return materialProveedorDao.listar();
	}

	@Override
	public boolean eliminar(MaterialProveedor materialProveedor) {
		// TODO Auto-generated method stub
		return false;
	}

}
