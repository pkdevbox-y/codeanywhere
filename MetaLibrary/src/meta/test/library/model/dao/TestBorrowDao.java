package meta.test.library.model.dao;

import java.util.Date;

import meta.library.model.bean.Book;
import meta.library.model.bean.Borrow;
import meta.library.model.bean.User;
import meta.library.model.dao.BookDao;
import meta.library.model.dao.BorrowDao;
import meta.library.model.dao.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestBorrowDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext-*.xml");
		
		UserDao userDAO = (UserDao) context.getBean("UserDao");
		User u = userDAO.findById(1);
		
		System.out.println(u.getUsername());
		
		BookDao bookDao = (BookDao) context.getBean("BookDao");
		Book b = bookDao.findById(1);
		
		System.out.println(b.getTitle());
		
		BorrowDao borrowDao = (BorrowDao) context.getBean("BorrowDao");
		
		Borrow borrow = new Borrow();
		borrow.setUser(u);
		borrow.setBook(b);
		borrow.setDate(new Date());
		
		borrowDao.save(borrow);
	}
}
