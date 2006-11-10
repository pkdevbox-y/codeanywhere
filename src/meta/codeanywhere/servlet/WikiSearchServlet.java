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

import meta.codeanywhere.manage.WikiManager;

import org.json.JSONArray;

/**
 * @author Biao Zhang
 * @version 11/10/2006
 *
 */
public class WikiSearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2756504304032088910L;

	/* £¨None Javadoc£©
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/* £¨Non Javadoc£©
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		String tagsStr = request.getParameter("tags").trim();
		String[] tags = tagsStr.split(" ");
		
		WikiManager wikiManager = WikiManager.getInstance();
		JSONArray result = wikiManager.search(tags);
		
		
		out.print(result.toString());
		out.close();
		
	}

	
}
