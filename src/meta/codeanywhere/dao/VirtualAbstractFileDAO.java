/**
 * 
 */
package meta.codeanywhere.dao;

import meta.codeanywhere.filesystem.file.VirtualAbstractFile;


/**
 * @author Biao Zhang
 * @version 0.1 10/03/2006
 */
public interface VirtualAbstractFileDAO extends GenericDAO<VirtualAbstractFile, Integer> {
	public VirtualAbstractFile getByPath(String path);
}
