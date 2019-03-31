package pe.com.maquistemas.app.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.maquistemas.app.dao.ProveedorDao;
import pe.com.maquistemas.app.model.Proveedor;

@Repository
public class ProveedorDaoImpl implements ProveedorDao{
	
	private List<Proveedor> proveedores;
	public void initProveedores() {
		proveedores = new ArrayList<>();
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@Override
	public Serializable guardar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return getSession().save(proveedor);
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
		return getSession().createQuery("SELECT e FROM Proveedor e").getResultList();
	}

	@Override
	public boolean eliminar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return false;
	}

}
