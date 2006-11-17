/**
 * @(#)UserManager.java
 */
package meta.codeanywhere.manager;

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
	
	private UserManager() {
		
	}
	
	public boolean check(String username, String password) {
	
		return false;
	}
	
	public void register(String username, String password, String email) {
		
	}
}
