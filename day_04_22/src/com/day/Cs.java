package com.day;

import java.util.ArrayList;

public abstract class Cs implements I{

	String title;
	String director;
	String genre;
	String count;
	String actor;
	String actress;
	String time;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public ArrayList<String> getList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add(title+director+genre+count+actor+actress+time);
		
		return list;
	}
	
	
}
