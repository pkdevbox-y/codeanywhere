/**
 * @(#)FileManager.java
 */
package meta.codeanywhere.manager;

/**
 * The FileManager process all the request to create or open a file
 * from the database file system.
 * @author Biao Zhang
 * @version 11/10/2006
 */
public class FileManager {
	private static FileManager manager = null;
	static {
		manager = new FileManager();
	}
	
	public static FileManager getManager() {
		return manager;
	}
}
