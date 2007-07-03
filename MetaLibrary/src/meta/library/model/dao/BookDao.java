/**
 * 
 */
package meta.library.model.dao;

import meta.library.model.bean.Book;

/**
 * @author Biao Zhang
 *
 */
public interface BookDao extends GenericDao<Book, Integer> {
	public Book getByTitle(String title);
}
