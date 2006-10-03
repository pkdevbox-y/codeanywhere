/**
 * Methods to get DAOs
 */
package meta.codeanywhere.dao;

import meta.codeanywhere.dao.impl.DAOFactoryImpl;


/**
 * @author Biao Zhang
 * @date 2006-6-27
 *
 */
public interface DAOFactory {
	public static final DAOFactory HIBERNATE = new DAOFactoryImpl();
	public static final DAOFactory DEFAULT = HIBERNATE;
	
	public VirtualFolderDAO getVirtualFolderDAO();
	public VirtualFileDAO getVirtualFileDAO();
}
