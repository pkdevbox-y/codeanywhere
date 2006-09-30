/**
 * 
 */
package meta.codeanywhere.filesystem;

/**
 * @author Talent
 *
 */
public class VirtualBinaryFile extends VirtualFile implements IParentFolder{
	private VirtualFolder virtualPath =null;
	
	public VirtualBinaryFile(String path, String name) {
		super(VirtualFile.BINARY_FILE, path, name);
		// TODO Auto-generated constructor stub
	}

	public VirtualFolder getVirtualPath() {
		return virtualPath;
	}

	public void setVirtualPath(VirtualFolder virtualPath) {
		this.virtualPath = virtualPath;
	}
	
}
