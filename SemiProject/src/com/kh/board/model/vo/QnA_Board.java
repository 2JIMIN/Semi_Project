package com.kh.board.model.vo;

import java.sql.Date;

public class QnA_Board {
	private int boardNo;	//	BOARD_NO	NUMBER
	private String boardWriter;	//	BOARD_WRITER	NUMBER
	private String category;
	private int categoryNo;	//	CATEGORY_NO	NUMBER
	private String boardType;	//	BOARD_TYPE	NUMBER
	private String boardTitle;	//	BOARD_TITLE	VARCHAR2(150 BYTE)
	private String boardContent;	//	BOARD_CONTENT	VARCHAR2(4000 BYTE)
	private Date createDate;	//	CREATE_DATE	DATE
	private String answerStatus;	//	ANSWER_STATUS	VARCHAR2(20 BYTE)
	private String status;//	STATUS	VARCHAR2(1 BYTE)
	private String categoryName;
	private String userId;
	private int rnum;
	private String email;
	private String phone;
	public QnA_Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnA_Board(int boardNo, String boardWriter, int categoryNo, String boardType, String boardTitle, String boardContent,
			Date createDate, String answerStatus, String status) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.categoryNo = categoryNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.answerStatus = answerStatus;
		this.status = status;
	}
	
	
	
	public QnA_Board(int rnum, String boardTitle, String categoryName, String userId, Date createDate, String answerStatus
			) {
		super();
		this.rnum = rnum;
		this.boardTitle = boardTitle;
		this.categoryName = categoryName;
		this.userId = userId;
		this.createDate = createDate;
		this.answerStatus = answerStatus;
	}
	
	
	public QnA_Board(int boardNo, String categoryName, String boardTitle, String boardContent, String userId,
			Date createDate, int rnum) {
		super();
		this.boardNo = boardNo;
		this.categoryName = categoryName;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.userId = userId;
		this.createDate = createDate;
		this.rnum = rnum;
	}
	
	public QnA_Board(int boardNo, String categoryName, String boardTitle, String boardContent, String userId,
			Date createDate, String email, String phone, int rnum) {
		super();
		this.boardNo = boardNo;
		this.categoryName = categoryName;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.userId = userId;
		this.createDate = createDate;
		this.email = email;
		this.phone=phone;
		this.rnum = rnum;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAnswerStatus() {
		return answerStatus;
	}
	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardWriter=" + boardWriter + ", categoryNo=" + categoryNo
				+ ", boardType=" + boardType + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", createDate=" + createDate + ", answerStatus=" + answerStatus + ", status=" + status + "]";
	}
	
	
	
	
}
