package com.day;

public class B extends Bs {
	
	Bs bs = null;

	String[] name = {"�۰���","����","�����","������","���缮"};
	private String[] addr = {"��⵵ ������","���� Ư����","�λ� ������","��õ ������","��ű�����"};;
	private String[] number = {"000000-123456","000000-123456","000000-123456","000000-123456","000000-123456"};;
	private String[] phoneNum = {"010-0000-1234","010-0000-5678","010-0000-1234","010-0000-1234","010-0000-1234"};;
	private String[] email = {"123@naver.com","123@naver.com","123@naver.com","123@naver.com","123@naver.com"};;
	private String[] service = {"sk-0000-1234","kt-0000-1234","lg-0000-1234","sk-0000-1234","�˶�-0000-1234"};;
	private String[] plan = {"20000","30000","40000","50000","60000"};;
	private String[] serial = {"����ȣ_0000","����ȣ_0000","����ȣ_0000","����ȣ_0000","����ȣ_0000"};
	
	public B() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public B(int i) {
		setName(name[i]);
		setAddr(addr[i]);
		setNumber(number[i]);
		setPhoneNum(phoneNum[i]);
		setEmail(email[i]);
		setService(service[i]);
		setPlan(plan[i]);
		setSerial(serial[i]);
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return name.length;
	}



	

}
