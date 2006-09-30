/**
 * 
 */
package meta.codeanywhere.filesystem;

/**
 * @author Talent
 *
 */
public class VirtualTextFile extends VirtualFile implements IParentFolder {
	private VirtualFolder virtualPath =null;
	
	public VirtualTextFile(String path, String name) {
		super(VirtualFile.TEXT_FILE, path, name);
		// TODO Auto-generated constructor stub
	}

	public VirtualFolder getVirtualPath() {
		return virtualPath;
	}

	public void setVirtualPath(VirtualFolder virtualPath) {
		this.virtualPath = virtualPath;	
	}	
}
