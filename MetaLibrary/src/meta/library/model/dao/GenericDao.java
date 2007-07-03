/**
 * 
 */
package meta.library.model.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Biao Zhang
 *
 */
public interface GenericDao<T, ID extends Serializable> {
	
	/*
	 * Return the entity by its ID
	 * @param the id
	 * @return the entity
	 */
    T findById(ID id);
    
    /*
     * Return the entity by its ID and the model locked or unlocked
     * @param the id and the model
     * @return the entity
     */
    T findById(ID id, boolean lock);

    /*
     * List of the member of the type T
     * @return List<T> List contain the entities
     */
    List<T> findAll();

    /*
     * Make the entity persistent
     * @param the entity that want to be persistent
     * @return the entity, null if fail
     */
    void save(T entity);

    /*
     * Make the entity Transient
     * @param the entity that want to be transient
     */
    void delete(T entity);
}
