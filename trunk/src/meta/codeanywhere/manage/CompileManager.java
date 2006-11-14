/**
 * @(#)CompileManager.java
 */
package meta.codeanywhere.manage;

/**
 * The CompileManager process all the request to compile a sourse file.
 * 
 * @author Biao Zhang
 * @version 11/10/2006
 */
public class CompileManager {
	private static CompileManager manager = null;
	static {
		manager = new CompileManager();
	}

	public static CompileManager getManager() {
		return manager;
	}
	public void compile() {

	}
}
