package com.capgemini.lms.entities;

import javax.persistence.*;

@Entity
@Table(name = "publishers")
public class Publishers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int publisherid;
	private String publisherName;
	private String contactno;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int pincode;
	
	public Publishers() {
		super();
	}
	
	public Publishers(String publisherName, String contactno, String email, String address1,
			String address2, String city, String state, int pincode) {
		this.publisherName = publisherName;
		this.contactno = contactno;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getPublisherid() {
		return publisherid;
	}

	public void setPublisherid(int publisherid) {
		this.publisherid = publisherid;
	}
	
}