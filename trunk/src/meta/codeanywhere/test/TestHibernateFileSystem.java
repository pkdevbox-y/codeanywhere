/**
 * 
 */
package meta.codeanywhere.test;

import meta.codeanywhere.filesystem.VirtualFileSystem;

/**
 * @author Biao Zhang
 *
 */
public class TestHibernateFileSystem {
	public static void main(String[] arv) {
		VirtualFileSystem vfs = VirtualFileSystem.getInstance();
		//VirtualFolder vf = vfs.createFolder("/lib/hibernate/var");
		//System.out.println(vf.getPath());
		//VirtualFile vfile = vfs.createFile("/lib/hibernate/conf.ini", "conf.ini");
		vfs.deleteFolder("/lib");
		
		/*VirtualFileDAO fileDAO = DAOFactory.DEFAULT.getVirtualFileDAO();
		VirtualFolderDAO folderDAO = DAOFactory.DEFAULT.getVirtualFolderDAO();
		
		VirtualFolder vfolder = folderDAO.getByPath("/lib/hibernate");
		List<VirtualFile> vfiles = fileDAO.getSubFiles(vfolder);
		
		for (VirtualFile file: vfiles) {
			DAOFactory.DEFAULT.getVirtualAbstractFileDAO().makeTransient(file);
			System.out.println(file.getName());
		}*/
	}
}
