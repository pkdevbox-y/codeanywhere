/**
 * @(#)FileManager.java
 */
package meta.codeanywhere.manager;

import meta.codeanywhere.bean.SourceFile;
import meta.codeanywhere.bean.User;
import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.SourceFileDAO;

/**
 * The FileManager process all the request to create or open a file
 * from the database file system.
 * @author Biao Zhang
 * @version 11/10/2006
 */
public class FileManager {
	private static FileManager manager = null;
	static {
		manager = new FileManager();
	}
	
	public static FileManager getManager() {
		return manager;
	}
	
	private SourceFileDAO fileDAO = null;
	
	private FileManager() {
		fileDAO = DAOFactory.DEFAULT.getSourceFileDAO();
	}
	
	public SourceFile getFileByName(String fileName) {
		return fileDAO.getByFileName(fileName);
	}
	
	public SourceFile[] getFilesByOwner(User owner) {
		return fileDAO.getByOwner(owner).toArray(new SourceFile[0]);
	}
	
	public SourceFile saveFile(String fileName, User owner, String content) {
		SourceFile file = new SourceFile();
		file.setFileName(fileName);
		file.setOwner(owner);
		file.setStringData(content);
		fileDAO.makePersistent(file);
		return file;
	}
}
