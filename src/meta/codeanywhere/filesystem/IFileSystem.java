package meta.codeanywhere.filesystem;


import meta.codeanywhere.filesystem.file.VirtualBinaryFile;
import meta.codeanywhere.filesystem.file.VirtualFile;
import meta.codeanywhere.filesystem.file.VirtualFolder;

/**
 * @author Biao Zhang
 * @version 10/02/2006
 *
 */
public interface IFileSystem {
	/**
	 * 
	 * @param path
	 * @param name
	 * @return
	 */
	public VirtualFile createFile(String path);
	public VirtualFile openFile(String path);
	public void deleteFile(String path);
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public VirtualBinaryFile createBinaryFile(String path);
	public VirtualBinaryFile openBinaryFile(String path);
	public void deleteBinaryFile(String path);
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public VirtualFolder createFolder(String path);
	public VirtualFolder openFolder(String path);
	public void deleteFolder(String path);
	
	/**
	 * 
	 * @param path
	 * @param name
	 * @return
	 */
	public VirtualFile queryFile(String path);
	public VirtualBinaryFile queryBinaryFile(String path);
	public VirtualFolder queryFolder(String path);
}
