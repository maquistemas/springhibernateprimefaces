package pe.com.maquistemas.app.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.maquistemas.app.dao.TipoMaterialDao;
import pe.com.maquistemas.app.model.TipoMaterial;

@Repository("TipoMaterialDao")
public class TipoMaterialDaoImpl implements TipoMaterialDao{
	
	List<TipoMaterial> tipoMaterialList;
	@PostConstruct
	public void initTipoMaterialList() {
		tipoMaterialList = new ArrayList<>();
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable guardar(TipoMaterial tipoMaterial) {
		// TODO Auto-generated method stub
		return getSession().save(tipoMaterial);
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
		return getSession().createQuery("SELECT e FROM TipoMaterial e").getResultList();
	}

	@Override
	public boolean eliminar(TipoMaterial TipoMaterial) {
		// TODO Auto-generated method stub
		return false;
	}

}
