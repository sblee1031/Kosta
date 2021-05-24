package com.day;

public class A implements Comparable<A>{
	
	
	
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}

	public A(int count, String str) {
		super();
		this.str = str;
		this.count = count;
	}

	String str = "";
	
	int count;
	
	@Override
	public int compareTo(A o) {
		
		return this.str.length() - o.str.length() ;
	}
	
//	@Override
//	public int compareTo(A o) {
//		
//		return this.str.compareTo(o.str) ;
//	}
	
	
//	@Override
//	public int compareTo(A o) {
//		//str_int = str.length();
//		if(o.count < this.count) {
//			System.out.println("true 0 :"+this.count);
//			return 1;
//			
//		}else if (o.count > this.count){
//			System.out.println("true 1 : "+o.count);
//			return -1;
//			
//		}else {
//			//System.out.println("test : "+this.str.compareTo(o.str));
//			return 0;
//		}
//			
		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public int compareTo(A o) {
//		//str_int = str.length();
//		if(o.str.length() < this.str.length()) {
//			return 1;
//			
//		}else if (o.str.length() > this.str.length()){
//			return -1;
//			
//		}else
//			return this.str.compareTo(o.str);
//		// TODO Auto-generated method stub
//		
//	}
	
	

}
