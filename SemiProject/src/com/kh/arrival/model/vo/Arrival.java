package com.kh.arrival.model.vo;

public class Arrival {
	
	private String arrivalCode;
	private String arrivalCity;
	private String countryCode;
	private String intDomId;
	
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
	public Arrival(String arrivalCity) {
		this.arrivalCity = arrivalCity;
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
