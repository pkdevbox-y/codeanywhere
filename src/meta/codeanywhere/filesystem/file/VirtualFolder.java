/**
 * 
 */
package meta.codeanywhere.filesystem.file;

import java.util.List;

import meta.codeanywhere.dao.DAOFactory;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public class VirtualFolder extends VirtualAbstractFile {

	private VirtualFolder parentFolder = null;
	private List<VirtualAbstractFile> subFiles = null;
	
	public VirtualFolder() {
		
	}
	
	public VirtualFolder(String path) {
		super(path);
	}
	
	/**
	 * 
	 * @param id
	 * @param path
	 * @param name
	 * @param parentFolder
	 */
	public VirtualFolder(Integer id, String path, String name, VirtualFolder parentFolder) {
		super(id, path, name);
		this.parentFolder = parentFolder;
	}

	/**
	 * Initialized on first call or this may do by Hibernate
	 * @return the parentFolder of the file
	 */
	public VirtualFolder getParentFolder() {
		if (parentFolder == null) {
			// TODO Initialized it
		}
		return parentFolder;
	}
	
	public void setParentFolder(VirtualFolder parentFolder) {
		this.parentFolder = parentFolder;
	}
	
	/**
	 * This must do during the first call to the method
	 * @return all sub folders and files contained in the folder
	 */
	public List<VirtualAbstractFile> getSubFiles() {
		if (subFiles == null) {
			subFiles = DAOFactory.DEFAULT.getVirtualFolderDAO().getSubFiles(this);
		}
		
		return subFiles;
	}
}
