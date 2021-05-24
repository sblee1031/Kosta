package com.day;

public class B {
	
	public B() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	int age;
	String address;
	String phone;
	String male;
	
	public B(int age, String address, String phone, String male) {
		super();
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.male = male;

	}
	
	public void B_info(String name) {
		System.out.println("이름 : "+name+" / 나이 :"+age+" / 지역 : "
				+address+" / 폰넘버 : "+phone+
				" / 성별 :"+male);
	}
	

}
