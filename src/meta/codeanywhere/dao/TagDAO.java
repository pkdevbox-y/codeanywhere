/**
 * 
 */
package meta.codeanywhere.dao;

import java.util.List;

import meta.codeanywhere.bean.Tag;

/**
 * @author Biao Zhang
 * @version 11/17/2006
 */
public interface TagDAO extends GenericDAO<Tag, Integer> {
	public List<Tag> getByTagName(String tag);
}
