/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.List;

import meta.codeanywhere.bean.Tag;
import meta.codeanywhere.dao.TagDAO;

import org.hibernate.criterion.Restrictions;

/**
 * @author Biao Zhang
 * @version 11/17/2006
 */
public class TagDAOImpl extends GenericDAOImpl<Tag, Integer, TagDAO> implements TagDAO {

	public Tag getByTagName(String tag) {
		List<Tag> tags = this.getByCriteria(Restrictions.eq("tag", tag));
		if (tags.size() > 0) {
			return tags.get(0);
		}
		
		return null;
	}

}
