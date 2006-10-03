/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.List;

import meta.codeanywhere.dao.VirtualAbstractFileDAO;
import meta.codeanywhere.filesystem.file.VirtualAbstractFile;

import org.hibernate.criterion.Restrictions;

/**
 * @author Biao Zhang
 * @version 0.1 10/03/2006
 *
 */
public class VirtualAbstractFileDAOImpl extends GenericDAOImpl<VirtualAbstractFile, Integer, VirtualAbstractFileDAO> implements VirtualAbstractFileDAO {

	public VirtualAbstractFile getByPath(String path) {
		List<VirtualAbstractFile> files = this.getByCriteria(Restrictions.eq("path", path));
		if (files.size() > 0) {
			return files.get(0);
		}
		
		return null;
	}

}
