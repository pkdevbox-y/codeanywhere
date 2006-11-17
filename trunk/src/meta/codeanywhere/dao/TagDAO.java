/**
 * 
 */
package meta.codeanywhere.dao;

import meta.codeanywhere.bean.Tag;

/**
 * @author Biao Zhang
 * @version 11/17/2006
 */
public interface TagDAO extends GenericDAO<Tag, Integer> {
	public Tag getByTagName(String tag);
}
