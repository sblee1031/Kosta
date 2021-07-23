package com.day.dto;

import java.util.Date;

public class Board {
	private int board_no;
	private String board_title;
	private String board_content;
	private Date board_dt;
	private Customer board_c;
	public Board() {
		super();
	}
	
	public Board(String board_title, String board_content, Customer board_c) {
		super();
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_c = board_c;
	}

	public Board(int board_no, String board_title, String board_content, Date board_dt, Customer board_c) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_dt = board_dt;
		this.board_c = board_c;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getBoard_dt() {
		return board_dt;
	}

	public void setBoard_dt(Date board_dt) {
		this.board_dt = board_dt;
	}

	public Customer getBoard_c() {
		return board_c;
	}

	public void setBoard_c(Customer board_c) {
		this.board_c = board_c;
	}

	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_dt=" + board_dt + ", board_c=" + board_c + "]";
	}
	
	
}
