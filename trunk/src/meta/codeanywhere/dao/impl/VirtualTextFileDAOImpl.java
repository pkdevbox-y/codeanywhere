/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.List;

import meta.codeanywhere.dao.VirtualTextFileDAO;
import meta.codeanywhere.filesystem.file.VirtualTextFile;

import org.hibernate.criterion.Restrictions;

/**
 * @author Biao Zhang
 *
 */
public class VirtualTextFileDAOImpl extends GenericDAOImpl<VirtualTextFile, Integer, VirtualTextFileDAO> implements VirtualTextFileDAO {

	public VirtualTextFile getByPath(String path) {
		List<VirtualTextFile> files = this.getByCriteria(Restrictions.eq("path", path));
		if (files.size() > 0) {
			return files.get(0);
		}
		
		return null;
	}

}
