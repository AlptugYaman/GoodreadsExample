package net.GoodReads.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	private Integer id;
	private String name;
	private String author;
	private String translator;
	private String publisher;
	private String published;

	public Books() {

	}

	@ManyToMany
	@JoinColumn(name="book_id")
	private Books books;	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Column(name="author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

//	@Column(name="translator")
	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

//	@Column(name="publisher")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

//	@Column(name="published")
	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

}
