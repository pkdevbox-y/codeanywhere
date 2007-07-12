/**
 * 
 */
package meta.library.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.library.model.bean.ActionResultMessage;
import meta.library.model.bean.Book;
import meta.library.model.bean.Borrow;
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
			Borrow borrow = manager.borrowBook(userId, bookId);
			if (borrow != null) {
				ActionResultMessage actionResultMessage = new ActionResultMessage();
				actionResultMessage.setMessage("Successful borrow the book!, and borrow id is: " + borrow.getId());
				actionResultMessage.setUrl("borrow.do?method=borrow");
			
				request.setAttribute("actionResultMessage", actionResultMessage);
			
				forward = mapping.findForward("complete");
			} else {
				ActionResultMessage actionResultMessage = new ActionResultMessage();
				actionResultMessage.setMessage("Can not borrow the book!");
				actionResultMessage.setUrl("borrow.do?method=borrow");
			
				request.setAttribute("actionResultMessage", actionResultMessage);
			
				forward = mapping.findForward("error");
			}
			
		}
		return forward;
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward;
		List<Borrow> borrowlist = manager.findAll();
		request.setAttribute("borrowlist", borrowlist);
		forward = mapping.findForward("list");
		return forward;
	}
	
	public ActionForward returnBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward;
		String borrowIdStr = request.getParameter("borrowid");
		
		if (borrowIdStr != null) {
			int borrowId = Integer.parseInt(borrowIdStr);
			if (manager.returnBook(borrowId)) {
				ActionResultMessage actionResultMessage = new ActionResultMessage();
				actionResultMessage.setMessage("Successful return the book!");
				actionResultMessage.setUrl("borrow.do?method=returnBook");
			
				request.setAttribute("actionResultMessage", actionResultMessage);
			
				forward = mapping.findForward("complete");
			} else {
				ActionResultMessage actionResultMessage = new ActionResultMessage();
				actionResultMessage.setMessage("Can not return the book!");
				actionResultMessage.setUrl("borrow.do?method=returnBook");
			
				request.setAttribute("actionResultMessage", actionResultMessage);
			
				forward = mapping.findForward("error");
			}
		} else {
			forward = mapping.findForward("return");
		}
		return forward;
	}
}
