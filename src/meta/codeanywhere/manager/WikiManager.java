/**
 * 
 */
package meta.codeanywhere.manager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Biao Zhang
 * @version 11/10/2006
 */
public class WikiManager {
	private static WikiManager instance = null;
	static {
		instance = new WikiManager();
	}
	
	public static WikiManager getInstance() {
		return instance;
	}
	
	public JSONArray search(String...tags) {
		JSONArray result = new JSONArray();
		for (String tag: tags) {
			JSONObject jsonObject = singleSearch(tag);
			result.put(jsonObject);
		}
		return result;
	}
	
	private JSONObject singleSearch(String tag) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("title", "List");
			jsonObject.put("source", "public class Student {\n\tprivate String " + tag + ";\n}");
		} catch (JSONException jsone) {
			jsone.printStackTrace();
		}
		return jsonObject;
	}
	
	public void addToWiki(String source, String...tags) {
		
	}
}
