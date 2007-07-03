/**
 * 
 */
package meta.test.library.model.dao;

import meta.library.model.bean.Book;
import meta.library.model.dao.BookDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;



/**
 * @author Biao Zhang
 *
 */
public class TestBookDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext-*.xml");
		
		BookDao bookDao = (BookDao) context.getBean("BookDao");
		Book b = bookDao.findById(1);
		
		System.out.println(b.getTitle());
	}
	
}
