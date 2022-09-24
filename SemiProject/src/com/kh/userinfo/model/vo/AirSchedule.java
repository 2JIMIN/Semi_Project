package com.kh.userinfo.model.vo;

public class AirSchedule {
	private int regNo;//REG_NO NUMBER PRIMARY KEY,
	private String flightNo;//FLIGHT_NO VARCHAR2(15) NOT NULL,
	private String airline;//AIRLINE VARCHAR2(30) NOT NULL,
	private String depCode;//DEP_CODE VARCHAR2(10) NOT NULL,
	private String depDate;//DEP_DATE VARCHAR2(15) NOT NULL,
	private String depTime;//DEP_TIME VARCHAR2(10) NOT NULL,
	private String arrival;//ARRIVAL_CODE VARCHAR2(10) NOT NULL,
	private String arrivalDate;//ARRIVAL_DATE VARCHAR2(15) NOT NULL,
	private String arrivalTime;//ARRIVAL_TIME VARCHAR2(10) NOT NULL,
	private String wholeTime;//WHOLE_TIME VARCHAR2(10) NOT NULL,
	private int price;//PRICE NUMBER NOT NULL,
	private String nonstopFlight;//NONSTOP_FLIGHT_YN VARCHAR2(10) CHECK(NONSTOP_FLIGHT_YN IN('직항', '경유')),
	private String transfer;//TRANSFER VARCHAR2(30) DEFAULT NULL,
	private String waitingTime;//WAITING_TIME VARCHAR2(10) DEFAULT NULL
	public AirSchedule() {
		super();
	}
	public AirSchedule(int regNo, String flightNo, String airline, String depCode, String depDate, String depTime,
			String arrival, String arrivalDate, String arrivalTime, String wholeTime, int price, String nonstopFlight,
			String transfer, String waitingTime) {
		super();
		this.regNo = regNo;
		this.flightNo = flightNo;
		this.airline = airline;
		this.depCode = depCode;
		this.depDate = depDate;
		this.depTime = depTime;
		this.arrival = arrival;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.wholeTime = wholeTime;
		this.price = price;
		this.nonstopFlight = nonstopFlight;
		this.transfer = transfer;
		this.waitingTime = waitingTime;
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
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
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
	public String getNonstopFlight() {
		return nonstopFlight;
	}
	public void setNonstopFlight(String nonstopFlight) {
		this.nonstopFlight = nonstopFlight;
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
				+ depCode + ", depDate=" + depDate + ", depTime=" + depTime + ", arrival=" + arrival + ", arrivalDate="
				+ arrivalDate + ", arrivalTime=" + arrivalTime + ", wholeTime=" + wholeTime + ", price=" + price
				+ ", nonstopFlight=" + nonstopFlight + ", transfer=" + transfer + ", waitingTime=" + waitingTime + "]";
	}

}
