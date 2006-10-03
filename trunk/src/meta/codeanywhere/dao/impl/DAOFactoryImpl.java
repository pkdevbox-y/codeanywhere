/**
 * 
 */
package meta.codeanywhere.dao.impl;

import meta.codeanywhere.dao.DAOFactory;
import meta.codeanywhere.dao.VirtualFileDAO;
import meta.codeanywhere.dao.VirtualFolderDAO;
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
}
