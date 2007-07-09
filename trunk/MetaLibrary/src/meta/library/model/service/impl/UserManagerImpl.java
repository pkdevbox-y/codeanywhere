/**
 * 
 */
package meta.library.model.service.impl;

import meta.library.model.bean.User;
import meta.library.model.dao.UserDao;
import meta.library.model.service.UserManager;

/**
 * @author Biao Zhang
 *
 */
public class UserManagerImpl extends BaseManagerImpl<UserDao, User> implements UserManager {

	@Override
	public User getByUsername(String username) {
		return dao.getByUsername(username);
	}

	@Override
	public User addUser(String username, String password, String email) {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPriviledge(3);
		
		dao.save(user);
		
		return user;
	}
}
