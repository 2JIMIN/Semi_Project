package com.kh.reservation.model.vo;

import java.util.Date;

public class Reservation {
	
	private int enrollNo;
	private int bookingNo;
	private String depCode;
	private String flightNo;
	private String depDate;
	private String rDepCode;
	private String rFlightNo;
	private String rDepDate;
	private Date reservationDate;
	private String status;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(int enrollNo, int bookingNo, String depCode, String flightNo, String depDate, String rDepCode,
			String rFlightNo, String rDepDate, Date reservationDate, String status) {
		super();
		this.enrollNo = enrollNo;
		this.bookingNo = bookingNo;
		this.depCode = depCode;
		this.flightNo = flightNo;
		this.depDate = depDate;
		this.rDepCode = rDepCode;
		this.rFlightNo = rFlightNo;
		this.rDepDate = rDepDate;
		this.reservationDate = reservationDate;
		this.status = status;
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
	
	public String getrDepCode() {
		return rDepCode;
	}
	public void setrDepCode(String rDepCode) {
		this.rDepCode = rDepCode;
	}
	
	public String getrFlightNo() {
		return rFlightNo;
	}
	public void setrFlightNo(String rFlightNo) {
		this.rFlightNo = rFlightNo;
	}
	
	public String getrDepDate() {
		return rDepDate;
	}
	public void setrDepDate(String rDepDate) {
		this.rDepDate = rDepDate;
	}
	
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reservation [enrollNo=" + enrollNo + ", bookingNo=" + bookingNo + ", depCode=" + depCode + ", flightNo="
				+ flightNo + ", depDate=" + depDate + ", rDepCode=" + rDepCode + ", rFlightNo=" + rFlightNo
				+ ", rDepDate=" + rDepDate + ", reservationDate=" + reservationDate + ", status=" + status + "]";
	}
}