package com.nirsb.account.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "It contains users Information")
@Component
public class User {
	
	private long userId;
	
	@NotBlank(message="first name is mandatory")
	private String firstName;
	
	@NotBlank(message="middle name is mandatory")
	private String middleName;
	
	@NotBlank(message="last name is mandatory")
	private String lastName;
	
	@NotBlank(message="email id is mandatory")
	@Email(message="Please enter a valid email id")
	@ApiModelProperty(notes = "users' emailId for mail correspondence")
	private String emailId;
	
	@NotBlank(message="gender is mandatory")
	@ApiModelProperty(notes = "users' marital status")
	private String gender;
	
	@ApiModelProperty(notes = "This property means user is working or not")
	private String isEmployed;
	
	@ApiModelProperty(notes = "Company/Department name where user works")
	private String employerName;
	
	@ApiModelProperty(notes = "users' marital status")
	private String marriedStatus;

	@Size(min = 10, max = 10,message = "Enter a valid mobile number")
	private Phone phone;
	
	private List<Address> addresses;
	
	
	public User() {
		super();
	}

	public User(long userId, String firstName, String middleName, String lastName, String emailId, String isEmplyed,
			String employerName, String marriedStatus, String gender,Phone phone,List<Address> addresses) {
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
		return "User [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", gender=" + gender + ", isEmployed=" + isEmployed
				+ ", employerName=" + employerName + ", marriedStatus=" + marriedStatus + ", phone=" + phone
				+ ", addresses=" + addresses + "]";
	}
	
	
}
