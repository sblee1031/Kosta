package com.day;

import java.util.ArrayList;

public class Data_in implements I{

	String[] name = {"ȫ�浿","�Ż��Ӵ�","���ɹ�"};
	int[] age = {30,31,32};
	String[] adress = {"�����", "�λ��", "������"};
	String[] phone = {"010", "11", "2222"};
	String[] gender = {"��", "��", "������"};

	@Override
	public ArrayList<String> GetList() {
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < name.length; i++) {
			list.add(name[i]);
		}
		
		return list;
	}
}
