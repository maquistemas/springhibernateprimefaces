package pe.com.maquistemas.app.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

import pe.com.maquistemas.app.model.Material;

@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T> implements GenericDao<T>{
	
	private List<T> listaT;
	public void initListaT() {
		listaT = new ArrayList<>();
	}
	@Autowired
	private SessionFactory sessionFactory;
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private final Class<T> entityClass;

	public GenericDaoImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	

	@Override
	public T findById(final Serializable id) {
		return (T) getSession().get(this.entityClass, id);
	}

	@Override
	public Serializable save(T entity) {
		return getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void deleteAll() {
		List<T> entities = findAll();
		for (T entity : entities) {
			getSession().delete(entity);
		}
	}

	@Override
	public List<T> findAll() {
		return getSession().createCriteria(this.entityClass).list();
	}

	

	@Override
	public void clear() {
		getSession().clear();

	}

	@Override
	public void flush() {
		getSession().flush();

	}
	
	

}
