/**
 * 
 */
package meta.codeanywhere.dao.impl;

import meta.codeanywhere.dao.DAOFactory;
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
}
