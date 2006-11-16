/**
 * 
 */
package meta.codeanywhere.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meta.codeanywhere.manager.CompileManager;

/**
 * @author Biao Zhang
 * @date 2006-7-14
 */
public class CompileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1064167350482325718L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = session.getServletContext().getRealPath("/");
		response.setContentType("text/plain");
		response.setLocale(Locale.CHINESE);
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String fileName = request.getParameter("fileName");
		String source = request.getParameter("source");
		
		CompileManager cm = CompileManager.getManager();
		String result = cm.compile(path, fileName, source);
		out.print(result);
		out.close();
	}
	
}
