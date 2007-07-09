/**
 * 
 */
package meta.library.model.service;

import java.io.InputStream;
import java.util.List;

import meta.library.model.bean.Book;
import meta.library.model.dao.BookDao;

/**
 * @author Biao Zhang
 *
 */
public interface BookManager extends BaseManager<BookDao, Book> {
	public Book getByTitle(String title);
	
	public List<Book> getByAuthor(String author);	
	public List<Book> getByPress(String press);
	
	public List<Book> searchByTitle(String title);
	public List<Book> searchByAuthor(String author);	
	public List<Book> searchByPress(String press);
	
	public List<Book> search(String keywords);
	
	public Book addBook(String title, String author, String press, String isbn, String catalog, String description);
	
	public Book addBook(String title, String author, String press, String isbn, String catalog, String description, InputStream cover);
	
	public void addBookCover(int bookId, InputStream bookCover);
	public InputStream getBookCover(int bookId);
}
