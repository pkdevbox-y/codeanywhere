/**
 * The class loader in Tomcat Env
 */
package meta.codeanywhere.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.tools.ToolProvider;

/**
 * @author Biao Zhang
 * @date 2006-7-16
 */
public class ClassLoaderServlet extends HttpServlet {

	/**
	 * generated serial ID
	 */
	private static final long serialVersionUID = -6344708431684230408L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		try {
			//Class cls = Class.forName("SampleClass");						// work
			//ClassLoader loader = ToolProvider.getSystemToolClassLoader();	// don't work
			ClassLoader loader = this.getClass().getClassLoader();
			Class cls = loader.loadClass("meta.codeanywhere.test.SampleClass");
			Object obj = cls.newInstance();
			Method mthd = cls.getMethod("setWriter", PrintWriter.class);
			mthd.invoke(obj, out);
			
			mthd = cls.getMethod("showMessage");
			mthd.invoke(obj);
			out.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (InstantiationException ie) {
			ie.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (SecurityException se) {
			se.printStackTrace();
		} catch (NoSuchMethodException nsme) {
			nsme.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (InvocationTargetException ite) {
			ite.printStackTrace();
		}
	}

}
