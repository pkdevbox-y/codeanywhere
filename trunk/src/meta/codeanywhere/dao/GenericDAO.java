/**
 * 
 */
package meta.codeanywhere.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Biao Zhang
 * @date 2006-6-27
 * This is the generic DAO of all DAO
 */
public interface GenericDAO<T, ID extends Serializable> {
	
	/*
	 * Return the entity by its ID
	 * @param the id
	 * @return the entity
	 */
    T getById(ID id);
    
    /*
     * Return the entity by its ID and the model locked or unlocked
     * @param the id and the model
     * @return the entity
     */
    T getById(ID id, boolean lock);

    /*
     * List of the member of the type T
     * @return List<T> List contain the entities
     */
    List<T> getAll();

    /*
     * Make the entity persistent
     * @param the entity that want to be persistent
     * @return the entity, null if fail
     */
    T makePersistent(T entity);

    /*
     * Make the entity Transient
     * @param the entity that want to be transient
     */
    void makeTransient(T entity);
}
