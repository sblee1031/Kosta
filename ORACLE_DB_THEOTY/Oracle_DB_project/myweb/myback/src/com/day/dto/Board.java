package com.day.dto;

import java.util.Date;

public class Board {
	
	public Board() {
		super();
	}
	private int BOARD_NO;
	private String BOARD_TITLE;
	private String BOARD_CONTENT;
	private Date BOARD_DT;
	private String BOARD_ID;
	public int getBOARD_NO() {
		return BOARD_NO;
	}
	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}
	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}
	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}
	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}
	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}
	public Date getBOARD_DT() {
		return BOARD_DT;
	}
	public void setBOARD_DT(Date bOARD_DT) {
		BOARD_DT = bOARD_DT;
	}
	public String getBOARD_ID() {
		return BOARD_ID;
	}
	public void setBOARD_ID(String bOARD_ID) {
		BOARD_ID = bOARD_ID;
	}
	public Board(int bOARD_NO, String bOARD_TITLE, String bOARD_CONTENT, Date bOARD_DT, String bOARD_ID) {
		super();
		BOARD_NO = bOARD_NO;
		BOARD_TITLE = bOARD_TITLE;
		BOARD_CONTENT = bOARD_CONTENT;
		BOARD_DT = bOARD_DT;
		BOARD_ID = bOARD_ID;
	}
	@Override
	public String toString() {
		return "Board [BOARD_NO=" + BOARD_NO + ", BOARD_TITLE=" + BOARD_TITLE + ", BOARD_CONTENT=" + BOARD_CONTENT
				+ ", BOARD_DT=" + BOARD_DT + ", BOARD_ID=" + BOARD_ID + "]";
	}
	
}
