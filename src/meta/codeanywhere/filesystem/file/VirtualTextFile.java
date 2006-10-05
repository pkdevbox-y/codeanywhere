/**
 * 
 */
package meta.codeanywhere.filesystem.file;

import java.sql.Blob;
import java.sql.SQLException;

import meta.codeanywhere.dao.DAOFactory;

import org.hibernate.Hibernate;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public class VirtualTextFile extends VirtualFile {
	Blob data = null;

	public VirtualTextFile() {
		
	}
	
	public VirtualTextFile(String path, String text) {
		this(path);
		this.data = Hibernate.createBlob(text.getBytes());
	}
	
	/**
	 * @param data
	 */
	public VirtualTextFile(Blob data) {
		this.data = data;
	}

	public VirtualTextFile(Integer id, String path, String name, VirtualFolder parentFolder, Blob data) {
		super(id, path, name, parentFolder);
		this.data = data;
	}
	public VirtualTextFile(String path) {
		super(path);
	}
	public Blob getData() {
		return data;
	}

	public void setData(Blob data) {
		this.data = data;
	}
	
	public void setStringData(String stringData) {
		data = Hibernate.createBlob(stringData.getBytes());
	}
	
	public String getStringData() throws SQLException {
		String s = new String(data.getBytes(1, (int) data.length()));
		return s;
	}
	
	public void save() {
		DAOFactory.DEFAULT.getVirtualTextFileDAO().makePersistent(this);
	}
}
