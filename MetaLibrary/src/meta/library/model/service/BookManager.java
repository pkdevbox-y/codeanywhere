/**
 * 
 */
package meta.library.model.service;

import java.io.InputStream;

import meta.library.model.bean.Book;
import meta.library.model.dao.BookDao;

/**
 * @author Biao Zhang
 *
 */
public interface BookManager extends BaseManager<BookDao, Book> {
	public Book getByTitle(String title);
	
	public Book addBook(String title, String author, String isbn, String catalog, String description);
	
	public Book addBook(String title, String author, String isbn, String catalog, String description, InputStream cover);
	
	public void addBookCover(int bookId, InputStream bookCover);
	public InputStream getBookCover(int bookId);
}
