/**
 * 
 */
package meta.library.model.dao;

import java.util.List;

import meta.library.model.bean.Book;

/**
 * @author Biao Zhang
 *
 */
public interface BookDao extends GenericDao<Book, Integer> {
	public Book getByTitle(String title);	
	public List<Book> getByAuthor(String author);	
	public List<Book> getByPress(String press);
	
	public List<Book> searchByTitle(String title);
	public List<Book> searchByAuthor(String author);	
	public List<Book> searchByPress(String press);
}
