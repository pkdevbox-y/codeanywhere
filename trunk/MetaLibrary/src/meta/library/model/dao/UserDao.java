/**
 * 
 */
package meta.library.model.dao;

import meta.library.model.bean.User;

/**
 * @author Biao Zhang
 *
 */
public interface UserDao extends GenericDao<User, Integer> {

	public User getByUsername(String username);
}
