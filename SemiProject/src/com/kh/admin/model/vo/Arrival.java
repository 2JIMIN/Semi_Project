package com.kh.admin.model.vo;

public class Arrival {
	private String arrivalCode;//ARRIVAL_CODE VARCHAR2(10) PRIMARY KEY,
	private String arrivalCity;//ARRIVAL_CITY VARCHAR2(30) NOT NULL,
	private String countryCode;//COUNTRY_CODE VARCHAR2(30),
	private String intDomId;//INT_DOM_ID VARCHAR2(1) CHECK(INT_DOM_ID IN('I', 'D'))
	public Arrival() {
		super();
	}
	public Arrival(String arrivalCode, String arrivalCity, String countryCode, String intDomId) {
		super();
		this.arrivalCode = arrivalCode;
		this.arrivalCity = arrivalCity;
		this.countryCode = countryCode;
		this.intDomId = intDomId;
	}
	public String getArrivalCode() {
		return arrivalCode;
	}
	public void setArrivalCode(String arrivalCode) {
		this.arrivalCode = arrivalCode;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getIntDomId() {
		return intDomId;
	}
	public void setIntDomId(String intDomId) {
		this.intDomId = intDomId;
	}
	@Override
	public String toString() {
		return "Arrival [arrivalCode=" + arrivalCode + ", arrivalCity=" + arrivalCity + ", countryCode=" + countryCode
				+ ", intDomId=" + intDomId + "]";
	}
	
	
}
