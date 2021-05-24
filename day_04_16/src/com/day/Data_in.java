package com.day;

public class Data_in {

	String[] name = {"홍길동","신사임당","성심문"};
	int[] age = {30,31,32};
	String[] adress = {"서울시", "부산시", "성남시"};
	String[] phone = {"010", "11", "2222"};
	String[] gender = {"남", "여", "성남시"};

	int avg() {
		int a = 0;
		for (int i = 0; i < age.length; i++) {
			a+= age[i];
		}
		System.out.println("토탈:"+a);
		return a/age.length;
	}
}
