package com.capgemini.lms.entities;

import java.time.LocalDate;
import java.util.Date; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private Users user;
	private LocalDate FeedbackDate;
	private String description;
	private String rating;
	private String comments;
	
	public Feedback() {
		super();
	}
	
	public Feedback(Users user, LocalDate feedbackDate, String description, String rating, String comments) {
		
		this.user = user;
		this.FeedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}

	public int getId() {
		return id;
	} 
	
	public void setId(int id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
	
	public LocalDate getFeedbackDate() {
		return FeedbackDate;
	}
	
	public void setFeedbackDate(LocalDate feedbackDate) {
		this.FeedbackDate = feedbackDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
}