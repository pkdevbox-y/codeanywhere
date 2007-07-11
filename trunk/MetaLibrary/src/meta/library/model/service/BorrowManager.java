/**
 * 
 */
package meta.library.model.service;

import meta.library.model.bean.Borrow;
import meta.library.model.dao.BookDao;
import meta.library.model.dao.BorrowDao;
import meta.library.model.dao.UserDao;

/**
 * @author Biao Zhang
 *
 */
public interface BorrowManager extends BaseManager<BorrowDao, Borrow> {
	public void setUserDao(UserDao userDao);
	public void setBookDao(BookDao bookDao);
	
	public Borrow borrowBook(String username, String title);
	public Borrow returnBook(String username, String title);
	
	public Borrow borrowBook(int userId, int bookId);
	public Borrow returnBook(int userId, int bookId);
	
	public boolean returnBook(int borrowId);
}
