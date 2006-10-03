/**
 * 
 */
package meta.codeanywhere.filesystem.file;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public class VirtualAbstractFile {
	public static final String SPLIT_CHAR = "/";
	public static final String ROOT_PATH = "/";
	
	private Integer id;
	private String path = null;
	private String name = null;
	
	public VirtualAbstractFile() {
		
	}
	
	public VirtualAbstractFile(String path) {
		this.path = path;
		name = this.getNameFromPath(path);
	}

	
	
	/**
	 * @param id the id of the item
	 * @param path
	 * @param name
	 */
	public VirtualAbstractFile(Integer id, String path, String name) {
		this.id = id;
		this.path = path;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Used to identify the name of the file or folder
	 * @param path
	 * @return the file name containded in the path
	 */
	private String getNameFromPath(String path) {
		String name = null;
		if (path.equals(ROOT_PATH)) {
			name = "/";
		} else {
			String[] parentFolders = path.split(SPLIT_CHAR);
			name = parentFolders[parentFolders.length - 1];
		}
		
		return name;
	}
}
