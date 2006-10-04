/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.List;

import meta.codeanywhere.dao.VirtualBinaryFileDAO;
import meta.codeanywhere.filesystem.file.VirtualBinaryFile;

import org.hibernate.criterion.Restrictions;

/**
 * @author Biao Zhang
 *
 */
public class VirtualBinaryFileDAOImpl extends GenericDAOImpl<VirtualBinaryFile, Integer, VirtualBinaryFileDAO> implements VirtualBinaryFileDAO {

	public VirtualBinaryFile getByPath(String path) {
		List<VirtualBinaryFile> files = this.getByCriteria(Restrictions.eq("path", path));
		if (files.size() > 0) {
			return files.get(0);
		}
		
		return null;
	}

}
