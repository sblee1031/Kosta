package com.day;

public class Gugudan_inner {
	
	String[] gugudan_array = new String [9];
	
	int gugu_i = 300;
	
	public Gugudan_inner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gugudan_inner(int n) {
		
		//ArrayList <String> save = new ArrayList<String>();
		
		for (int i = 1; i <10; i++) {
			
			String a = n+"*"+i+"="+n*i;
			
			gugudan_array[i-1] = a;
			
			System.out.print(a+"\t");
			
			//save.add(a);
			
		}
		
		
	}
	public Gugudan_inner(int n, int m) {
		
		//ArrayList <String> save = new ArrayList<String>();
		
		for (int i = 1; i <m+1; i++) {
			
			String a = n+"*"+i+"="+n*i;
			
			gugudan_array[i-1] = a;
			
			System.out.print(a+"\t");
			
			//save.add(a);
			
		}
		
		
	}

}
