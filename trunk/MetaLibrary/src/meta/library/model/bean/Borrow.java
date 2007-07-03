/**
 * 
 */
package meta.library.model.bean;

import java.util.Date;

/**
 * @author Biao Zhang
 *
 */
public class Borrow {
	private Integer id;
	private User user;
	private Book book;
	private Date date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
