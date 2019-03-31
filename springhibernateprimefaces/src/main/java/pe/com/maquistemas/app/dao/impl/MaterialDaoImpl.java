package pe.com.maquistemas.app.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.maquistemas.app.dao.MaterialDao;
import pe.com.maquistemas.app.model.Material;

@Repository
public class MaterialDaoImpl implements MaterialDao{
	
	List<Material> materiales;
	
	public void initMateriales() {
		materiales = new ArrayList<>();
	}
	
	@Autowired
	private SessionFactory sessionaFactory;
	
	protected Session getSession() {
		return sessionaFactory.getCurrentSession();
	}
	

	@Override
	public Serializable guardar(Material material) {
		// TODO Auto-generated method stub
		return getSession().save(material);
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
		return getSession().createQuery("SELECT e FROM Material e").getResultList();
	}

	@Override
	public boolean eliminar(Material material) {
		// TODO Auto-generated method stub
		return false;
	}

}
