package pe.com.maquistemas.app.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.maquistemas.app.dao.MaterialProveedorDao;
import pe.com.maquistemas.app.model.MaterialProveedor;

@Repository
public class MaterialProveedorDaoImpl implements MaterialProveedorDao{
	
	private List<MaterialProveedor> materialProveedores;
	public void initMaterialProveedores() {
		materialProveedores = new ArrayList<>();
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable guardar(MaterialProveedor materialProveedor) {
		// TODO Auto-generated method stub
		return getSession().save(materialProveedor);
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
		return getSession().createQuery("SELECT e FROM MaterialProveedor e").getResultList();
	}

	@Override
	public boolean eliminar(MaterialProveedor materialProveedor) {
		// TODO Auto-generated method stub
		return false;
	}

}
