/**
 * 
 */
package meta.library.model.service;

import meta.library.model.bean.User;
import meta.library.model.dao.UserDao;

/**
 * @author Biao Zhang
 *
 */
public interface UserManager extends BaseManager<UserDao, User>{
	
	public User getByUsername(String username);
	
	public User registerUser(String username, String password, String email);
}
