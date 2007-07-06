/**
 * 
 */
package meta.library.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.library.model.bean.Book;
import meta.library.model.bean.User;
import meta.library.model.service.BookManager;
import meta.library.model.service.BorrowManager;
import meta.library.model.service.UserManager;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Biao Zhang
 *
 */
public class BorrowAction extends MetaAction<BorrowManager> {
	
	private UserManager userManager;
	private BookManager bookManager;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
		
	}
	
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}
	
	/* (non-Javadoc)
	 * @see meta.library.controller.action.MetaAction#executeMeta(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ActionForward executeMeta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}

	public ActionForward borrow(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward;
		
		String book = request.getParameter("book");
		String user = request.getParameter("user");
		
		if (book == null || user == null) {
			List<Book> booklist = bookManager.findAll();
			request.setAttribute("booklist", booklist);
			
			List<User> userlist = userManager.findAll();
			request.setAttribute("userlist", userlist);
			
			forward = mapping.findForward("borrow");
		} else {
			int bookId = Integer.parseInt(book);
			int userId = Integer.parseInt(user);
			
			manager.borrowBook(userId, bookId);
			
			request.setAttribute("message", "Successful borrow the book!");
			request.setAttribute("url", "borrow.do?method=borrow");
			
			forward = mapping.findForward("complete");
			
		}
		return forward;
	}
}