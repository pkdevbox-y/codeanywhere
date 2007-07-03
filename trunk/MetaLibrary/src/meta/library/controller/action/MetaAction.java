/**
 * 
 */
package meta.library.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.library.model.service.BaseManager;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * 
 * @author Biao Zhang
 *
 */
public abstract class MetaAction<Manager extends BaseManager> extends DispatchAction {

	protected Manager manager;
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	protected abstract ActionForward executeMeta(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
            throws IOException, ServletException;
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param method
	 * @return
	 */
	protected ActionForward checkPermission(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response,
			String method) {
		
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#dispatchMethod(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String)
	 */
	@Override
	protected ActionForward dispatchMethod(ActionMapping mapping, 
			ActionForm form,
			HttpServletRequest request, 
			HttpServletResponse response,
			String method) throws Exception {

		ActionForward permission = checkPermission(mapping, form, request, response, method);

		if(permission != null) {
			return permission;
		} else {
			ActionForward forward = super.dispatchMethod(mapping, form, request, response, method);
			return forward;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
		String method = null;
		
		if (isCancelled(request)) {
            ActionForward cancelledForward = cancelled(mapping, form, request, response);
            if (cancelledForward != null) {
                return cancelledForward;
            }
        }
		response.setHeader("Content-Type","text/html;charset=UTF-8");
        // Identify the request parameter containing the method name
        String parameter = mapping.getParameter();
        if(parameter != null)
        	// Get the method's name. This could be overridden in subclasses.
        	method = this.getMethodName(mapping, form, request, response, parameter);
        else
        	method = null;
        
        // Prevent recursive calls
        if ("execute".equals(method) || "perform".equals(method)){
        	String message = messages.getMessage("dispatch.recursive", mapping.getPath());
        	log.error(message);
        	throw new ServletException(message);
        }
        
		ActionForward permission = checkPermission(mapping, form, request, response, method);
		if (permission != null) {
			return permission;
		} else {
			ActionForward forward = null;
			
			if (method == null){
				forward = this.executeMeta(mapping, form, request, response);
			} else {
				forward = dispatchMethod(mapping, form, request, response, method);
			}
			return forward;
		}
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
