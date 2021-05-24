package com.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day_04_19 {
	
	static Set<String> test_set;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//key값을 가나다 순으로 정렬 합니다.
		
		HashMap<String, PhoneData> name_list = new HashMap<String, PhoneData>();
		ArrayList<PhoneData> list_array = new ArrayList<PhoneData>();

		
		
		for (int i = 0; i < 5; i++) {
			PhoneData data = new PhoneData(i);
			name_list.put(data.name[i], data);
			list_array.add(data);
			//System.out.println(data.name[0]);
		}
		
		System.out.println(name_list.size());

		test_set = name_list.keySet();
		
		System.out.println("test_set : "+test_set);
		
//		for(String string : test_set) {
//			//System.out.println(string);
//			name_list.get(string);
//		}
		
	
		//System.out.println("=>");
		
		//Set<String> s = new HashSet<String>(test_set);
		//ArrayList<String> list_a = new ArrayList<String>();
		
		//Collections.sort(list_a);
		Collections.sort(list_array);
		
		//System.out.print("\n오름차순 : ");
		//for(String b : list_a) System.out.print(b + " ");

		String temp = "이석봉";
		
		for (int i = 0; i < list_array.size(); i++) {
			System.out.println("="+list_array.get(i).s.name);
//				System.out.println(list_array.get(3).getList());
				
				if(list_array.get(0).is_true(temp)) {
					System.out.print("id 중복");
					return;
				}
					System.out.println("id 사용가능");
					name_list.put(temp, new PhoneData(temp,"서울","891031-","010-111","ㅁㄴ@@","kt","요금제","시리얼"));
					break;
				
//				if(list_array.get(i).getList().get(j).equals("송가인")) {
//					System.out.print(list_array.get(i).getList().get(j));
//				}
				
			//System.out.println(list_array.get(i).s.name);
		}
		
		System.out.println(name_list.size());
		System.out.println(name_list.get(temp).s.number);
		System.out.println("-------");

		//오름차순
//		for (int i = 0; i < list_a.size(); i++) {
//			System.out.println(name_list.get(list_a.get(i)).s.return_data());
//			
//		}

		
//		System.out.println();
//		System.out.println("===추가");
//		Set<String> s2 = new HashSet<String>(list_a);
//		s2.add("추가요**");
//		List<String> list_c = new ArrayList<String>(s2);
//		Collections.sort(list_c);	
//		for(String b : list_c) System.out.print(b + " ");
		
		

		
//		Iterator<String> it = s.iterator();
//
//		List<String> list = new ArrayList<>(s);
//		
//		Collections.sort(list);
//		System.out.print("\n오름차순 : ");
//		
//		for(String a : list) System.out.print(a + " ");

		

	}

}
