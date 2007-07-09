/**
 * 
 */
package meta.library.controller.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.library.model.bean.ActionResultMessage;
import meta.library.model.bean.Book;
import meta.library.model.service.BookManager;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Biao Zhang
 * 
 */
public class BookAction extends MetaAction<BookManager> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see meta.library.action.MetaAction#executeMeta(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ActionForward executeMeta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		out.print(manager.findById(1).getTitle());
		return null;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward;

		List<Book> booklist = manager.findAll();
		request.setAttribute("booklist", booklist);

		forward = mapping.findForward("list");
		return forward;
	}
	
	public ActionForward info(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward;

		String bookIdStr = request.getParameter("id");
		String bookTitle = request.getParameter("title");
		Book book = null;
		
		if (bookIdStr != null || bookTitle != null) {
			if (bookIdStr != null) {
				int bookId = Integer.parseInt(bookIdStr);
				book = manager.findById(bookId);
				request.setAttribute("book", book);
			} else {
				book = manager.getByTitle(bookTitle);
				request.setAttribute("book", book);
			}
		} 
		
		if (book != null) {
			forward = mapping.findForward("info");
		} else {
			ActionResultMessage actionResultMessage = new ActionResultMessage();
			actionResultMessage.setMessage("Can not find the book!");
			actionResultMessage.setUrl("book.do?method=list");
		
			request.setAttribute("actionResultMessage", actionResultMessage);
		
			forward = mapping.findForward("error");
		}
		
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;

		String title = null;
		String author = null;
		String press = null;
		String isbn = null;
		String catalog = null;
		String description = null;
		
		InputStream cover = null;
		
		ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory(512, new File("C:/Users/Talent/workspace_wtp/MetaLibrary/WebContent/temp")));
		try {
			List<FileItem> files = fileUpload.parseRequest(request);
			for (FileItem file : files) {
				if (file.getFieldName().equals("cover")) {
					cover = file.getInputStream();
				} else if(file.getFieldName().equals("title")) {
					title = file.getString();
				} else if(file.getFieldName().equals("author")) {
					author = file.getString();
				} else if(file.getFieldName().equals("press")) {
					press = file.getString();
				} else if(file.getFieldName().equals("isbn")) {
					isbn = file.getString();
				} else if(file.getFieldName().equals("catalog")) {
					catalog = file.getString();
				} else if(file.getFieldName().equals("description")) {
					description = file.getString();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		/*
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String catalog = request.getParameter("catalog");
		String description = request.getParameter("description");
		*/

		if (title == null || author == null || isbn == null) {
			forward = mapping.findForward("add");
		} else {
			manager.addBook(title, author, press, isbn, catalog, description, cover);

			forward = this.list(mapping, form, request, response);
		}

		return forward;
	}
	
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward;
		String search = request.getParameter("search");
		
		if (search != null && search.length() > 0) {
			List<Book> booklist = manager.search(search);
			request.setAttribute("booklist", booklist);

			forward = mapping.findForward("list");
		} else {
			forward = mapping.findForward("index");
		}
		
		return forward;
	}

}
