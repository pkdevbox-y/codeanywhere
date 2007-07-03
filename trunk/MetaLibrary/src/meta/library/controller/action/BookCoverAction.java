/**
 * 
 */
package meta.library.controller.action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.library.model.bean.BookCover;
import meta.library.model.dao.BookCoverDao;
import meta.library.model.service.BookManager;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Biao Zhang
 *
 */
public class BookCoverAction extends MetaAction<BookManager> {

	/* (non-Javadoc)
	 * @see meta.library.controller.action.MetaAction#executeMeta(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ActionForward executeMeta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String bookIdStr = request.getParameter("id");
		if (bookIdStr == null) {
			return mapping.findForward("noimage");
		}
		
		int bookId = Integer.parseInt(bookIdStr);
		InputStream cover = manager.getBookCover(bookId);
		
		if (cover == null) {
			return mapping.findForward("noimage");
		}
		
		response.setContentType("image/gif");
		
		ServletOutputStream out = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len;
		
		while ((len = cover.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		
		out.close();
		cover.close();
		return null;
	}

}
