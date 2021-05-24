package com.day;

import java.util.ArrayList;

public class Data_in implements I{

	String[] name = {"홍길동","신사임당","성심문"};
	int[] age = {30,31,32};
	String[] adress = {"서울시", "부산시", "성남시"};
	String[] phone = {"010", "11", "2222"};
	String[] gender = {"남", "여", "성남시"};

	@Override
	public ArrayList<String> GetList() {
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < name.length; i++) {
			list.add(name[i]);
		}
		
		return list;
	}
}
