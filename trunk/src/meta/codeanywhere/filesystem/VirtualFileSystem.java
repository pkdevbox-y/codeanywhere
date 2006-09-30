/**
 * @(#)VirtualFileSystem.java 0.1 06/09/30
 * 
 */
package meta.codeanywhere.filesystem;

/**
 * @author Biao Zhang
 * @date 2006-9-30
 * @version 0.1 06/09/30
 * This is a virtual file system  based on database.
 * And the path style is like Unix.
 * The file in the system could be binary file or text file or a folder
 */
public class VirtualFileSystem {
	/* the root path of the file system */
	public static final String ROOT_PATH = "/";
	
	/* the splic char of the path string */
	public static final String SPLIT_CHAR = "/";
}
