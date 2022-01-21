package com.nirsb.account.model.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "PHONE")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PHONE_ID")
	private long phoneId;
	@Column(name="PRIMARY_CONTACT")
	private String primaryContact;
	@Column(name="SECONDARY_CONTACT")
	private String secondaryContact;
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
	@Override
	public String toString() {
		return "Phone [primaryContact=" + primaryContact + ", secondaryContact=" + secondaryContact + "]";
	}
}
