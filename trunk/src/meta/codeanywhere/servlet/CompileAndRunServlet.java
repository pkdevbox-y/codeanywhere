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
import meta.codeanywhere.run.JavaProcessRunner;

/**
 * @author Talent
 *
 */
public class CompileAndRunServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1272601354197173306L;

	/* （非 Javadoc）
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成方法存根
		doPost(request, response);
	}

	/* （非 Javadoc）
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = session.getServletContext().getRealPath("/");
		response.setContentType("text/html");
		response.setLocale(Locale.CHINESE);
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>codeAnywhere for Mobile beta</title><body>");
		String fileName = request.getParameter("fileName");
		String source = request.getParameter("source");
		
		CompileManager cm = CompileManager.getManager();
		String result = cm._compile(path, fileName, source);
		if (result.length() > 0) {
			out.print("Compile completed.<br>But there are errors:<br>");
			out.print(result);
		} else {
			out.print("Compile completed.<br>And the result is:<br>");
			JavaProcessRunner javaRunner = new JavaProcessRunner(fileName, path + "WEB-INF/classes/");
			javaRunner.setWriter(out);
			javaRunner.run();
		}
		out.print("<br><a href=\"mobile/index.html\">Go back</a>");
		out.print("</body></html>");
		out.close();
	}

	
}
