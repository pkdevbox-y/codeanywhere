/**
 * 
 */
package meta.codeanywhere.filesystem;

/**
 * @author Talent
 *
 */
public class VirtualFolder extends VirtualFile {
	
	public VirtualFolder(String path, String name) throws Throwable {
		super(VirtualFile.FOLDER, path, name);
		
		String[] folders = path.split(VirtualFileSystem.SPLIT_CHAR);
		String pathName = folders[folders.length - 1];
		if (!pathName.equals(name)) {
			throw new Exception("Folder path and name don't match");
		}
	}
}
