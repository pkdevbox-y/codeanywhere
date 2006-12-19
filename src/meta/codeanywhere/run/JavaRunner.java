/**
 * 
 */
package meta.codeanywhere.run;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//import javax.tools.ToolProvider;

/**
 * @author Biao Zhang
 * @date 2006-7-15
 */
public class JavaRunner implements IRun {

	private String className;
	
	private ClassLoader loader;
	
	private Class cls;
	private Object obj;
	private Method method;
	private String[] args;
	
	public JavaRunner(String className) {
		this.className = className;
		//loader = ToolProvider.getSystemToolClassLoader();
		loader = this.getClass().getClassLoader();
		/* attention here */
		args = new String[]{};
	}
	
	public int run() {
		try {
			cls = loader.loadClass(className);
			//cls = Class.forName(className);
			obj = cls.newInstance();
			method = cls.getMethod("main", String[].class);
			method.invoke(obj, (Object)args);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (InstantiationException ie) {
			ie.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (SecurityException se) {
			se.printStackTrace();
		} catch (NoSuchMethodException nme) {
			nme.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (InvocationTargetException ite) {
			ite.printStackTrace();
		}
		return 0;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public InputStream getInputStream() {
		// TODO Auto-generated method stub
		return null;
	}
	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return null;
	}

}
