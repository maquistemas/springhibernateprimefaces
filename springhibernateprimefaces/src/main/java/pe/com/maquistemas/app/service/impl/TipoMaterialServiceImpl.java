package pe.com.maquistemas.app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.maquistemas.app.dao.TipoMaterialDao;
import pe.com.maquistemas.app.model.TipoMaterial;
import pe.com.maquistemas.app.service.TipoMaterialService;

@Service
@Transactional(readOnly = false)
public class TipoMaterialServiceImpl implements TipoMaterialService{
	@Autowired
	TipoMaterialDao tipoMaterialDao;

	@Override
	public Serializable guardar(TipoMaterial tipoMaterial) {
		return tipoMaterialDao.guardar(tipoMaterial);
	}

	@Override
	public TipoMaterial buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(TipoMaterial TipoMaterial) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TipoMaterial> listar() {
		return tipoMaterialDao.listar();
	}

	@Override
	public boolean eliminar(TipoMaterial TipoMaterial) {
		// TODO Auto-generated method stub
		return false;
	}

}
