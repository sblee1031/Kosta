package com.day;

public class Data_in {

	String[] name = {"ȫ�浿","�Ż��Ӵ�","���ɹ�"};
	int[] age = {30,31,32};
	String[] adress = {"�����", "�λ��", "������"};
	String[] phone = {"010", "11", "2222"};
	String[] gender = {"��", "��", "������"};

	int avg() {
		int a = 0;
		for (int i = 0; i < age.length; i++) {
			a+= age[i];
		}
		System.out.println("��Ż:"+a);
		return a/age.length;
	}
}
