/**
 * 
 */
package meta.codeanywhere.filesystem;

import java.util.List;

import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.VirtualAbstractFileDAO;
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

	private VirtualAbstractFileDAO abstractFileDAO = null;
	private VirtualFileDAO fileDAO = null;
	private VirtualFolderDAO folderDAO = null;
	
	public FileSystemOper() {
		abstractFileDAO = DAOFactory.DEFAULT.getVirtualAbstractFileDAO();
		fileDAO = DAOFactory.DEFAULT.getVirtualFileDAO();
		folderDAO = DAOFactory.DEFAULT.getVirtualFolderDAO();
	}
	
	public VirtualFile createFile(String path, String name) {
		VirtualFile file = queryFile(path, name);
		if (file == null) {
			file = new VirtualFile(path);
			String parentPath = getParentPath(path);
			VirtualFolder parentFolder = queryFolder(parentPath);
			if (parentFolder == null) {
				parentFolder = createFolder(parentPath);
			}
			file.setParentFolder(parentFolder);
		}
		fileDAO.makePersistent(file);
		return file;
	}

	public VirtualFolder createFolder(String path) {
		VirtualFolder folder = queryFolder(path);
		if (folder == null) {
			folder = new VirtualFolder(path);
			String parentPath = getParentPath(path);
			VirtualFolder parentFolder = queryFolder(parentPath);
			if (parentFolder == null) {
				parentFolder = createFolder(parentPath);
			}
			folder.setParentFolder(parentFolder);
		}
		folderDAO.makePersistent(folder);
		return folder;
	}

	public void deleteFile(String path, String name) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFolder(String path) {
		VirtualFolder folder = queryFolder(path);
		if (folder != null) {
			List<VirtualAbstractFile> children = folderDAO.getSubFiles(folder);
			if (children != null) {
				for (VirtualAbstractFile child: children) {
					deleteFolder(child.getPath());
				}
			}
			abstractFileDAO.makeTransient(folder);
		}
		
		VirtualFile file = fileDAO.getByPath(path);
		if (file != null) {
			abstractFileDAO.makeTransient(file);
		}
	}

	public VirtualFile openFile(String path, String name) {
		return queryFile(path, name);
	}

	public VirtualFolder openFolder(String path) {
		return queryFolder(path);
	}

	public VirtualFile queryFile(String path, String name) {
		return fileDAO.getByPath(path);
	}

	public VirtualFolder queryFolder(String path) {
		return folderDAO.getByPath(path);
	}
	
	private String getParentPath(String path) {
		int lastIndex = path.lastIndexOf(VirtualAbstractFile.SPLIT_CHAR, path.length() - 2);
		String parentPath = null;
		if (lastIndex == 0) {
			parentPath = path.substring(0, 1);
		} else {
			parentPath = path.substring(0, lastIndex);
		}
		
		return parentPath;
	}

}
