package com.demo.restweb.pojo;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@XmlRootElement
//@Entity
//@Document(value)
public class Customer{
	
	@Id
	private ObjectId id;
	//@Id
	private int customerId;
	private String customerName;
	private Long contactNumber;
	private String emailId;
	private String dateOfBirth;
	private String url;
	
	/*private static int custId;
	
	static {
		custId = 200;
	}*/
	/*
	{
		this.customerId = ++custId;
	}*/
	
	public Customer() {
		
	}

	public Customer(int customerId,String customerName, Long contactNumber, String emailId, String dateOfBirth,String url) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.url = url;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", url=" + url + "]";
	}



}

