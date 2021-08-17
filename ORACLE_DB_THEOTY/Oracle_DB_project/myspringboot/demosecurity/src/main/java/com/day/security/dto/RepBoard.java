package com.day.security.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RepBoard {
	private int level;
	private int boardNo; //자바는 camelCase
	private int parentNo;
	private Customer boardC;
	private String boardTitle;
	private String boardContent;
	private int boardViewcount; //board_viewcount 
	@JsonFormat(pattern = "yy/MM/dd", timezone = "Asia/Seoul")
	private Date boardDt;
	
	
	//Lombok라이브러리를 사용하면 생성자, setter/getter/toString메서드 제공
	public RepBoard() {
	}
	public RepBoard(int level, int boardNo, int parentNo, Customer boardC, String boardTitle, String boardContent,
			int boardViewcount, Date boardDt) {
		super();
		this.level = level;
		this.boardNo = boardNo;
		this.parentNo = parentNo;
		this.boardC = boardC;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardViewcount = boardViewcount;
		this.boardDt = boardDt;
	}
	public RepBoard(Customer boardC, String boardTitle, String boardContent) {
		super();
		this.boardC = boardC;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}
	public RepBoard(int parentNo, Customer boardC, String boardTitle, String boardContent) {
		super();
		this.parentNo = parentNo;
		this.boardC = boardC;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	public Customer getBoardC() {
		return boardC;
	}
	public void setBoardC(Customer boardC) {
		this.boardC = boardC;
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
	public int getBoardViewcount() {
		return boardViewcount;
	}
	public void setBoardViewcount(int boardViewcount) {
		this.boardViewcount = boardViewcount;
	}
	public Date getBoardDt() {
		return boardDt;
	}
	public void setBoardDt(Date boardDt) {
		this.boardDt = boardDt;
	}
	@Override
	public String toString() {
		return "RepBoard [level=" + level + ", boardNo=" + boardNo + ", parentNo=" + parentNo + ", boardC=" + boardC
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardViewcount=" + boardViewcount
				+ ", boardDt=" + boardDt + "]";
	}
	
	
	
}
