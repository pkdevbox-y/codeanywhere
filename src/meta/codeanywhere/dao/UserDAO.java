/**
 * 
 */
package meta.codeanywhere.dao;

import meta.codeanywhere.bean.User;

/**
 * @author Biao Zhang
 *
 */
public interface UserDAO extends GenericDAO<User, Integer> {
	public User getByUserName(String username);
}
