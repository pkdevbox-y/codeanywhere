/**
 * 
 */
package meta.codeanywhere.test;

import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.VirtualFolderDAO;
import meta.codeanywhere.filesystem.file.VirtualFolder;

/**
 * @author Biao Zhang
 *
 */
public class TestHibernateFileSystem {
	public static void main(String[] arv) {
		VirtualFolderDAO folderDAO = DAOFactory.DEFAULT.getVirtualFolderDAO();
		
		VirtualFolder vf = new VirtualFolder("/home/talent");
		folderDAO.makePersistent(vf);
		VirtualFolder vf2 = new VirtualFolder("/home/talent/video");
		vf2.setParentFolder(vf);
		folderDAO.makePersistent(vf2);
	}
}
