/**
 * @(#)UserManager.java
 */
package meta.codeanywhere.manager;

import meta.codeanywhere.bean.User;
import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.UserDAO;

/**
 * @author Biao Zhang
 * @version 11/17/2006
 */
public class UserManager {
	private static UserManager manager = null;
	static {
		manager = new UserManager();
	}
	
	public static UserManager getManager() {
		return manager;
	}
	
	private UserDAO userDAO = null;
	private UserManager() {
		
	}
	
	public User check(String username, String password) {
		userDAO = DAOFactory.DEFAULT.getUserDAO();
		User u = userDAO.getByUserName(username);
		if (u != null && u.getPassword().equals(password)) {
			return u;
		}
		return null;
	}
	
	public User register(String username, String password, String email) {
		userDAO = DAOFactory.DEFAULT.getUserDAO();
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);
		userDAO.makePersistent(u);
		return u;
	}
	
	public static void main(String[] args) {
		UserManager um = UserManager.getManager();
		um.register("zb1985", "123456", "zb1985");
		System.out.println(um.check("admin", "1985zb"));
	}
}
