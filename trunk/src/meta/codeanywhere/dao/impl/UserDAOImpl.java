/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.List;

import meta.codeanywhere.bean.User;
import meta.codeanywhere.dao.UserDAO;

import org.hibernate.criterion.Restrictions;


/**
 * @author Biao Zhang
 * @version 11/17/2006
 */
public class UserDAOImpl extends GenericDAOImpl<User, Integer, UserDAO> implements UserDAO {

	public User getByUserName(String username) {
		List<User> users = this.getByCriteria(Restrictions.eq("username", username));
		if (users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}
	
}
