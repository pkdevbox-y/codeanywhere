/**
 * @(#)SourceFileDAO.java
 */
package meta.codeanywhere.dao;

import meta.codeanywhere.bean.SourceFile;

/**
 * @author Biao Zhang
 * @version 11/17/2006
 */
public interface SourceFileDAO extends GenericDAO<SourceFile, Integer> {
	public SourceFile getByFileName(String path);
}
