/**
 * 
 */
package meta.library.model.dao.impl;

import java.util.List;

import meta.library.model.bean.Book;
import meta.library.model.bean.User;
import meta.library.model.dao.BookDao;

/**
 * @author Biao Zhang
 *
 */
public class BookDaoImpl extends GenericDaoImpl<Book, Integer>	implements BookDao {

	@Override
	public Book getByTitle(String title) {
		List<Book> books = this.getHibernateTemplate().find("from Book where title=?", title);
		Book book;
		if (books == null || books.isEmpty()) {
			book = null;
		} else {
			book = books.get(0);
		}
		return book;
	}
	
}
