/**
 * 
 */
package meta.library.view.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Biao Zhang
 *
 */
public class LoginForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4842730617357121049L;
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.username = null;
		this.password = null;
	}

}
