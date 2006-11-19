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
import javax.servlet.http.HttpSession;

import meta.codeanywhere.bean.User;

/**
 * @author Biao Zhang
 *
 */
public class InitSystemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4187946878740213248L;

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
		PrintWriter out = response.getWriter();
		User u = (User) session.getAttribute("user");
		out.print(u != null);
		out.close();
	}

	
}
