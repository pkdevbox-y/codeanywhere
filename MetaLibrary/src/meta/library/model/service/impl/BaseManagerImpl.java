package meta.library.model.service.impl;

import java.util.List;

import meta.library.model.dao.GenericDao;
import meta.library.model.service.BaseManager;

public class BaseManagerImpl<Dao extends GenericDao, T> implements BaseManager<Dao, T> {
	
	protected Dao dao;

	public void setDao(Dao dao) {
		this.dao = dao;

	}
	
	public List<T> findAll(){
		return dao.findAll();
	}
	
	public T findById(Integer id){
		return (T) dao.findById(id);
	}
	
	public void save(T t){
		dao.save(t);
	}
	
	public void delete(T t){
		dao.delete(t);
	}

}
