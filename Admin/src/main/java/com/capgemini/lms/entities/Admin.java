package com.capgemini.lms.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Admin10")
public class Admin
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "book_id")
//	private List<Books> books;
//
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
//	private List<DamagedBooks> damagedBooks;
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
//	private List<BooksOrder> BooksOrder;
//	
//    @OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
//	private List<Publishers> publishers;
//
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid")
//	private List<Users> users;

//
//	public List<Books> getBooks() {
//		return books;
//	}
//
//	public void setBooks(List<Books> books) {
//		this.books = books;
//	}

	public Admin() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String fname, String lname, String email, String password) {
	
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	
	}

}