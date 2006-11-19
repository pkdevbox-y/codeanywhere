/**
 * 
 */
package meta.codeanywhere.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.codeanywhere.manager.WikiManager;

/**
 * @author Biao Zhang
 * @version 11/19/2006
 */
public class WikiPublicServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1512999184233907166L;

	/* £¨·Ç Javadoc£©
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/* £¨·Ç Javadoc£©
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fileName = request.getParameter("fileName");
		String source = request.getParameter("source");
		String tags = request.getParameter("tags");
		WikiManager wm = WikiManager.getManager();
		wm.addToWiki(fileName, source, tags.split(","));
		out.print(true);
		out.close();
	}

	
}
