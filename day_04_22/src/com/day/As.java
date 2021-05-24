package com.day;

import java.util.ArrayList;

public abstract class As implements I{

	A a = null;
	String name;
	int age;
	String addr;
	String phone;
	String gender;
	


	public As(String name, int age, String addr, String phone, String gender) {
		this();
		
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
		this.gender = gender;
	}
	
	public As() {
		//a = new A();
		//System.out.println("as defalt");
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public ArrayList<String> getList() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add(name+age+addr+phone+gender);
		
		return list;
	}

	

	
}
