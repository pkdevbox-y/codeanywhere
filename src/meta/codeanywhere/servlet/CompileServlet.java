/**
 * 
 */
package meta.codeanywhere.servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import meta.codeanywhere.compile.JavaCompiler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		
		FileWriter fw = new FileWriter(path + "WEB-INF/classes/" + fileName + ".java");
		fw.write(source);
		fw.close();
		JavaCompiler javaCompiler = new JavaCompiler();
		javaCompiler.addSourceFile(path + "WEB-INF/classes/" + fileName + ".java");
		//javaCompiler.addSourceFile(path + "WEB-INF/classes/" + fileName + ".java", source);
		javaCompiler.compile();
		
		List<Diagnostic<? extends JavaFileObject>> diagnosticList = javaCompiler.getDiagnostics();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		try {
			if (diagnosticList.size() > 0) {
				for (Diagnostic<? extends JavaFileObject> diagnostic: diagnosticList) {
					JSONObject jsonWarning  = new JSONObject();
					jsonWarning.put("line", new Long(diagnostic.getLineNumber()).toString());
					jsonWarning.put("message", diagnostic.getMessage(Locale.ENGLISH));
					jsonArray.put(jsonWarning);
				}
				jsonObject.put("length", jsonArray.length());
				jsonObject.put("status", "failed");
				jsonObject.put("info", jsonArray.toString());
				out.println(jsonObject.toString());
				out.close();
				return;
			}
			jsonObject.put("status", "succeed");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println(jsonObject.toString());
		out.close();
	}
	
}
