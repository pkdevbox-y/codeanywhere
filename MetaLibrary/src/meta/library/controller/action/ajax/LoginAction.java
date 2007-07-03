/**
 * 
 */
package meta.library.controller.action.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.library.controller.action.MetaAction;
import meta.library.model.bean.User;
import meta.library.model.service.UserManager;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Biao Zhang
 *
 */
public class LoginAction extends MetaAction<UserManager> {

	@Override
	protected ActionForward executeMeta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = manager.getByUsername(username);
		PrintWriter out = response.getWriter();
		if (user != null && user.getPassword().compareTo(password) == 0) {
			out.print("true");
		} else {
			out.print("false");
		}
		return null;
	}

}
