package com.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class day_04_20 {

	public static void main(String[] args) {
		
		ArrayList<I> list = new ArrayList<I>();
		LinkedList<I> linked = new LinkedList<I>();
		
		A a = new A();
		B b = new B();
		C c = new C();
		
		
		list.add(a);
		list.add(b);
		list.add(c);
		
		
		linked.add(a);
		linked.add(b);
		linked.add(c);
		
		
		map(a,"신사임당");
		map(b,"현빈");
		map(c,"타이타닉");
		
		//print_test(a);
		//print_test2(linked);
		//print_test2(list);
		

	}//메인 클래스
	static void map(I a, String str) {
		System.out.println(str+" = "+a.GetHash2().get(str));
		//a.GetHash(str).get(str).get(0).length();

	}
	
	static void map_test2() {
		ArrayList<I> list = new ArrayList<I>();
		LinkedList<I> linked = new LinkedList<I>();
		
		PhoneData phonedata = new PhoneData();
		Data_in data_in = new Data_in();
		Movie2 movie2 = new Movie2();
		
		
		D d = new D();
		d.GetList();
		d.getTest();
		d.list();
		
		list.add(phonedata);
		list.add(data_in);
		list.add(movie2);
		list.add(d);
		
		linked.add(phonedata);
		linked.add(data_in);
		linked.add(movie2);
		
		print_test2(linked);

		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(0));
			print_test(list.get(i));
			
			//System.out.println(list.get(i).GetList().size());
//			for (int j = 0; j < list.get(i).GetList().size(); j++) {
//				System.out.println(list.get(i).GetList().get(j));
//			}
			System.out.println("------------");
//			System.out.println(a.GetList().get(i));
//			System.out.println(b.GetList().get(i));
		}
		

		
//		a.test();
//		b.test();
	}

	
	static void print_test(I a) {
		for (int i = 0; i < a.GetList().size(); i++) {
			System.out.println(a.GetList().get(i));
		}
		
	}
	static void print_test2(List<I> list) {
		for (int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i).GetList().size());
			for (int j = 0; j < list.get(i).GetList().size(); j++) {
				System.out.println(list.get(i).GetList().get(j));
			}
			System.out.println("------------");

		}
		
	}

	static void map_test() {
		HashMap<String, Movie> map = new HashMap<String, Movie>();
		ArrayList<Movie> list_movie = new ArrayList<Movie>();
		

		for (int i = 0; i < 5; i++) {
			Movie movie = new Movie(i);
			map.put(movie.s.getTitle(), movie);
			list_movie.add(movie);
			System.out.println(movie.s.getTitle());
		}
		ArrayList<String> list = new ArrayList<String>(map.keySet());
		
		Collections.sort(list);
		Collections.sort(list_movie);
		
		System.out.println("-----------"+list.size());
		
		for(String string : list) {
			System.out.println(string);
		}
		System.out.println("=========");
		for (int i = 0; i < list_movie.size(); i++) {
			System.out.println(list_movie.get(i).s.getTitle());
		}
	}
	
}
