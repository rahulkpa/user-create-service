package com.nirsb.account.model.dto;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private long userId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "IS_EMPLOYED")
	private String isEmployed;
	@Column(name = "EMPLOYER_NAME")
	private String employerName;
	@Column(name = "MARRITAL_STATUS")
	private String marriedStatus;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_phone",joinColumns = @JoinColumn(name = "USER_ID"))
	private Phone phone;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_address",joinColumns = @JoinColumn(name = "USER_ID"))
	private List<Address> addresses;
	@Column(name = "ADREESS_NUMBER")
	private long addressNumber;
	 public long getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(long addressNumber) {
		this.addressNumber = addressNumber;
	}

	
	
	public User() {
		super();
	}

	public User(long userId, String firstName, String middleName, String lastName, String emailId, String isEmplyed,
			String employerName, String marriedStatus, String gender,Phone phone,List<Address> addresses, long addressNumber) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.isEmployed = isEmplyed;
		this.employerName = employerName;
		this.marriedStatus = marriedStatus;
		this.gender = gender;
		this.userId = userId;
		this.phone = phone;
		this.addresses = addresses;
		this.addressNumber = addressNumber;
	}
	
	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getIsEmployed() {
		return isEmployed;
	}

	public String getMarriedStatus() {
		return marriedStatus;
	}
	public void setMarriedStatus(String marriedStatus) {
		this.marriedStatus = marriedStatus;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getIsEmplyed() {
		return isEmployed;
	}
	public void setIsEmployed(String isEmplyed) {
		this.isEmployed = isEmplyed;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", gender=" + gender + ", isEmplyed=" + isEmployed + ", employerName=" + employerName
				+ ", marriedStatus=" + marriedStatus + "]";
	}
	
}
