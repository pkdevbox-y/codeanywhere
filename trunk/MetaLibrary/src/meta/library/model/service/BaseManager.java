package meta.library.model.service;

import java.util.List;

import meta.library.model.dao.GenericDao;

/**
 * @author Biao Zhang
 *
 */
public interface BaseManager<Dao extends GenericDao, T> {
	public void setDao(Dao dao);
	public T findById(Integer id);
	public List<T> findAll();
	public void save(T t);
	public void delete(T t);
}
