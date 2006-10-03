/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.LinkedList;
import java.util.List;

import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.VirtualFolderDAO;
import meta.codeanywhere.filesystem.file.VirtualAbstractFile;
import meta.codeanywhere.filesystem.file.VirtualFile;
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

	public List<VirtualAbstractFile> getSubFiles(VirtualFolder parent) {
		List<VirtualFolder> folderList = this.getSubFolders(parent);
		List<VirtualFile> fileList = DAOFactory.DEFAULT.getVirtualFileDAO().getSubFiles(parent);
		
		List<VirtualAbstractFile> abstractFileList = new LinkedList<VirtualAbstractFile>();
		
		if (folderList != null) {
			for (VirtualFolder folder: folderList) {
				abstractFileList.add(folder);
			}
		}
		
		if (fileList != null) {
			for (VirtualFile file: fileList) {
				abstractFileList.add(file);
			}
		}
		
		if (abstractFileList.size() > 0) {
			return abstractFileList;
		}
		
		return null;
	}
	
	public List<VirtualFolder> getSubFolders(VirtualFolder parent) {
		List<VirtualFolder> children = this.getByCriteria(Restrictions.eq("parentFolder", parent));
		if (children.size() > 0) {
			return children;
		}
		
		return null;
	}
}