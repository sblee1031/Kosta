package com.day;

import java.util.ArrayList;

public class A implements I{
	
	
	//As as = null;
	String[] name = {"ȫ�浿","�Ż��Ӵ�","���ɹ�"};
	int[] age = {30,31,32};
	String[] address = {"�����", "�λ��", "������"};
	String[] phone = {"010-111-111", "011-222-333", "010-666-777"};
	String[] gender = {"��", "��", "��"};
	
	
	
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String data_text() {
		
		String text = "";
		for (int i = 0; i < name.length; i++) {
			text += name[i]+" / "+age[i]+" / "+address[i]+" / "+phone[i]+" / "+gender[i]+"\n";
			
		}
		
		return text;
	}



	
	

	
	
	
	
}
