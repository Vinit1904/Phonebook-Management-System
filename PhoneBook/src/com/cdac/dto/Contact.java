package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {

	@Id
	@Column(name="contact_id")
	@GeneratedValue
	private int contactId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="primary_num")
	private String primaryNum;
	
	@Column(name="secondary_num")
	private String secondaryNum;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="label")
	private String label;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	public Contact() {
		
	}
	

	public Contact(int contactId) {
		
		this.contactId = contactId;
	}


	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	public String getPrimaryNum() {
		return primaryNum;
	}


	public void setPrimaryNum(String primaryNum) {
		this.primaryNum = primaryNum;
	}


	public String getSecondaryNum() {
		return secondaryNum;
	}


	public void setSecondaryNum(String secondaryNum) {
		this.secondaryNum = secondaryNum;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name + ", city=" + city + ", primaryNum=" + primaryNum
				+ ", secondaryNum=" + secondaryNum + ", emailId=" + emailId + ", label=" + label + "]";
	}
		
}
