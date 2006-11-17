/**
 * 
 */
package meta.codeanywhere.dao.impl;

import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.SourceFileDAO;
import meta.codeanywhere.dao.TagDAO;
import meta.codeanywhere.dao.UserDAO;
import meta.codeanywhere.dao.VirtualAbstractFileDAO;
import meta.codeanywhere.dao.VirtualBinaryFileDAO;
import meta.codeanywhere.dao.VirtualFileDAO;
import meta.codeanywhere.dao.VirtualFolderDAO;
import meta.codeanywhere.dao.VirtualTextFileDAO;
import meta.codeanywhere.util.HibernateSessionUtil;

/**
 * @author Biao Zhang
 * @date 2006-6-27
 */
public class DAOFactoryImpl implements DAOFactory {

	public VirtualFolderDAO getVirtualFolderDAO() {
		VirtualFolderDAO virtualFolderDAO = new VirtualFolderDAOImpl().setSession(HibernateSessionUtil.currentSession());
		return virtualFolderDAO;
	}

	public VirtualFileDAO getVirtualFileDAO() {
		VirtualFileDAO virtualFileDAO = new VirtualFileDAOImpl().setSession(HibernateSessionUtil.currentSession());
		return virtualFileDAO;
	}

	public VirtualAbstractFileDAO getVirtualAbstractFileDAO() {
		VirtualAbstractFileDAO virtualAbstractFileDAO = new VirtualAbstractFileDAOImpl().setSession(HibernateSessionUtil.currentSession());
		return virtualAbstractFileDAO;
	}

	public VirtualBinaryFileDAO getVirtualBinaryFileDAO() {
		VirtualBinaryFileDAO virtualBinaryFileDAO = new VirtualBinaryFileDAOImpl().setSession(HibernateSessionUtil.currentSession());
		return virtualBinaryFileDAO;
	}

	public VirtualTextFileDAO getVirtualTextFileDAO() {
		VirtualTextFileDAO virtualTextFileDAO = new VirtualTextFileDAOImpl().setSession(HibernateSessionUtil.currentSession());
		return virtualTextFileDAO;
	}

	public SourceFileDAO getSourceFileDAO() {
		SourceFileDAO sourceFileDAO = new SourceFileDAOImpl().setSession(HibernateSessionUtil.currentSession());
		return sourceFileDAO;
	}

	public TagDAO getTagDAO() {
		TagDAO tagDAO = new TagDAOImpl().setSession(HibernateSessionUtil.currentSession());
		return tagDAO;
	}

	public UserDAO getUserDAO() {
		UserDAO userDAO = new UserDAOImpl().setSession(HibernateSessionUtil.currentSession());
		return userDAO;
	}
}
