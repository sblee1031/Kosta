package com.day;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		gugudan2(5);
		
//		for (int i = 1; i <= 10; i++) {
//			
//			for (int j = 1; j < 10; j++) {
//				
//				System.out.println(i+"x"+j+" = "+i*j);
//
//			}
//		}

	}//메인 대괄호
	
	static void gugudan2(int m) {
		if(m<=9) {
			
			m=9;
			
			gugudan(m);
		
		}else if(m<20){
			
			gugudan_10(m);
			
		}else if(m>20){
			
			m=19;
			
			gugudan_10(m);
			
		}
		
	}
	static void gugudan_10(int n) {//10단~19단 메서드
		
		gugudan(9);//2단~9단 메서드 진행

		for (int i = 10; i < n+1; i++) {
			
				System.out.println("~~~~~"+i+"단 시작~~~~~");
			
			for (int j = 1; j < i+1; j++) {
				
				System.out.println(i+"x"+j+" = "+i*j);

			}
			
				System.out.println("==============="+i+"단 끝...");

		}
	}		
	
	
	static void gugudan(int n) {//2단~ 9단 메서드
		
		for (int i = 2; i < n+1; i++) {
			
			System.out.println("~~~~~"+i+"단 시작~~~~~");

			for (int j = 1; j < 10; j++) {
				
				System.out.println(i+"x"+j+" = "+i*j);

			}
			
			System.out.println("==============="+i+"단 끝...");
		}
	}

}//클래스 대괄호
