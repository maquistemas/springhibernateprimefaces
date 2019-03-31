package pe.com.maquistemas.app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.maquistemas.app.dao.MaterialDao;
import pe.com.maquistemas.app.model.Material;
import pe.com.maquistemas.app.service.MaterialService;

@Service
@Transactional(readOnly = false)
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired
	MaterialDao materialDao;

	@Override
	public Serializable guardar(Material material) {
		// TODO Auto-generated method stub
		return materialDao.guardar(material);
	}

	@Override
	public Material buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Material material) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Material> listar() {
		// TODO Auto-generated method stub
		return materialDao.listar();
	}

	@Override
	public boolean eliminar(Material material) {
		// TODO Auto-generated method stub
		return false;
	}

}
