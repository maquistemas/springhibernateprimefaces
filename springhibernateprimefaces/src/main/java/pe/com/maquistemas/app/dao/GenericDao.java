package pe.com.maquistemas.app.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {
	
	Serializable save(T entity);
	public void saveOrUpdate(T entity);
	void delete( T entity );
	void deleteAll();
	List<T> findAll();
	T findById( Serializable id  );
	void clear();
	void flush();

}
