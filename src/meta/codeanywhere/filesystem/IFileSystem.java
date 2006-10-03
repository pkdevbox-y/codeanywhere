/**
 * 
 */
package meta.codeanywhere.filesystem;

import meta.codeanywhere.filesystem.file.VirtualFile;
import meta.codeanywhere.filesystem.file.VirtualFolder;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public interface IFileSystem {
	/**
	 * 
	 * @param path
	 * @param name
	 * @return
	 */
	public VirtualFile createFile(String path, String name);
	public VirtualFile openFile(String path, String name);
	public void deleteFile(String path, String name);
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public VirtualFolder createFile(String path);
	public VirtualFolder openFile(String path);
	public void deleteFolder(String path);
}
