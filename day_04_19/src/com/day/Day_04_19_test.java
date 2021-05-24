package com.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Day_04_19_test {
	
	static Set<String> test_set;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//key값을 가나다 순으로 정렬 합니다.

		HashMap<String, PhoneData> name_list = new HashMap<String, PhoneData>();
		ArrayList<PhoneData> list_array = new ArrayList<PhoneData>();
		test_set = name_list.keySet();
		
		System.out.print("정렬 전=>");
		for (int i = 0; i < 5; i++) {
			PhoneData data = new PhoneData(i);
			name_list.put(data.name[i], data);
			System.out.print(name_list.get(data.name[i]).s.name+" ");
			//System.out.println(name_list.get(data.name[i]).name[0]);
			list_array.add(data);//ArrayList 데이터 입력
		}
		System.out.println();
		
//		for (String string : test_set) {
//			name_list.get(string);
//		}
		
		//Collections.sort(list_array,Collections.reverseOrder());//내림차순
		Collections.sort(list_array);//오름차순
		
		for (int i = 0; i < list_array.size(); i++) {
			System.out.println( list_array.get(i).s.name +" /주소 : "+list_array.get(i).s.addr+" /전번 : "+list_array.get(i).s.phoneNum);
		}
		//System.out.println(list_array.get(4).s.name);
		
		System.out.println(name_list.size());
		System.out.println("keyset"+name_list.keySet());
		
		System.out.println(name_list.get("송가인").s.addr);
		

	}

}
