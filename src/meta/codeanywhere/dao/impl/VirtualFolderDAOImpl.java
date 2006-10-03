/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.List;

import meta.codeanywhere.dao.VirtualFolderDAO;
import meta.codeanywhere.filesystem.file.VirtualFolder;

import org.hibernate.criterion.Restrictions;

/**
 * @author Talent
 *
 */
public class VirtualFolderDAOImpl extends GenericDAOImpl<VirtualFolder, Integer, VirtualFolderDAO> implements VirtualFolderDAO {

	public VirtualFolder getByPath(String path) {
		List<VirtualFolder> list = this.getByCriteria(Restrictions.eq("path", path));
		
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<VirtualFolder> getSubFiles(VirtualFolder parent) {
		List<VirtualFolder> children = this.getByCriteria(Restrictions.eq("parentFolder", parent));
		if (children.size() > 0) {
			return children;
		}
		
		return null;
	}
}