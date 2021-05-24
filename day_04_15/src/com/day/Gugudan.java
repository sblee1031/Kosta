package com.day;

import java.util.ArrayList;

public class Gugudan {
	
	ArrayList<Gugudan_inner> save = new ArrayList<Gugudan_inner>();
	
	int gugu_i = 0;
	
	public Gugudan() {
		
//		ArrayList<Gugudan_inner> save = new ArrayList<Gugudan_inner>();
//		System.out.println("Gugudan size : "+save.size());
		
		//System.out.println("备备窜 积己磊");
//		for (int i = 2; i < 10; i++) {
//			//System.out.println("2 *"+i+"="+i*2);
//			Gugudan_inner gugudan = new Gugudan_inner(i);
//			System.out.println("----------");
//		}

	}

	public void Gugudan_method() {
		
		for (int i = 2; i < 10; i++) {
			
			Gugudan_inner gugudan = new Gugudan_inner(i);
			save.add(gugudan);
			System.out.println("----------");
		}
		for (int i = 0; i < save.size(); i++) {
			
			System.out.println(save.get(i));
		}
	}
	public void Gugudan_method(int c) {
		
		gugu_i = c;
		//System.out.println("gugu_i :"+gugu_i);
		
		for (int i = c; i < 10; i++) {
			
			Gugudan_inner gugudan = new Gugudan_inner(i);
		
			save.add(gugudan);
			
			System.out.println("----------");
		}
		
	}
	public void Gugudan_method(int c, int d) {
		for (int i = c; i < d+1; i++) {
			
			Gugudan_inner gugudan = new Gugudan_inner(i,d);
			
			save.add(gugudan);
			
			System.out.println("----------");
		}
	}
	public void Gugudan_method(int c, int d, int m) {
		gugu_i = m;
		for (int i = c; i < d+1; i++) {
			
			Gugudan_inner gugudan = new Gugudan_inner(i,m);
			
			save.add(gugudan);
			
			System.out.println("----------");
		}
	}
}
