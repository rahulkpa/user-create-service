package com.nirsb.account.model;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Users' Contact Related information")
@Component
public class Phone {
	
	private long id;
	
	@NotBlank(message="Primary contact is mandatory")
	@ApiModelProperty("first number required to be contacted in case of emergency")
	private String primaryContact;
	
	@ApiModelProperty("Second number required to be contacted in case of emergency")
	private String secondaryContact;
	
	private User user;

	public Phone() {
		super();
	}
	public Phone(String primaryContact, String secondaryContact) {
		super();
		this.primaryContact = primaryContact;
		this.secondaryContact = secondaryContact;
	}
	public String getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}
	public String getSecondaryContact() {
		return secondaryContact;
	}
	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Phone [primaryContact=" + primaryContact + ", secondaryContact=" + secondaryContact + "]";
	}
}
