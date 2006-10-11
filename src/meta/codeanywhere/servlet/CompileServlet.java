/**
 * 
 */
package meta.codeanywhere.servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meta.codeanywhere.compile.JavaCompiler;
import meta.codeanywhere.run.JavaProcessRunner;

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
		
		PrintWriter out = response.getWriter();
		String fileName = request.getParameter("fileName");
		String source = request.getParameter("source");
		
		FileWriter fw = new FileWriter(path + "WEB-INF/classes/" + fileName + ".java");
		fw.write(source);
		fw.close();
		JavaCompiler javaCompiler = new JavaCompiler();
		javaCompiler.addSourceFile(path + "WEB-INF/classes/" + fileName + ".java");
		//javaCompiler.addSourceFile(path + "WEB-INF/classes/" + fileName + ".java", source);
		javaCompiler.compile();
		
		JavaProcessRunner javaRunner = new JavaProcessRunner(fileName, path + "WEB-INF/classes/");
		javaRunner.setWriter(out);
		javaRunner.run();
		out.close();
	}
	
}
