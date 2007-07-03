package meta.library.model.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import meta.library.model.dao.GenericDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class GenericDaoImpl<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDao<T, ID> {
	
	private Class<T> persistentClass;
	
	public GenericDaoImpl(){
		this.persistentClass = (Class<T>)((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0];
	}
	
	public Class<T> getPersistentClass(){
		return persistentClass;
	}

	@Override
	public T findById(ID id) {
		Object entity = this.getHibernateTemplate().get(getPersistentClass(), id);

        return (T) entity;
	}

	@Override
	public T findById(ID id, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().loadAll(this.getPersistentClass());
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	
	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}
}