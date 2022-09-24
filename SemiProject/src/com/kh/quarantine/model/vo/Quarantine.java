package com.kh.quarantine.model.vo;

import java.util.Date;

public class Quarantine {
	
	private String countryCode;
	private String depVyPcr;
	private String depVnPcr;
	private String arrVyPcr;
	private String arrVnPcr;
	private String arrVySelf;
	private String arrVnSelf;
	private Date updateDate;
	private String countryKor; /*해당 변수는 Quarantine 테이블에 있는 컬럼명이 아니고 Country 테이블 컬럼인데 조인하려고 추가로 적었어요*/
	private String countryEng; /*해당 변수는 Quarantine 테이블에 있는 컬럼명이 아니고 Country 테이블 컬럼인데 조인하려고 추가로 적었어요*/
	private String continent;
	
	
	public Quarantine() {
		super();
	}
	public Quarantine(String countryCode, String depVyPcr, String depVnPcr,
			String arrVyPcr, String arrVnPcr, String arrVySelf, String arrVnSelf, Date updateDate) {
		super();
		this.countryCode = countryCode;
		this.depVyPcr = depVyPcr;
		this.depVnPcr = depVnPcr;
		this.arrVyPcr = arrVyPcr;
		this.arrVnPcr = arrVnPcr;
		this.arrVySelf = arrVySelf;
		this.arrVnSelf = arrVnSelf;
		this.updateDate = updateDate;
	}
	public Quarantine(String countryKor, String countryEng, String depVyPcr, String depVnPcr, String arrVyPcr,
			String arrVnPcr, String arrVySelf, String arrVnSelf) {
		super();
		this.countryKor = countryKor;
		this.countryEng = countryEng;
		this.depVyPcr = depVyPcr;
		this.depVnPcr = depVnPcr;
		this.arrVyPcr = arrVyPcr;
		this.arrVnPcr = arrVnPcr;
		this.arrVySelf = arrVySelf;
		this.arrVnSelf = arrVnSelf;
	}
	public Quarantine(String continent, String countryCode, String countryKor, Date updateDate) {
		super();
		this.continent = continent;
		this.countryCode = countryCode;
		this.countryKor = countryKor;
		this.updateDate = updateDate;
	}
	public Quarantine(String countryCode, String countryKor, String countryEng, String continent) {
		super();
		this.countryCode = countryCode;
		this.countryKor = countryKor;
		this.countryEng = countryEng;
		this.continent = continent;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getDepVyPcr() {
		return depVyPcr;
	}
	public void setDepVyPcr(String depVyPcr) {
		this.depVyPcr = depVyPcr;
	}
	
	public String getDepVnPcr() {
		return depVnPcr;
	}
	public void setDepVnPcr(String depVnPcr) {
		this.depVnPcr = depVnPcr;
	}
	
	public String getArrVyPcr() {
		return arrVyPcr;
	}
	public void setArrVyPcr(String arrVyPcr) {
		this.arrVyPcr = arrVyPcr;
	}
	
	public String getArrVnPcr() {
		return arrVnPcr;
	}
	public void setArrVnPcr(String arrVnPcr) {
		this.arrVnPcr = arrVnPcr;
	}
	
	public String getArrVySelf() {
		return arrVySelf;
	}
	public void setArrVySelf(String arrVySelf) {
		this.arrVySelf = arrVySelf;
	}
	
	public String getArrVnSelf() {
		return arrVnSelf;
	}
	public void setArrVnSelf(String arrVnSelf) {
		this.arrVnSelf = arrVnSelf;
	}
	
	public String getCountryKor() {
		return countryKor;
	}
	public void setCountryKor(String countryKor) {
		this.countryKor = countryKor;
	}
	
	public String getCountryEng() {
		return countryEng;
	}
	public void setCountryEng(String countryEng) {
		this.countryEng = countryEng;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	@Override
	public String toString() {
		return "Quarantine [countryCode=" + countryCode
				+ ", depVyPcr=" + depVyPcr + ", depVnPcr=" + depVnPcr + ", arrVyPcr=" + arrVyPcr + ", arrVnPcr="
				+ arrVnPcr + ", arrVySelf=" + arrVySelf + ", arrVnSelf=" + arrVnSelf + "]";
	}
	
}
