package com.day;

public class A extends As{
	
	
	//As as = null;
	String[] name = {"홍길동","신사임당","성심문"};
	int[] age = {30,31,32};
	String[] adress = {"서울시", "부산시", "성남시"};
	String[] phone = {"010-111-111", "011-222-333", "010-666-777"};
	String[] gender = {"남", "여", "남"};
	
	
	
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}



	public A(int i) {
		setName(name[i]);
		setAge(age[i]);
		setAddr(adress[i]);
		setPhone(phone[i]);
		setGender(gender[i]);
	}
	
	
	
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return name.length;
	}
	
	
	
	
}
