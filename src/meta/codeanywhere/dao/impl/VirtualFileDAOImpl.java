/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.List;

import meta.codeanywhere.dao.VirtualFileDAO;
import meta.codeanywhere.filesystem.file.VirtualFile;
import meta.codeanywhere.filesystem.file.VirtualFolder;

import org.hibernate.criterion.Restrictions;

/**
 * @author Biao Zhang
 * @version 0.1 10/03/2006
 *
 */
public class VirtualFileDAOImpl extends GenericDAOImpl<VirtualFile, Integer, VirtualFileDAO> implements VirtualFileDAO{

	public List<VirtualFile> getSubFiles(VirtualFolder parent) {
		List<VirtualFile> children = this.getByCriteria(Restrictions.eq("parentFolder", parent));
		if (children.size() > 0) {
			return children;
		}
		
		return null;
	}

	public VirtualFile getByPath(String path) {
		List<VirtualFile> files = this.getByCriteria(Restrictions.eq("path", path));
		if (files.size() > 0) {
			return files.get(0);
		}
		
		return null;
	}

}
