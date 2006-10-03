/**
 * 
 */
package meta.codeanywhere.dao;

import java.util.List;

import meta.codeanywhere.filesystem.file.VirtualAbstractFile;
import meta.codeanywhere.filesystem.file.VirtualFolder;

/**
 * @author Biao Zhang
 * @version 0.1 10/03/2006
 *
 */
public interface VirtualFolderDAO extends GenericDAO<VirtualFolder, Integer> {
	public VirtualFolder getByPath(String path);
	public List<VirtualAbstractFile> getSubFiles(VirtualFolder parent);
}
