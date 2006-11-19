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

import meta.codeanywhere.bean.User;
import meta.codeanywhere.manager.RunManager;

/**
 * @author Biao Zhang
 * @version 11/08/2006
 */
public class RunServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1747522423024779412L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = session.getServletContext().getRealPath("/");
		response.setContentType("text/plain");
		response.setLocale(Locale.CHINESE);
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String fileName = request.getParameter("fileName");
		RunManager rm = RunManager.getManager();
		User u = (User) session.getAttribute("user");
		Integer uid = u != null ? u.getId() : new Integer(1);
		if (rm.run(uid, fileName, path + "WEB-INF/classes/", out) != -1) {
			
		}
		out.close();
	}
	
	
}
