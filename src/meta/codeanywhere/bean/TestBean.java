/**
 * 
 */
package meta.codeanywhere.bean;

import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.SourceFileDAO;
import meta.codeanywhere.dao.UserDAO;

/**
 * @author Biao Zhang
 *
 */
public class TestBean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDAO userDAO = DAOFactory.DEFAULT.getUserDAO();
		SourceFileDAO fileDAO = DAOFactory.DEFAULT.getSourceFileDAO();
		
		User u = userDAO.getByUserName("bbiao");
		SourceFile file = new SourceFile();
		file.setFileName("test.bin");
		file.setOwner(u);
		file.setStringData("Just a test!");
		fileDAO.makePersistent(file);
		
		SourceFile[] files = fileDAO.getByOwner(u).toArray(new SourceFile[0]);
		System.out.println(files.length);
	}

}
/** All tests passed */