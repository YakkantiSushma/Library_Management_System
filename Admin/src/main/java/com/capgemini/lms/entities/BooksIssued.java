package com.capgemini.lms.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BooksIssued1")
public class BooksIssued {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int issueId;

	@OneToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private Users users;
	
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="book_id")
	private Books books;
	
	private LocalDate issueDate;
	private int quantity;
	private LocalDate dueDate;
	
	
	public BooksIssued(Users users, Books books, LocalDate issueDate, int quantity, LocalDate dueDate) {
		this.users = users;
		this.books = books;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
	}
	public BooksIssued() {
		super();
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "BooksIssued [issueId=" + issueId + ", users=" +users + ", books=" + books + ", issueDate=" + issueDate
				+ ", quantity=" + quantity + ", dueDate=" + dueDate + "]";
	}
	
	
}