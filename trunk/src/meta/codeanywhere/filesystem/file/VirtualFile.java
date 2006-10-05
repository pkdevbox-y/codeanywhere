/**
 * 
 */
package meta.codeanywhere.filesystem.file;

import meta.codeanywhere.dao.DAOFactory;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public class VirtualFile extends VirtualAbstractFile {

	private VirtualFolder parentFolder = null;		
	public VirtualFile() {
		
	}
	
	public VirtualFile(String path) {
		super(path);
	}
	
	/**
	 * @param parentFolder
	 */
	public VirtualFile(Integer id, String path, String name, VirtualFolder parentFolder) {
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
	
	public void save() {
		DAOFactory.DEFAULT.getVirtualFileDAO().makePersistent(this);
	}
}
