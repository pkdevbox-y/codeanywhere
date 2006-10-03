/**
 * 
 */
package meta.codeanywhere.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;

import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.VirtualBinaryFileDAO;
import meta.codeanywhere.filesystem.file.VirtualBinaryFile;

import org.hibernate.Hibernate;

/**
 * @author Biao Zhang
 *
 */
public class TestBlobInHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VirtualBinaryFileDAO bfDAO = DAOFactory.DEFAULT.getVirtualBinaryFileDAO();
		try {
			FileInputStream fis = new FileInputStream("D:/TestShift.class");
			Blob data = Hibernate.createBlob(fis);
			VirtualBinaryFile bf = new VirtualBinaryFile();
			bf.setData(data);
			bfDAO.makePersistent(bf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
