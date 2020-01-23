package net.GoodReads.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "readed_books")
public class ReadedBooks {
	private Integer id;
	private Integer user_id;
	private Integer book_id;
	private String readed_year;
	private Integer rate;
	private String comment;
	private Integer count;
	private Integer avgrate;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "readed_books", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "id"))

	private String name;
	private String author;
	private String translator;
	private String publisher;
	private String published;

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "translator")
	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	@Column(name = "publisher")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "published")
	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public ReadedBooks() {

	}

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "readed_books", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id"))
//	private List<Users> users= new ArrayList<Users>();
//	
//	private String user_name;
//	private String surname;
//
//
//	@Column(name = "user_name")
//	public String getUser_name() {
//		return user_name;
//	}
//
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}
//
//	@Column(name = "surname")
//	public String getSurname() {
//		return surname;
//	}
//
//	public void setSurname(String surname) {
//		this.surname = surname;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Column(name = "book_id")
	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	@Column(name = "readed_year")
	public String getReaded_year() {
		return readed_year;
	}

	public void setReaded_year(String readed_year) {
		this.readed_year = readed_year;
	}

	@Column(name = "rate")
	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
//
	@Column(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "avgrate")
	public Integer getAvgrate() {
		return avgrate;
	}

	public void setAvgrate(Integer avgrate) {
		this.avgrate = avgrate;
	}
//
	
}
