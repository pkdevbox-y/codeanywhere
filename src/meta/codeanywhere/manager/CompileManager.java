/**
 * @(#)CompileManager.java
 */
package meta.codeanywhere.manager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import meta.codeanywhere.compile.JavaCompiler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The CompileManager process all the request to compile a sourse file.
 * 
 * @author Biao Zhang
 * @version 11/10/2006
 */
public class CompileManager {
	private static CompileManager manager = null;
	static {
		manager = new CompileManager();
	}

	public static CompileManager getManager() {
		return manager;
	}
	public String compile(String path, String fileName, String source) {
		StringBuffer buffer = new StringBuffer();
		FileWriter fw = null;
		try {
			fw = new FileWriter(path + "WEB-INF/classes/" + fileName + ".java");
			fw.write(source);
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JavaCompiler javaCompiler = new JavaCompiler();
		javaCompiler.addSourceFile(path + "WEB-INF/classes/" + fileName + ".java");
		//javaCompiler.addSourceFile(path + "WEB-INF/classes/" + fileName + ".java", source);
		javaCompiler.compile();
		
		List<Diagnostic<? extends JavaFileObject>> diagnosticList = javaCompiler.getDiagnostics();
		JSONObject jsonObject = new JSONObject();
		
		try {
			if (diagnosticList.size() > 0) {
				JSONArray jsonArray = new JSONArray();
				for (Diagnostic<? extends JavaFileObject> diagnostic: diagnosticList) {
					JSONObject jsonWarning  = new JSONObject();
					jsonWarning.put("line", new Long(diagnostic.getLineNumber()).toString());
					jsonWarning.put("message", diagnostic.getMessage(Locale.ENGLISH));
					jsonArray.put(jsonWarning);
				}
				jsonObject.put("length", jsonArray.length());
				jsonObject.put("status", "failed");
				jsonObject.put("info", jsonArray.toString());
			} else {
				JSONArray result = ReflectManager.getManager().getFieldsAndMethods(fileName);
				jsonObject.put("fileName", fileName);
				jsonObject.put("length", result.length());
				jsonObject.put("status", "succeed");
				jsonObject.put("info", result.toString());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buffer.append(jsonObject.toString());		
		return buffer.toString();
	}
	
	public String _compile(String path, String fileName, String source) {
		StringBuffer buffer = new StringBuffer();
		FileWriter fw = null;
		try {
			fw = new FileWriter(path + "WEB-INF/classes/" + fileName + ".java");
			fw.write(source);
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JavaCompiler javaCompiler = new JavaCompiler();
		javaCompiler.addSourceFile(path + "WEB-INF/classes/" + fileName + ".java");
		//javaCompiler.addSourceFile(path + "WEB-INF/classes/" + fileName + ".java", source);
		javaCompiler.compile();
		
		List<Diagnostic<? extends JavaFileObject>> diagnosticList = javaCompiler.getDiagnostics();
		if (diagnosticList.size() > 0) {
			for (Diagnostic<? extends JavaFileObject> diagnostic: diagnosticList) {
				buffer.append(diagnostic.getMessage(Locale.ENGLISH));
			}
		}
		return buffer.toString();
	}
}
