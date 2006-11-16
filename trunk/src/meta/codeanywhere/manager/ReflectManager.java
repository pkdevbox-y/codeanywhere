/**
 * @(#)ReflectManager.java
 */
package meta.codeanywhere.manager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Biao Zhang
 * @version 11/16/2006
 */
public class ReflectManager {
	private static ReflectManager manager = null;
	static {
		manager = new ReflectManager();
	}
	public static ReflectManager getManager() {
		return manager;
	}
	private ReflectManager() {
		
	}

	public JSONArray getFieldsAndMethods(String className) {
		Class clazz = null;
		JSONArray jsonArray = new JSONArray();
		try {
			clazz = Class.forName(className);
			Field[] fields = clazz.getDeclaredFields();
			Method[] methods = clazz.getDeclaredMethods();
			try {
				for (Field field : fields) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("kind", "Field");
					jsonObject.put("name", field.getName());
					jsonObject.put("type", field.getType().getName());
					jsonObject.put("modifier", field.getModifiers());
					jsonArray.put(jsonObject);
				}
				
				for (Method method: methods) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("kind", "Method");
					jsonObject.put("name", method.getName());
					jsonObject.put("type", method.getReturnType().getName());
					jsonObject.put("parameterList", method.getParameterTypes());
					jsonArray.put(jsonObject);
				}
			} catch (JSONException jsone) {
				jsone.printStackTrace();
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			jsonArray = null;
		}
		return jsonArray;
	}
	
	public static void main(String[] args) {
		ReflectManager rm = ReflectManager.getManager();
		System.out.println(rm.getFieldsAndMethods("Student"));
	}
}
