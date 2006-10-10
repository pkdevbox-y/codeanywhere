/**
 * 
 */
package meta.codeanywhere.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.codeanywhere.filesystem.VirtualFileSystem;
import meta.codeanywhere.filesystem.file.VirtualTextFile;

/**
 * @author Biao Zhang
 * @version 10/09/2006
 *
 */
public class SourceFileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8034298620954289788L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		String source = request.getParameter("source");
		
		VirtualTextFile file = VirtualFileSystem.getInstance().createTextFile(fileName);
		file.setStringData(source);
		file.save();
	}

}
