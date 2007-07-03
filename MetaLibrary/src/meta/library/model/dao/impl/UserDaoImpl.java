/**
 * 
 */
package meta.library.model.dao.impl;

import java.util.List;

import meta.library.model.bean.User;
import meta.library.model.dao.UserDao;

/**
 * @author Biao Zhang
 *
 */
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	@Override
	public User getByUsername(String username) {
		List<User> users = this.getHibernateTemplate().find("from User where username=?", username);
		User user;
		if (users == null || users.isEmpty()) {
			user = null;
		} else {
			user = users.get(0);
		}
		return user;
	}


}
