/**
 * 
 */
package meta.library.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meta.library.model.bean.User;
import meta.library.model.service.UserManager;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Biao Zhang
 *
 */
public class UserAction extends MetaAction<UserManager> {

	/* (non-Javadoc)
	 * @see meta.library.action.MetaAction#executeMeta(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ActionForward executeMeta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		User u = (User) request.getSession().getAttribute("user");
		PrintWriter out = response.getWriter();
		if (u != null) {
			out.println(u.getUsername());
			out.println(u.getPassword());	
		} else {
			out.println("No user in session");
		}
		
		return null;
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		ActionForward forward = null;
		
		if (user != null) {
			forward = mapping.findForward("success");
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (username == null || password == null) {
				forward = mapping.findForward("login");
			} else {
				user = manager.getByUsername(username);
				if (user != null && password.compareTo(user.getPassword()) == 0) {
					session.setAttribute("user", user);
					forward = mapping.findForward("success");
				} else {
					forward = mapping.findForward("login");
				}
			}
		}
		return forward;
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}
		return mapping.findForward("index");
	}
	
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		ActionForward forward = null;
		
		if (user != null) {
			forward = mapping.findForward("index");
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			
			if (username == null || password == null || email == null) {
				forward = mapping.findForward("register");
			} else {
				user = manager.registerUser(username, password, email);
				if (user != null) {
					session.setAttribute("user", user);
					forward = mapping.findForward("index");
				} else {
					forward = mapping.findForward("register");
				}
			}
		}
		return forward;
	}
	
}
