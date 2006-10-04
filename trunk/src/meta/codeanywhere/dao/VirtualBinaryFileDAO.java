/**
 * 
 */
package meta.codeanywhere.dao;

import meta.codeanywhere.filesystem.file.VirtualBinaryFile;

/**
 * @author Biao Zhang
 *
 */
public interface VirtualBinaryFileDAO extends GenericDAO<VirtualBinaryFile, Integer> {
	public VirtualBinaryFile getByPath(String path);
}
