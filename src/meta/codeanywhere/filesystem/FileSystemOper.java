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
public class FileSystemOper implements IFileSystem {

	public VirtualFile createFile(String path, String name) {
		VirtualFile file = new VirtualFile(path);
		// TODO Save the file in the database
		return file;
	}

	public VirtualFolder createFile(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteFile(String path, String name) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFolder(String path) {
		// TODO Auto-generated method stub
		
	}

	public VirtualFile openFile(String path, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public VirtualFolder openFile(String path) {
		// TODO Auto-generated method stub
		return null;
	}


}
