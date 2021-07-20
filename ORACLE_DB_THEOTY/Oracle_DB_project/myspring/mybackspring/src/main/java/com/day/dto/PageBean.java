package com.day.dto;

import java.util.List;

public class PageBean<T> {
	private int currentPage = 1;
	private int totalPage;
	/**
	 * 페이지별 보여줄 목록 수
	 */
	public static final int CNT_PER_PAGE = 10; 
	private List<T> list;

	/**
	 * 페이지그룹의 페이지수
	 */
	public static final int CNT_PER_PAGE_GROUP = 4;
	private int startPage = 1;
	private int endPage;
	
	private String url;
	
	public PageBean() {}
	public PageBean(int currentPage, int totalPage, List<T>list, String url) {
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.list = list;
		this.url = url;
		
		this.startPage = 1;
		this.endPage = CNT_PER_PAGE_GROUP * currentPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
