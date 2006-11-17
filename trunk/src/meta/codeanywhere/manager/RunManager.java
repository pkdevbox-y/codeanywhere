/**
 * @(#)RunManager.java
 */
package meta.codeanywhere.manager;

/**
 * The RunManaer process all the request to run a class
 * and print out the result.
 * @author Biao Zhang
 * @version 11/10/2006
 */
public class RunManager {
	private static RunManager manager = null;
	static {
		manager = new RunManager();
	}

	public static RunManager getManager() {
		return manager;
	}
	
	public void run(String classFile, String classPath) {
		
	}
}
