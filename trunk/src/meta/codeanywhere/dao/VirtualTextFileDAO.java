/**
 * 
 */
package meta.codeanywhere.dao;

import meta.codeanywhere.filesystem.file.VirtualTextFile;

/**
 * @author Biao Zhang
 *
 */
public interface VirtualTextFileDAO extends GenericDAO<VirtualTextFile, Integer> {
	public VirtualTextFile getByPath(String path);
}
