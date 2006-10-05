/**
 * 
 */
package meta.codeanywhere.filesystem.file;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import meta.codeanywhere.dao.DAOFactory;

import org.hibernate.Hibernate;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public class VirtualBinaryFile extends VirtualFile {
	Blob data = null;

	public VirtualBinaryFile() {
		
	}
	
	public VirtualBinaryFile(String path, InputStream inputStream) throws IOException {
		super(path);
		data = Hibernate.createBlob(inputStream);
	}
	
	/**
	 * @param data
	 */
	public VirtualBinaryFile(Blob data) {
		this.data = data;
	}

	public VirtualBinaryFile(Integer id, String path, String name, VirtualFolder parentFolder, Blob data) {
		super(id, path, name, parentFolder);
		this.data = data;
	}
	public VirtualBinaryFile(String path) {
		super(path);
	}
	public Blob getData() {
		return data;
	}

	public void setData(Blob data) {
		this.data = data;
	}
	
	public InputStream getBinaryData() throws SQLException {
		return data.getBinaryStream();
	}
	
	public void setBinaryData(InputStream inputStream) throws IOException {
		data = Hibernate.createBlob(inputStream);
	}
	
	public void save() {
		DAOFactory.DEFAULT.getVirtualBinaryFileDAO().makePersistent(this);
	}
}
