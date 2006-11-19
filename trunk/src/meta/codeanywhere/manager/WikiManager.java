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
import meta.codeanywhere.dao.SourceFileDAO;
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
	private SourceFileDAO fileDAO = null;
	private WikiManager() {
		tagDAO = DAOFactory.DEFAULT.getTagDAO();
		fileDAO = DAOFactory.DEFAULT.getSourceFileDAO();
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
				jsonObject.put("title", file != null ? file.getFileName() : tag);
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
	
	public void addToWiki(String fileName, String source, String...tags) {
		for (String tag: tags) {
			addSingleTag(fileName, source, tag.trim());
		}
		
	}
	
	private void addSingleTag(String fileName, String source, String tagString) {
		SourceFile file = fileDAO.getByFileName(fileName);
		Tag tag = new Tag();
		tag.setFile(file);
		tag.setTag(tagString);
		tagDAO.makePersistent(tag);
	}
}
