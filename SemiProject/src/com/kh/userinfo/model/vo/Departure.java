package com.kh.userinfo.model.vo;

public class Departure {
	private String depCode;//DEP_CODE VARCHAR2(10) PRIMARY KEY,
	private String depCity;//DEP_CITY VARCHAR2(30) NOT NULL
	public Departure() {
		super();
	}
	public Departure(String depCode, String depCity) {
		super();
		this.depCode = depCode;
		this.depCity = depCity;
	}
	public String getDepCode() {
		return depCode;
	}
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	@Override
	public String toString() {
		return "Departure [depCode=" + depCode + ", depCity=" + depCity + "]";
	}
	
	
}
