package com.kh.reservationdetail.model.vo;

public class ReservationDetail {
	
	private int bookingNo;
	private String lastName;
	private String firstName;
	private String passportNo;
	private int validDate;
	private String passengerName;
	private int birthDate;
	private String intDomId;
	
	public ReservationDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReservationDetail(int bookingNo, String lastName, String firstName, String passportNo, int validDate,
			String passengerName, int birthDate, String intDomId) {
		super();
		this.bookingNo = bookingNo;
		this.lastName = lastName;
		this.firstName = firstName;
		this.passportNo = passportNo;
		this.validDate = validDate;
		this.passengerName = passengerName;
		this.birthDate = birthDate;
		this.intDomId = intDomId;
	}
	
	public ReservationDetail(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	
	public int getValidDate() {
		return validDate;
	}
	public void setValidDate(int validDate) {
		this.validDate = validDate;
	}
	
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	public int getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getIntDomId() {
		return intDomId;
	}
	public void setIntDomId(String intDomId) {
		this.intDomId = intDomId;
	}
	
	@Override
	public String toString() {
		return "ReservationDetail [bookingNo=" + bookingNo + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", passportNo=" + passportNo + ", validDate=" + validDate + ", passengerName=" + passengerName
				+ ", birthDate=" + birthDate + ", intDomId=" + intDomId + "]";
	}
}