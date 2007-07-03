/**
 * 
 */
package meta.test.library.model.dao;

import meta.library.model.bean.User;
import meta.library.model.dao.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Biao Zhang
 *
 */
public class TestUserDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext-*.xml");
		
		UserDao userDAO = (UserDao) context.getBean("UserDao");
		User u = userDAO.findById(1);
		
		System.out.println(u.getUsername());
	}

}
