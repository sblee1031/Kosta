package com.day;

import java.util.ArrayList;
import java.util.HashMap;

public class A implements I{
	
	String[] name = {"ȫ�浿","�Ż��Ӵ�","���ɹ�"};
	int[] age = {30,31,32};
	String[] adress = {"�����", "�λ��", "������"};
	String[] phone = {"010", "11", "2222"};
	String[] gender = {"��", "��", "������"};

	@Override
	public ArrayList<String> GetList() {
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < name.length; i++) {
			list.add(name[i]+" / "+age[i]+" / "+adress[i]+" / "+phone[i]+" / "+gender[i]);
		}
		return list;
	}
	
	@Override
	public HashMap<String, String> GetHash2() {
		ArrayList<String> list = new ArrayList<String>();

		HashMap<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i < name.length; i++) {
			list.add(name[i]+" / "+age[i]+" / "+adress[i]+" / "+phone[i]+" / "+gender[i]);
			//System.out.println("list.get"+list.get(i));
			map.put(name[i], list.get(i));
		}
		
		//System.out.println("list : "+list);

		//System.out.println("2 : "+map.toString());
		//System.out.println("str : "+map.get(str));
		return map;
	}
	
	
}
