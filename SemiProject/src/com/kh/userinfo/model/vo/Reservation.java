package com.kh.userinfo.model.vo;

public class Reservation {
	private int enrollNo;//ENROLL_NO NUMBER PRIMARY KEY,
    private int bookingNo;//BOOKING_NO NUMBER NOT NULL,
    private String depCode;//DEP_CODE VARCHAR2(10) NOT NULL,
    private String flightNo;//FLIGHT_NO VARCHAR2(15) NOT NULL,
    private String depDate;//DEP_DATE VARCHAR2(15) NOT NULL
    private String userId;
    private String intDomId;
    private String userName;
    private String email;
    private String depCity;
    private String arrivalCity;
    private String arrivalDate;
    private String airline;
    
    
    
    public Reservation(int enrollNo, int bookingNo, String depCode, String flightNo, String depDate, String userId,
			String intDomId, String userName, String email, String depCity, String arrivalCity, String arrivalDate,
			String airline) {
		super();
		this.enrollNo = enrollNo;
		this.bookingNo = bookingNo;
		this.depCode = depCode;
		this.flightNo = flightNo;
		this.depDate = depDate;
		this.userId = userId;
		this.intDomId = intDomId;
		this.userName = userName;
		this.email = email;
		this.depCity = depCity;
		this.arrivalCity = arrivalCity;
		this.arrivalDate = arrivalDate;
		this.airline = airline;
	}

	public Reservation(int enrollNo, String intDomId, int bookingNo , String userName, 
    		String email, String flightNo, String depCity, 
    		String arrivalCity, String depDate, String arrivalDate) {
    	super();
    	this.enrollNo = enrollNo;
    	this.intDomId = intDomId;
    	this.bookingNo = bookingNo;
    	this.userName = userName;
    	this.email = email;
    	this.flightNo = flightNo;
    	this.depCity = depCity;
    	this.arrivalCity = arrivalCity;
    	this.depDate = depDate;
    	this.arrivalDate = arrivalDate;
    }
     
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Reservation(int enrollNo, int bookingNo, String depCode, String flightNo, String depDate, String userId) {
		super();
		this.enrollNo = enrollNo;
		this.bookingNo = bookingNo;
		this.depCode = depCode;
		this.flightNo = flightNo;
		this.depDate = depDate;
		this.userId = userId;
	}

	public Reservation() {
		super();
	}

	public Reservation(int enrollNo, int bookingNo, String depCode, String flightNo, String depDate) {
		super();
		this.enrollNo = enrollNo;
		this.bookingNo = bookingNo;
		this.depCode = depCode;
		this.flightNo = flightNo;
		this.depDate = depDate;
	}

	public Reservation(int enrollNo, int bookingNo, String depCode, String flightNo, String depDate, String userId,
			String intDomId, String userName, String email, String depCity, String arrivalCity, String arrivalDate) {
		super();
		this.enrollNo = enrollNo;
		this.bookingNo = bookingNo;
		this.depCode = depCode;
		this.flightNo = flightNo;
		this.depDate = depDate;
		this.userId = userId;
		this.intDomId = intDomId;
		this.userName = userName;
		this.email = email;
		this.depCity = depCity;
		this.arrivalCity = arrivalCity;
		this.arrivalDate = arrivalDate;
	}

	public Reservation(int enrollNo, String flightNo) {
		super();
		this.enrollNo = enrollNo;
		this.flightNo = flightNo;
	}

	public Reservation(String userId, int enrollNo, String flightNo) {
		super();
		this.enrollNo = enrollNo;
		this.flightNo = flightNo;
		this.userId = userId;
	}

	public int getEnrollNo() {
		return enrollNo;
	}

	public void setEnrollNo(int enrollNo) {
		this.enrollNo = enrollNo;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepDate() {
		return depDate;
	}

	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}

	public String getIntDomId() {
		return intDomId;
	}

	public void setIntDomId(String intDomId) {
		this.intDomId = intDomId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Override
	public String toString() {
		return "Reservation [enrollNo=" + enrollNo + ", bookingNo=" + bookingNo + ", depCode=" + depCode + ", flightNo="
				+ flightNo + ", depDate=" + depDate + ", userId=" + userId + ", intDomId=" + intDomId + ", userName="
				+ userName + ", email=" + email + ", depCity=" + depCity + ", arrivalCity=" + arrivalCity
				+ ", arrivalDate=" + arrivalDate + "]";
	}

	
}
