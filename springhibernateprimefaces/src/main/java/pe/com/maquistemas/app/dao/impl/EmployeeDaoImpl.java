package pe.com.maquistemas.app.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.maquistemas.app.dao.EmployeeDao;
import pe.com.maquistemas.app.model.Empleado;

/**
 * 
 * @author Ing. Ronald Angulo
 * 
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	List<Empleado> empleados; 
	@PostConstruct
    public void initEmpleadosList() {
		empleados = new ArrayList<>();
    }

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable guardar(Empleado empleado) {
		return getSession().save(empleado);
	}

	@Override
	public Empleado buscarPorId(int id) {

		Empleado empleado = null;
		try {
			// 1. Primera forma
			// empleado = getSession().get(Empleado.class, id);

			// 2. Segunda forma: HQL or JPQL
			// Query query = getSession().getNamedQuery("empleado.buscarPorId");
			// query.setParameter("pId", id);
			// empleado = (Empleado) query.getSingleResult();

			// 3. Tercera forma: SQL
			Query query = getSession().getNamedNativeQuery("empleado.nativeBuscarPorId");
			query.setParameter("pId", id);
			Object[] resultado = (Object[]) query.getSingleResult();

			empleado = new Empleado();
			empleado.setId(Integer.valueOf(String.valueOf(resultado[0])));
			empleado.setNombres(String.valueOf(resultado[1]));
			empleado.setApellidos(String.valueOf(resultado[2]));
			empleado.setCargo(String.valueOf(resultado[3]));
			empleado.setSalario(Integer.valueOf(String.valueOf(resultado[4])));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return empleado;
	}

	@Override
	public boolean actualizar(Empleado empleado) {

		try {
			getSession().update(empleado);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> listar() {

		List<Empleado> lstEmpleado;
		try {

			// 1. Primera forma
			// lstEmpleado = getSession().createQuery("SELECT e FROM Empleado
			// e").getResultList();

			// 2. Segunda forma: HQL or JPQL
			// Query query = getSession().getNamedQuery("empleado.buscarTodos");
			// lstEmpleado = (List<Empleado>) query.getResultList();

			// 3. Tercera forma: SQL
			Query query = getSession().getNamedNativeQuery("empleado.nativeBuscarTodos");
			List<Object[]> lstResultado = (List<Object[]>) query.getResultList();

			lstEmpleado = new ArrayList<>();
			for (Object[] resultado : lstResultado) {
				Empleado empleado = new Empleado();
				empleado.setId(Integer.valueOf(String.valueOf(resultado[0])));
				empleado.setNombres(String.valueOf(resultado[1]));
				empleado.setApellidos(String.valueOf(resultado[2]));
				empleado.setCargo(String.valueOf(resultado[3]));
				empleado.setSalario(Integer.valueOf(String.valueOf(resultado[4])));

				lstEmpleado.add(empleado);
			}

		} catch (Exception e) {
			lstEmpleado = new ArrayList<>();
		}
		return lstEmpleado;

	}

	@Override
	public boolean eliminar(Empleado empleado) {

		try {
			getSession().delete(empleado);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
