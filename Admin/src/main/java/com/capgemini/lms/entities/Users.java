package com.capgemini.lms.entities;

import java.time.LocalDate;
import java.util.Date;  

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileno;
	private String email;
	private LocalDate date_of_birth;
	private LocalDate subscription_date;
	private LocalDate sub_expire_date;
	private String subscription_status;
	
	public Users(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
		super();
	}
	
	public Users(String password, String firstName, String lastName, String mobileno, String email,
			LocalDate date_of_birth, LocalDate subscription_date, LocalDate sub_expire_date, String subscription_status) {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileno = mobileno;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.subscription_date = subscription_date;
		this.sub_expire_date = sub_expire_date;
		this.subscription_status = subscription_status;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public LocalDate getSubscription_date() {
		return subscription_date;
	}
	public void setSubscription_date(LocalDate subscription_date) {
		this.subscription_date = subscription_date;
	}
	public LocalDate getSub_expire_date() {
		return sub_expire_date;
	}
	public void setSub_expire_date(LocalDate sub_expire_date) {
		this.sub_expire_date = sub_expire_date;
	}
	public String getSubscription_status() {
		return subscription_status;
	}
	public void setSubscription_status(String subscription_status) {
		this.subscription_status = subscription_status;
	}
}