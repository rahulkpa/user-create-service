package com.nirsb.account.model;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Users' Address Related information")
@Component
public class Address {
	
	private long id;
	
	private String line1;

	private String line2;
	
	private String line3;
	
	@NotBlank(message="City Name is always mandatory")
	@ApiModelProperty("City Name")
	private String cityName;
	
	@NotBlank(message="State Name is always mandatory")
	@ApiModelProperty("State Name if user is from India")
	private String state;
	
	@ApiModelProperty("Country Name")
	private String country;
	
	@NotBlank(message="Pincode is always mandatory")
	@ApiModelProperty("Area pincode/zipCode")
	private String pinCode;
	
	@NotBlank(message="landMark is always mandatory")
	@ApiModelProperty("Near by place")
	private String landMark;
	
	private User user;
	public Address() {
		super();
	}
	public Address(String line1, String line2, String line3, String cityName, String state, String country, String pinCode,
			String landMark,User user) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.cityName = cityName;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
		this.landMark = landMark;
		this.user = user;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getLine3() {
		return line3;
	}
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
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
		return "Address [line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", cityName=" + cityName + ", state="
				+ state + ", country=" + country + ", pinCode=" + pinCode + ", landMark=" + landMark + "]";
	}
}
