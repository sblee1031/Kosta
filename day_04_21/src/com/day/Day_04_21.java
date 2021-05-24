package com.day;

import java.util.ArrayList;

public class Day_04_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ArrayList<I> list_a = new ArrayList<I>();
		
		A a1 = new A();
		B b1 = new B();
		C c1 = new C();
		
		for (int i = 0; i < a1.name.length; i++) {
		A a = new A(i);
		list_a.add(a);
		//System.out.println(list_a.get(i).getList().get(0));
		}
		for (int i = 0; i < b1.name.length; i++) {
		B b = new B(i);
		list_a.add(b.bs);
		//System.out.println(list_a.get(i).getList().get(0));
		}
		for (int i = 0; i < c1.title.length; i++) {
		C c = new C(i);
		list_a.add(c.cs);
		//System.out.println(list_a.get(i).getList().get(0));
		}
		System.out.println(list_a.size());
		for (int i = 0; i < list_a.size(); i++) {
			System.out.println(list_a.get(i).getList().get(0));
		}
		
//		ArrayList<A> list_a = new ArrayList<A>();
//		ArrayList<B> list_b = new ArrayList<B>();
//		ArrayList<C> list_c = new ArrayList<C>();
//		
//		A a1 = new A();
//		B b1 = new B();
//		C c1 = new C();
//		
//		for (int i = 0; i < a1.name.length; i++) {
//			A a = new A(i);
//			list_a.add(a);
//			System.out.println(list_a.get(i).as.getList().get(0));
//		}
//		for (int i = 0; i < b1.name.length; i++) {
//			B b = new B(i);
//			list_b.add(b);
//			System.out.println(list_b.get(i).bs.getList().get(0));
//		}
//		for (int i = 0; i < c1.title.length; i++) {
//			C c = new C(i);
//			list_c.add(c);
//			System.out.println(list_c.get(i).cs.getList().get(0));
//		}
		
		
		
	}

}
