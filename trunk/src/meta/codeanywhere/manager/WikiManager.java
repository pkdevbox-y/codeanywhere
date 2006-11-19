/**
 * 
 */
package meta.codeanywhere.manager;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import meta.codeanywhere.bean.SourceFile;
import meta.codeanywhere.bean.Tag;
import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.TagDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Biao Zhang
 * @version 11/10/2006
 */
public class WikiManager {
	private static WikiManager manager = null;
	static {
		manager = new WikiManager();
	}
	
	public static WikiManager getManager() {
		return manager;
	}
	private TagDAO tagDAO = null;
	
	private WikiManager() {
		tagDAO = DAOFactory.DEFAULT.getTagDAO();
	}
	
	public JSONArray search(String...tags) {
		JSONArray result = new JSONArray();
		for (String tag: tags) {
			JSONObject[] results = singleSearch(tag);
			if (results != null) {
				for (JSONObject r: results) {
					result.put(r);
				}
			}
		}
		return result;
	}
	
	private JSONObject[] singleSearch(String tag) {
		List<JSONObject> list = new LinkedList<JSONObject>();
		List<Tag> tags = tagDAO.getByTagName(tag);
		if(tags == null) {
			return null;
		}
		SourceFile file = null;
		try {
			for (Tag t: tags) {
				file = t.getFile();
				JSONObject jsonObject = new JSONObject();
				System.out.println(file.getFileName());
				jsonObject.put("title", file.getFileName());
				jsonObject.put("source", file.getSourceText());
				list.add(jsonObject);
			}
		} catch (JSONException jsone) {
			jsone.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return list.toArray(new JSONObject[0]);
	}
	
	public void addToWiki(String source, String...tags) {
		
	}
}
