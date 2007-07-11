/**
 * 
 */
package meta.library.model.dao;

import meta.library.model.bean.Borrow;

/**
 * @author Biao Zhang
 *
 */
public interface BorrowDao extends GenericDao<Borrow, Integer> {
	public Borrow getByUserAndBook(int uesrId, int bookId);
}
