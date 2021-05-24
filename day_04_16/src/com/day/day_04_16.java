package com.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;



public class day_04_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Data> map = new HashMap<String, Data>();
		Data_in data = new Data_in();
		for (int i = 0; i < data.name.length; i++) {
			Data p_data = new Data(data.age[i],data.adress[i],data.phone[i],data.gender[i]);
			map.put(data.name[i], p_data);
		}
		
		for (String string : map.keySet()) {
			Data p_data = map.get(string);
			System.out.println(string+"/"+p_data.address+"/"+p_data.age+"/"+p_data.phone+"/"+p_data.gender);
			
		}
		System.out.println("평균나이 : "+data.avg());
		
		
		
		
//		HashMap<String, B> map = new HashMap<String, B>();
//		
//		map.put("김시습", new B(29,"서울","010-111-111","남자"));
//		map.put("홍길동", new B(16,"부산","010-111-111","여자"));
//		map.put("성심문", new B(30,"서울","010-111-111","남자"));
//
//
//		for (String string : map.keySet()) {
////			System.out.println("성명 : "+string+"/ 나이 :"+map.get(string).age+"/ 지역 : "
////		+map.get(string).address+"/ 폰넘버 : "+map.get(string).phone+
////		"/ 성별 :"+map.get(string).male);
//			map.get(string).B_info(string);
//			//System.out.println("성명 : "+string+map.get(string));
//		}

		
	}//메인
	static void map_hash() {
//		HashMap<String , A> map_a = new HashMap<String, A>();
//		map_a.put("apple", new A(100,"apple"));
//		map_a.put("google", new A(300,"google"));
//		map_a.put("samsung", new A(200,"samsung"));
		
		HashMap<A , A> map_a = new HashMap<A, A>();
		A a = new A();
		A b = new A();
		A c = new A();
		map_a.put(a, new A(100,"apple"));
		map_a.put(b, new A(300,"google"));
		map_a.put(c, new A(200,"samsung"));
		
//		System.out.println(map_a.size());
		System.out.println(map_a.keySet());
		System.out.println(map_a.get(a).count);
//		System.out.println(map_a.values());
		for (A string : map_a.keySet()) {
//			System.out.println(string);
//			System.out.println(map_a.get(string).count);
//			System.out.println(map_a.get(string).str);
		}
	}
	
	static void set_tree4() {
		TreeSet<A> tree_set = new TreeSet<A>();
		ArrayList<A> list = new ArrayList<A>();
		ArrayList<String> list_s = new ArrayList<String>();
		
		A a = new A();
		a.count = 3000;
		a.str = "다다";
		
		A b = new A();
		b.count = 2000;
		b.str = "가가가";
		
		//map_a.put(100, a);
		A c = new A();
		c.count = 5000;
		c.str = "나";
		
		A d = new A();
		d.count = 5000;
		
		
		list.add(a);
		list.add(b);
		list.add(c);
		//list.add(d);
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).str);
		}
		
//		tree_set.add(a);
//		tree_set.add(b);
//		tree_set.add(c);
		
		//System.out.println(map_a.get(100).count);
		
		
//		HashMap<Integer , Integer> map = new HashMap<Integer, Integer>();
//		
//		map.put(11, 100);
//		map.put(12, 200);
//		map.put(12, 300);
//		
//		System.out.println("size : "+map.size()+" "+map.get(12));
//		System.out.println(map.keySet());
//		
//		System.out.println("=======");
//		
//		for (Integer key : map.keySet()) {
//			System.out.println(key);
//			System.out.println(map.get(key));
//			
//		}
	}
	
	static void set_tree3() {
		TreeSet<A> set = new TreeSet<A>((x,y)->{
			return x.count - y.count;
		}
				);
		TreeSet<A> set2 = new TreeSet<A>();
		
		A a1 = new A();
		a1.count = 100;
//		at.add(a1);
		A a2 = new A();
		a2.count = 50;
//		at.add(a2);
		
		//System.out.println("size : "+a2.size());
		for(A i : set) {
			System.out.println(i.count);
		}
	}
	
	static void set_tree() {
		TreeSet<String> tree_string = new TreeSet<String>();
		ArrayList<A> list = new ArrayList<A>();
		HashSet<A> a = new HashSet<A>();
		//TreeSet<A> at = new TreeSet<A>();
		
		
		A a1 = new A();
		a1.str="일이삼사오육칠팔구십";
		a.add(a1);
		A a2 = new A();
		a2.str="ㅎㅎ";
		a.add(a2);
		A a3 = new A();
		a3.str="일이삼사오육";
		a.add(a3);

		
		
//		A a1 = new A();
//		a1.count = 100;
//		at.add(a1);
//		A a2 = new A();
//		a2.count = 50;
//		at.add(a2);
		
//		System.out.println("size : "+at.size());
//		for(A i : at) {
//			System.out.println(i.str);
//		}
		
		tree_string.add("cc");
		tree_string.add("aaa");
		tree_string.add("eee");
		tree_string.add("bb");
//		a.add(new A());
//		a.add(new A());
//		A aa = new A();
		//System.out.println(aa);
		a.add(a1);
		a.add(a2);
		a.add(a3);
		
		//Collections.sort(a, );
		System.out.println(a.size());
		
		for	(A item : a) {
			System.out.println(item.str);
			//System.out.println(tree_set.size());
		}
	}
	
	static void set_test() {
		HashSet<Integer> set_list = new HashSet<Integer>();
		TreeSet<Integer> tree_set = new TreeSet<Integer>();
		
		set_list.add(100);
		set_list.add(200);
		set_list.add(300);
		
		System.out.println(set_list.size());
		
	}

}//클래스
