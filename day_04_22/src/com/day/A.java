package com.day;

public class A extends As{
	
	
	//As as = null;
	String[] name = {"ȫ�浿","�Ż��Ӵ�","���ɹ�"};
	int[] age = {30,31,32};
	String[] adress = {"�����", "�λ��", "������"};
	String[] phone = {"010-111-111", "011-222-333", "010-666-777"};
	String[] gender = {"��", "��", "��"};
	
	
	
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
