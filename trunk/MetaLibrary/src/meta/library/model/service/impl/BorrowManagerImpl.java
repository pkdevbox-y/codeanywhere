/**
 * 
 */
package meta.library.model.service.impl;

import java.util.Date;

import meta.library.model.bean.Book;
import meta.library.model.bean.Borrow;
import meta.library.model.bean.User;
import meta.library.model.dao.BookDao;
import meta.library.model.dao.BorrowDao;
import meta.library.model.dao.UserDao;
import meta.library.model.service.BorrowManager;

/**
 * @author Biao Zhang
 *
 */
public class BorrowManagerImpl extends BaseManagerImpl<BorrowDao, Borrow> implements BorrowManager {
	private UserDao userDao;
	private BookDao bookDao;
	
	@Override
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
		
	}

	@Override
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		
	}

	@Override
	public Borrow borrowBook(String username, String title) {
		User user = userDao.getByUsername(username);
		Book book = bookDao.getByTitle(title);
		
		return this.borrow(user, book);
	}

	@Override
	public Borrow returnBook(String username, String title) {
		User user = userDao.getByUsername(username);
		Book book = bookDao.getByTitle(title);
		return this.returnBook(user, book);
	}

	@Override
	public Borrow borrowBook(int userId, int bookId) {
		User user = userDao.findById(userId);
		Book book = bookDao.findById(bookId);
		
		return this.borrow(user, book);
	}

	@Override
	public Borrow returnBook(int userId, int bookId) {
		User user = userDao.findById(userId);
		Book book = bookDao.findById(bookId);
		return this.returnBook(user, book);
	}

	private Borrow returnBook(User user, Book book) {
		Borrow borrow = null;
		
		return borrow;
	}
	
	private Borrow borrow(User user, Book book) {
		Borrow borrow;

		if (book.getCopy() > 0 && user != null && book != null && user.borrow()) {
			borrow = new Borrow();
			borrow.setUser(user);
			borrow.setBook(book);
			borrow.setDate(new Date());
			
			dao.save(borrow);
			
			book.borrow();
			bookDao.save(book);
		} else {
			borrow = null;
		}
		
		return borrow;
	}

	@Override
	public boolean returnBook(int borrowId) {
		Borrow borrow = dao.findById(borrowId);
		
		if (borrow != null) {
			Book book = borrow.getBook();
			book.returnBook();
			bookDao.save(book);
			
			User user = borrow.getUser();
			user.returnBook();
			userDao.save(user);
			
			dao.delete(borrow);
			return true;
		} else {
			return false;
		}
	}
}
