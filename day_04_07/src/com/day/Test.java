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

	}//���� ���ȣ
	
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
	static void gugudan_10(int n) {//10��~19�� �޼���
		
		gugudan(9);//2��~9�� �޼��� ����

		for (int i = 10; i < n+1; i++) {
			
				System.out.println("~~~~~"+i+"�� ����~~~~~");
			
			for (int j = 1; j < i+1; j++) {
				
				System.out.println(i+"x"+j+" = "+i*j);

			}
			
				System.out.println("==============="+i+"�� ��...");

		}
	}		
	
	
	static void gugudan(int n) {//2��~ 9�� �޼���
		
		for (int i = 2; i < n+1; i++) {
			
			System.out.println("~~~~~"+i+"�� ����~~~~~");

			for (int j = 1; j < 10; j++) {
				
				System.out.println(i+"x"+j+" = "+i*j);

			}
			
			System.out.println("==============="+i+"�� ��...");
		}
	}

}//Ŭ���� ���ȣ
