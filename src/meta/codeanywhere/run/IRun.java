/**
 * To run an executable file
 */
package meta.codeanywhere.run;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Biao Zhang
 * @date 2006-7-15
 */
public interface IRun {
	public int run();
	
	public InputStream getInputStream();
	
	public OutputStream getOutputStream();
}
