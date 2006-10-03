/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import meta.codeanywhere.dao.GenericDAO;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

/**
 * @author Biao Zhang
 * @date 2006-6-27
 *
 */
public abstract class GenericDAOImpl<T, ID extends Serializable, DAO extends GenericDAO<T, ID>> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	private Session session;
	
	public GenericDAOImpl() {
		persistentClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	protected DAO setSession(Session s) {
		session = s;
		return (DAO)this;
	}
	
	protected Session getSession() {
		if (session == null) {
			throw new IllegalStateException("Session has not been initialized");
		}
		return session;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> getByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return (List<T>)crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		T entity;
		entity = (T)getSession().get(getPersistentClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public T getById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T)getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
		}
		else {
			entity = (T)getSession().get(getPersistentClass(), id);
		}
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see ias.model.dao.GenericDAO#findAll()
	 */
	public List<T> getAll() {
		return this.getByCriteria();
	}

	/* (non-Javadoc)
	 * @see ias.model.dao.GenericDAO#makePersistent(java.lang.Object)
	 */
	public T makePersistent(T entity) {
		Transaction tx = getSession().beginTransaction();
		this.getSession().saveOrUpdate(entity);
		tx.commit();
		return entity;
	}

	/* (non-Javadoc)
	 * @see ias.model.dao.GenericDAO#makeTransient(java.lang.Object)
	 */
	public void makeTransient(T entity) {
		Transaction tx = this.getSession().beginTransaction();
		this.getSession().delete(entity);
		tx.commit();

	}

}
