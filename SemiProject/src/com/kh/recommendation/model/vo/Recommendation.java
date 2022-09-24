package com.kh.recommendation.model.vo;

import java.sql.Date;

public class Recommendation {
	
	private int boardNo;
	private int boardType;
	private String boardTitle;
	private String boardContent;
	private Date createDate;
	private Date updateDate;
	private int count;
	private String countryCode;
	private String status;
	
	private String continent;
	private String countryKor;
	private String countryEng;
	
	private String thumbnailRoot;
	
	public Recommendation() {
		super();
	}

	public Recommendation(int boardNo, int boardType, String boardTitle, String boardContent, Date createDate,
			Date updateDate, int count, String countryCode, String status, String thumbnailRoot, String continent,
			String countryKor, String countryEng) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.count = count;
		this.countryCode = countryCode;
		this.status = status;
		this.thumbnailRoot = thumbnailRoot;
		this.continent = continent;
		this.countryKor = countryKor;
		this.countryEng = countryEng;
	}



	public Recommendation(int boardNo, int boardType, String boardTitle, String boardContent, Date createDate,
			int count, String continent) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.count = count;
		this.continent = continent;
	}

	public Recommendation(int boardNo, String boardTitle, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public Recommendation(int boardNo, String boardTitle, String boardContent, Date createDate, int count,
			String countryCode) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.count = count;
		this.countryCode = countryCode;
	}

	public Recommendation(String continent, String countryKor, String countryEng, String countryCode) {
		super();
		this.continent = continent;
		this.countryKor = countryKor;
		this.countryEng = countryEng;
		this.countryCode = countryCode;
		
	}
	
	

	public Recommendation(int boardNo, String boardTitle, String boardContent, String countryCode, String continent,
			String countryKor) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.countryCode = countryCode;
		this.continent = continent;
		this.countryKor = countryKor;
	}
	
	
	
	

	public Recommendation(int boardNo, String boardTitle, String boardContent, Date createDate, int count,
			String countryCode, String continent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.count = count;
		this.countryCode = countryCode;
		this.continent = continent;
	}
	
	

	public Recommendation(int boardNo, String boardTitle, String boardContent, String continent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.continent = continent;
	}

	public Recommendation(String thumbnailRoot) {
		super();
		this.thumbnailRoot = thumbnailRoot;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}
	
	

	public String getThumbnailRoot() {
		return thumbnailRoot;
	}



	public void setThumbnailRoot(String thumbnailRoot) {
		this.thumbnailRoot = thumbnailRoot;
	}



	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
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

	@Override
	public String toString() {
		return "Recommendation [boardNo=" + boardNo + ", boardType=" + boardType + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", count=" + count + ", countryCode=" + countryCode + ", status=" + status + ", continent="
				+ continent + ", countryKor=" + countryKor + ", countryEng=" + countryEng + ", thumbnailRoot=" + thumbnailRoot + "]";
	}
	

}
