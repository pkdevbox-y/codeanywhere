/**
 * 
 */
package meta.library.model.bean;

import java.sql.Blob;

/**
 * @author Biao Zhang
 *
 */
public class Book {

	private Integer id = null;
	private String title = null;
	private String author;
	private String isbn;
	private String catalog;
	private String description;
	
	private Blob cover;
	
	public Book() {
		
	}
	
	public Book(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public Book(String title, String author, String isbn,
			String catalog, String description) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.catalog = catalog;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getCover() {
		return cover;
	}

	public void setCover(Blob cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.title;
	}
}
