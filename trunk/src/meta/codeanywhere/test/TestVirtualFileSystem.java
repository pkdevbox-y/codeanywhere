/**
 * @(#)TestVirtualFileSystem.java 06/09/30
 */
package meta.codeanywhere.test;

import meta.codeanywhere.filesystem.VirtualFolder;

/**
 * @author Biao Zhang
 *
 */
public class TestVirtualFileSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VirtualFolder vf;
		try {
			vf = new VirtualFolder("/root/home", "home");
			System.out.println(vf.getPath());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
