/**
 * 
 */
package meta.codeanywhere.dao.impl;

import java.util.List;

import meta.codeanywhere.bean.SourceFile;
import meta.codeanywhere.dao.SourceFileDAO;

import org.hibernate.criterion.Restrictions;

/**
 * @author Talent
 *
 */
public class SourceFileDAOImpl extends GenericDAOImpl<SourceFile, Integer, SourceFileDAO> implements SourceFileDAO {

	public SourceFile getByFileName(String fileName) {
		List<SourceFile> files = this.getByCriteria(Restrictions.eq("fileName", fileName));
		if (files.size() > 0) {
			return files.get(0);
		}
		
		return null;
	}

}
