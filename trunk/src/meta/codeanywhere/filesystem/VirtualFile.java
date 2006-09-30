/**
 * @(#)VirtualFile.java 0.1 06/09/30
 */
package meta.codeanywhere.filesystem;

/**
 * @author Biao Zhang
 * @version 0.1 06/09/30
 * This represent the file in the virtual file system, and it has three file type,
 * binary file, text file and folder
 */
public abstract class VirtualFile {
	/* file type of the file */
	public static final int FOLDER = 0;
	public static final int BINARY_FILE = 1;
	public static final int TEXT_FILE = 2;
	
	private int type = FOLDER;
	private String path = VirtualFileSystem.ROOT_PATH;
	private String name = null;
	
	/* constructor with no parameter can not be used */
	private VirtualFile() {
		
	}

	/**
	 * @param type the file type
	 * @param path the path of the file
	 * @param name the file name
	 * if it is a file, and the path is /home/talent/profile.inf, then the name is profile.inf
	 * if it is a folder, and the path is  /home/talent/profile, then the name is profile
	 */
	public VirtualFile(int type, String path, String name) {
		this.type = type;
		this.path = path;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
