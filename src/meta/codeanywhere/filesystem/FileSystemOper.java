/**
 * 
 */
package meta.codeanywhere.filesystem;

import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.VirtualFileDAO;
import meta.codeanywhere.dao.VirtualFolderDAO;
import meta.codeanywhere.filesystem.file.VirtualAbstractFile;
import meta.codeanywhere.filesystem.file.VirtualFile;
import meta.codeanywhere.filesystem.file.VirtualFolder;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public class FileSystemOper implements IFileSystem {

	private VirtualFileDAO fileDAO = null;
	private VirtualFolderDAO folderDAO = null;
	
	public FileSystemOper() {
		fileDAO = DAOFactory.DEFAULT.getVirtualFileDAO();
		folderDAO = DAOFactory.DEFAULT.getVirtualFolderDAO();
	}
	
	public VirtualFile createFile(String path, String name) {
		VirtualFile file = new VirtualFile(path);
		fileDAO.makePersistent(file);
		return file;
	}

	public VirtualFolder createFolder(String path) {
		VirtualFolder folder = openFolder(path);
		if (folder == null) {
			folder = new VirtualFolder(path);
			String parentPath = getParentPath(path);
			VirtualFolder parentFolder = openFolder(parentPath);
			folder.setParentFolder(parentFolder);
		}
		folderDAO.makePersistent(folder);
		return folder;
	}

	public void deleteFile(String path, String name) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFolder(String path) {
		// TODO Auto-generated method stub
		
	}

	public VirtualFile openFile(String path, String name) {
		return queryFile(path, name);
	}

	public VirtualFolder openFolder(String path) {
		return queryFolder(path);
	}

	public VirtualFile queryFile(String path, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public VirtualFolder queryFolder(String path) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getParentPath(String path) {
		int lastIndex = path.lastIndexOf(VirtualAbstractFile.SPLIT_CHAR, path.length() - 2);
		String parentPath = path.substring(0, lastIndex);
		
		return parentPath;
	}

}
