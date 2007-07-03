/**
 * 
 */
package meta.test.library.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import meta.library.model.bean.BookCover;
import meta.library.model.dao.BookCoverDao;

import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Biao Zhang
 * 
 */
public class TestBookCoverDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/applicationContext-*.xml");

		BookCoverDao bookCoverDao = (BookCoverDao) context.getBean("BookCoverDao");
		BookCover bc = new BookCover();
		try {
			FileInputStream imgis = new FileInputStream("WebContent/images/logo.gif");
			Blob img = Hibernate.createBlob(imgis);
			bc.setCover(img);
			
			BookCover bc2 = bookCoverDao.findById(1);
			Blob blob = bc2.getCover();
			InputStream is = blob.getBinaryStream();
			FileOutputStream fos = new FileOutputStream("D:/test.gif");
			byte[] buf = new byte[102400];
			int len;
			
			while ((len = is.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			
			fos.close();
			is.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bookCoverDao.save(bc);

	}

}
