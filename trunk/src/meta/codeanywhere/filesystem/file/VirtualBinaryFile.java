/**
 * 
 */
package meta.codeanywhere.filesystem.file;

import java.sql.Blob;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public class VirtualBinaryFile extends VirtualFile {
	Blob data = null;

	public VirtualBinaryFile() {
		
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
	public Blob getData() {
		return data;
	}

	public void setData(Blob data) {
		this.data = data;
	}
	
}
