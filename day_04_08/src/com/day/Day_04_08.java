package com.day;

public class Day_04_08 {

	public static void main(String[] args) {
		
//		String name = "helloworld";
//		//System.out.println(name.length());
//		int max = name.length();
//		
//		for (int i = 2; i < max; i++) {
//
//			gugudan(i);
//			System.out.println("-----------");
//		}
		// TODO Auto-generated method stub
		
		
		gugudan2(15);
		//gugudan(9);
		

	}//main ´ë°ýÈ£
	
	static void gugudan2(int m) {
		if(m<10)
			m=10;
		else if(m>21)
			m=20;
		System.out.println(m);
		
		//String name = "helloworld";
		//System.out.println(name.length());
		int max = m;
		
		if(max>9) {
			gugudan(m);
			for (int i = 10; i < max+1; i++) {
				for (int j2 = 1; j2 < i+1; j2++) {
					System.out.print(i+"*"+j2+"="+i*j2+" ");

				}
				System.out.println("-----------");
			}
		}
	}
	
	static void gugudan(int i) {
			for (int j = 2; j < 10; j++) {
				for (int j2 = 1; j2 < 10; j2++) {
					System.out.print(j+"*"+j2+"="+j*j2+" ");
				}
				System.out.println("==========");
				
			}
	}
	

}//Å¬·¡½º ´ë°ýÈ£
