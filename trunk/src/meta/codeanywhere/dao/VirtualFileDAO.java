/**
 * 
 */
package meta.codeanywhere.dao;

import java.util.List;

import meta.codeanywhere.filesystem.file.VirtualFile;
import meta.codeanywhere.filesystem.file.VirtualFolder;

/**
 * @author Biao Zhang
 *
 */
public interface VirtualFileDAO extends GenericDAO<VirtualFile, Integer> {
	public VirtualFile getByPath(String path);
	public List<VirtualFile> getSubFiles(VirtualFolder parent);
}
