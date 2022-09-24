package com.kh.airschedule.model.vo;

public class AirSchedule {
	
	private int regNo;
	private String flightNo;
	private String airline;
	private String depCode;
	private String depDate;
	private String depTime;
	private String arrivalCode;
	private String arrivalDate;
	private String arrivalTime;
	private String wholeTime;
	private int price;
	private String nonstopFlightYn;
	private String transfer;
	private String waitingTime;
	private String depCity;
	private String arrivalCity;
	public AirSchedule() {
		super();
	}
	public AirSchedule(int regNo, String flightNo, String airline, String depCode, String depDate, String depTime,
			String arrivalCode, String arrivalDate, String arrivalTime, String wholeTime, int price, String nonstopFlightYn,
			String transfer, String waitingTime) {
		super();
		this.regNo = regNo;
		this.flightNo = flightNo;
		this.airline = airline;
		this.depCode = depCode;
		this.depDate = depDate;
		this.depTime = depTime;
		this.arrivalCode = arrivalCode;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.wholeTime = wholeTime;
		this.price = price;
		this.nonstopFlightYn = nonstopFlightYn;
		this.transfer = transfer;
		this.waitingTime = waitingTime;
	}
	
	public AirSchedule(String airline, String depCode, String depCity, String arrivalCode, String arrivalCity, String depTime, String arrivalTime, String wholeTime, int price, String nonstopFlightYn,
			String transfer, String waitingTime, String flightNo) {
		this.airline = airline;
		this.depCode = depCode;
		this.depCity = depCity;
		this.arrivalCode = arrivalCode;
		this.arrivalCity = arrivalCity;
		this.depTime = depTime;
		this.arrivalTime = arrivalTime;
		this.wholeTime = wholeTime;
		this.price = price;
		this.nonstopFlightYn = nonstopFlightYn;
		this.transfer = transfer;
		this.waitingTime = waitingTime;
		this.flightNo = flightNo;
	}
	
	
	public AirSchedule(String flightNo, String depCode, String arrivalCode, String depDate, String depTime,
			String arrivalDate, String arrivalTime, int price) {
		super();
		this.flightNo = flightNo;
		this.depCode = depCode;
		this.arrivalCode = arrivalCode;
		this.depDate = depDate;
		this.depTime = depTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	public String getDepCode() {
		return depCode;
	}
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	
	public String getDepDate() {
		return depDate;
	}
	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}
	
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	
	public String getArrivalCode() {
		return arrivalCode;
	}
	public void setArrivalCode(String arrivalCode) {
		this.arrivalCode = arrivalCode;
	}
	
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public String getWholeTime() {
		return wholeTime;
	}
	public void setWholeTime(String wholeTime) {
		this.wholeTime = wholeTime;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getNonstopFlightYn() {
		return nonstopFlightYn;
	}
	public void setNonstopFlightYn(String nonstopFlightYn) {
		this.nonstopFlightYn = nonstopFlightYn;
	}
	
	public String getTransfer() {
		return transfer;
	}
	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}
	
	public String getWaitingTime() {
		return waitingTime;
	}
	public void setWaitingTime(String waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	@Override
	public String toString() {
		return "AirSchedule [regNo=" + regNo + ", flightNo=" + flightNo + ", airline=" + airline + ", depCode="
				+ depCode + ", depDate=" + depDate + ", depTime=" + depTime + ", arrivalCode=" + arrivalCode
				+ ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", wholeTime=" + wholeTime
				+ ", price=" + price + ", nonstopFlightYn=" + nonstopFlightYn + ", transfer=" + transfer
				+ ", waitingTime=" + waitingTime + "]";
	}
}
