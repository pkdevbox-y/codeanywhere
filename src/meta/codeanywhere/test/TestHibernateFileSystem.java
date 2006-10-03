/**
 * 
 */
package meta.codeanywhere.test;

import meta.codeanywhere.filesystem.VirtualFileSystem;
import meta.codeanywhere.filesystem.file.VirtualFolder;

/**
 * @author Biao Zhang
 *
 */
public class TestHibernateFileSystem {
	public static void main(String[] arv) {
		VirtualFileSystem vfs = VirtualFileSystem.getInstance();
		VirtualFolder vf = vfs.createFolder("/lib/hibernate/var");
		System.out.println(vf.getPath());
		//vfs.deleteFolder("/video");
	}
}
