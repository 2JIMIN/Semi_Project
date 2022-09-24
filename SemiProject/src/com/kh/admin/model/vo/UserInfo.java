package com.kh.admin.model.vo;

import java.sql.Date;

public class UserInfo {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String phone;
	private Date enrollDate;
	private String status;
	private int enrollNo;
	private String flightNo;
	
	public UserInfo() {}
	
	

	public UserInfo(int userNo, String userId, String userPwd, String userName, String email, String phone,
			Date enrollDate, String status, String flightNo) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.status = status;
		this.flightNo = flightNo;
	}



	public UserInfo(String userId, String userPwd, String userName, String email, String phone, Date enrollDate) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}

	public UserInfo(String userId, String userPwd, String userName,String email,String phone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
	}	
	
	public UserInfo(int userNo, String userId, String userPwd, String userName, String email, String phone,
			Date enrollDate, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.status = status;
	}

	public UserInfo(String userId, String userName, String email, String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
	}
	

	public UserInfo(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}	

	public UserInfo(int userNo, String userId, String userPwd, String userName, String email, String phone,
			Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}
	
	

	public UserInfo(int userNo, String userId, String userPwd) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
	}
	


	public UserInfo(String userId, String email, String phone, Date enrollDate) {
		super();
		this.userId = userId;
		this.email = email;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	public int getEnrollNo() {
		return enrollNo;
	}



	public void setEnrollNo(int enrollNo) {
		this.enrollNo = enrollNo;
	}



	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	@Override
	public String toString() {
		return "UserInfo [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", phone=" + phone + ", enrollDate=" + enrollDate + ", status=" + status
				+ ", flightNo=" + flightNo + "]";
	}

	
	
	
}
