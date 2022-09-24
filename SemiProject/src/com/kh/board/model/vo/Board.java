package com.kh.board.model.vo;

import java.util.Date;

public class Board {

	private int faqNo;   
	private int categoryNo;
	private int boardType;
	private String faqTitle;   	
	private String faqContent;   
	private String status;
	private String boardWriter;
	private Date createDate;
	private String category;
	private String categoryName;
	private int rnum;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	public Board( String faqTitle, String faqContent) {
		super();
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}
	
	
	
	

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	public Board(int faqNo, String categoryName, String faqTitle, String faqContent, String boardWriter, Date createDate
			) {
		super();
		this.faqNo = faqNo;
		this.categoryName = categoryName;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
	}
	public Board( String faqTitle, String faqContent,int categoryNo) {
		super();
		this.categoryNo = categoryNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}

	public Board(int categoryNo, String faqTitle, String faqContent) {
		super();
		this.categoryNo = categoryNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}
	public Board(int boardType) {
		super();
		this.boardType = boardType;
	}
	public int getBoardType() {
		return boardType;
	}
	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}
	public Board(int faqNo, String faqTitle, String faqContent, String boardWriter, Date createDate) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
	}
	public Board(int rnum, String faqTitle, int faqNo) {
		super();
		this.rnum = rnum;
		this.faqTitle = faqTitle;
		this.faqNo = faqNo;
	}
	public Board(int faqNo, int categoryNo, String faqTitle, String faqContent, String status) {
		super();
		this.faqNo = faqNo;
		this.categoryNo = categoryNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.status = status;
	}
	public Board(int categoryNo, String faqTitle, String faqContent, int faqNo) {
		super();
		this.categoryNo = categoryNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqNo = faqNo;
	}
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Board [faqNo=" + faqNo + ", categoryNo=" + categoryNo + ", boardType=" + boardType + ", faqTitle="
				+ faqTitle + ", faqContent=" + faqContent + ", status=" + status + ", boardWriter=" + boardWriter
				+ ", createDate=" + createDate + ", category=" + category + ", categoryName=" + categoryName + ", rnum="
				+ rnum + "]";
	}
	
	
	
	
}
