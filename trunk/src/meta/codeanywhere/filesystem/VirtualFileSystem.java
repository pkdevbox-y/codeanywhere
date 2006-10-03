/**
 * 
 */
package meta.codeanywhere.filesystem;

import meta.codeanywhere.filesystem.file.VirtualFile;
import meta.codeanywhere.filesystem.file.VirtualFolder;

/**
 * @author Biao Zhang
 * @version 0.1 10/03/2006
 */
public class VirtualFileSystem {

	private static VirtualFileSystem instance = null;
	
	private IFileSystem fileSystem = null;
	
	static {
		instance  = new VirtualFileSystem();
	}
	
	public static VirtualFileSystem getInstance() {
		return instance;
	}
	
	private VirtualFileSystem() {
		fileSystem = new FileSystemOper();
	}

	public VirtualFile createFile(String path) {
		return fileSystem.createFile(path);
	}

	public VirtualFolder createFolder(String path) {
		return fileSystem.createFolder(path);
	}

	public void deleteFile(String path) {
		fileSystem.deleteFile(path);
		
	}

	public void deleteFolder(String path) {
		fileSystem.deleteFolder(path);
		
	}

	public VirtualFile openFile(String path) {
		return fileSystem.openFile(path);
	}

	public VirtualFolder openFolder(String path) {
		return fileSystem.openFolder(path);
	}
}
