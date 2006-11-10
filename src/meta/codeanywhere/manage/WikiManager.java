/**
 * 
 */
package meta.codeanywhere.manage;

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
		JSONArray source = new JSONArray();
		for (String tag: tags) {
			JSONObject jsonObject = singleSearch(tag);
			source.put(jsonObject);
		}
		return source;
	}
	
	private JSONObject singleSearch(String tag) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("title", "List");
			jsonObject.put("source", "public class Student {}");
		} catch (JSONException jsone) {
			jsone.printStackTrace();
		}
		return jsonObject;
	}
}
