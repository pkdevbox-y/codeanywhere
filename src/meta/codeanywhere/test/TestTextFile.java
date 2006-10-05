/**
 * 
 */
package meta.codeanywhere.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import meta.codeanywhere.filesystem.VirtualFileSystem;
import meta.codeanywhere.filesystem.file.VirtualBinaryFile;
import meta.codeanywhere.filesystem.file.VirtualTextFile;

/**
 * @author Biao Zhang
 *
 */
public class TestTextFile {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		VirtualFileSystem vfs = VirtualFileSystem.getInstance();
		/*VirtualTextFile vtf = vfs.createTextFile("/home/talent/update.list");
		String s = "Hello World!";
		Blob b = Hibernate.createBlob(s.getBytes());
		vtf.setData(b);
		DAOFactory.DEFAULT.getVirtualTextFileDAO().makePersistent(vtf);*/
		VirtualTextFile vtf = vfs.openTextFile("/home/talent/update.list");
		//vtf.setStringData("Hello World! Hello China!");
		//vtf.save();
		String s = null;
		try {
			s = vtf.getStringData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
		
		VirtualBinaryFile vbf = vfs.createBinaryFile("/lib/hibernate/hibernate.bin");
		try {
			FileInputStream fis = new FileInputStream("D:/TestShift.class");
			vbf.setBinaryData(fis);
			vbf.save();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
