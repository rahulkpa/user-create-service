package com.nirsb.account.model.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private long addressId;
	@Column(name = "LINE_1")
	private String line1;
	@Column(name = "LINE_2")
	private String line2;
	@Column(name = "LINE_3")
	private String line3;
	@Column(name = "CITY_NAME")
	private String cityName;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COUNTRY_NAME")
	private String country;
	
	@Column(name = "ZIP_CODE")
	private String pinCode;
	
	@Column(name = "LAND_MARK")
	private String landMark;

	public Address() {
		super();
	}
	public Address(String line1, String line2, String line3, String cityName, String state, String country, String pinCode,
			String landMark) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.cityName = cityName;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
		this.landMark = landMark;
		
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

	@Override
	public String toString() {
		return "Address [line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", cityName=" + cityName + ", state="
				+ state + ", country=" + country + ", pinCode=" + pinCode + ", landMark=" + landMark + "]";
	}
}
