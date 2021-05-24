package com.day;

public class PhoneS {
	
	String name ;
	String addr ;
	String number;
	String phoneNum ;
	String email ;
	String service;
	String plan ;
	String serial;
	
	
	
	public PhoneS() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PhoneS(String name, String addr, String number, String phoneNum, String email, String service, String plan,
			String serial) {
		super();
		this.name = name;
		this.addr = addr;
		this.number = number;
		this.phoneNum = phoneNum;
		this.email = email;
		this.service = service;
		this.plan = plan;
		this.serial = serial;
	}
	
	public String return_data() {
		return "이름 : "+name+" / 주소 :"+addr+" / 주번 : "
				+number+" / 폰넘버 : "+phoneNum+
				" / 이메일 :"+email+"/통신사 : "+service +"/요금제 : "+plan+"/시리얼 :"+serial;
	}



}
