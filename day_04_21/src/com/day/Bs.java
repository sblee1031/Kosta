package com.day;

import java.util.ArrayList;

public class Bs implements I{

	String name;
	String addr;
	String number;
	String phoneNum;
	String email;
	String service;
	String plan;
	String serial;
	
	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAddr() {
		return addr;
	}




	public void setAddr(String addr) {
		this.addr = addr;
	}




	public String getNumber() {
		return number;
	}




	public void setNumber(String number) {
		this.number = number;
	}




	public String getPhoneNum() {
		return phoneNum;
	}




	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getService() {
		return service;
	}




	public void setService(String service) {
		this.service = service;
	}




	public String getPlan() {
		return plan;
	}




	public void setPlan(String plan) {
		this.plan = plan;
	}




	public String getSerial() {
		return serial;
	}




	public void setSerial(String serial) {
		this.serial = serial;
	}




	@Override
	public ArrayList<String> getList() {
		
		ArrayList<String> list = new ArrayList<String>();
		
//		for (int i = 0; i < 3; i++) {
			//A a = new A(i);
			list.add(name+"/"+addr+" / "+phoneNum+" / "+email+" / "+service+" / "+plan+" / "+serial);
			
			//System.out.println(list.get(0));
//	s	}
		
		//System.out.println(list.get(0));
		//ArrayList<String> list3 = new ArrayList<String>();
		
		
		return list;
	}




	public Bs() {
		super();
		// TODO Auto-generated constructor stub
	}
}
