/**
 * 
 */
package meta.library.model.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import meta.library.model.bean.Book;
import meta.library.model.dao.BookDao;
import meta.library.model.service.BookManager;

import org.hibernate.Hibernate;

/**
 * @author Biao Zhang
 *
 */
public class BookManagerImpl extends BaseManagerImpl<BookDao, Book> implements BookManager {

	@Override
	public Book addBook(String title, String author, String isbn,
			String catalog, String description) {
		Book book = new Book(title, author, isbn, catalog, description);
		
		dao.save(book);		
		
		return book;
	}

	@Override
	public void addBookCover(int bookId, InputStream bookCover) {
		Book book = dao.findById(bookId);
		try {
			book.setCover(Hibernate.createBlob(bookCover));
			dao.save(book);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	@Override
	public InputStream getBookCover(int bookId) {
		Book book = dao.findById(bookId);
		InputStream bookCover;
		if (book != null && book.getCover() != null) {
			try {
				bookCover = book.getCover().getBinaryStream();
			} catch (SQLException sqle) {
				bookCover = null;
				
				sqle.printStackTrace();
			}
		} else {
			bookCover = null;
		}
		return bookCover;
	}

	@Override
	public Book addBook(String title, String author, String isbn,
			String catalog, String description, InputStream cover) {
		Book book = new Book(title, author, isbn, catalog, description);
		
		if (cover != null) {
			try {
				book.setCover(Hibernate.createBlob(cover));
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}	
		}		
		
		dao.save(book);		
		
		return book;
	}

	@Override
	public Book getByTitle(String title) {
		Book book = dao.getByTitle(title);
		return book;
	}

}
