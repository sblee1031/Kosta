package com.day;

public class A implements i_interface{

	
	public A() {
		
		for (int i = 1; i < 10; i++) {
			System.out.println("3"+" X "+i +" = "+3*i);
		}
		System.out.println("a 持失切");
		
	}
	public A(int n) {
		
		for (int i = 1; i < 10; i++) {
			System.out.println(n+" X "+i +" = "+n*i);
		}
		
		
	}
	public A(String n) {
		System.out.println("a 持失切");
		
	}
	@Override
	public void test() {
		System.out.println("test");
		
	}

	
}
