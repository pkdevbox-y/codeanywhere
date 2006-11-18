/**
 * 
 */
package meta.codeanywhere.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meta.codeanywhere.bean.SourceFile;
import meta.codeanywhere.bean.User;
import meta.codeanywhere.manager.FileManager;

/**
 * @author Biao Zhang
 * @version 11/17/2006
 */
public class FileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8369658195261937913L;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		String oper = request.getParameter("oper");
		String fileName = request.getParameter("fileName");
		String source = request.getParameter("source");
		FileManager fileManager = FileManager.getManager();
		System.out.println(user);
		if (oper.equals("open")) {
			SourceFile file = fileManager.getFileByName(fileName);
			try {
				out.print(file.getSourceText());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (oper.equals("save")) {
			SourceFile file = fileManager.saveFile(fileName, user, source);
			out.print(file != null);
		}
	}
	
	

}
