/**
 * 
 */
package meta.library.model.bean;

import java.sql.Blob;

/**
 * @author Biao Zhang
 *
 */
public class BookCover {

	private Integer id;
	private Blob cover;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Blob getCover() {
		return cover;
	}
	public void setCover(Blob cover) {
		this.cover = cover;
	}
	
}
