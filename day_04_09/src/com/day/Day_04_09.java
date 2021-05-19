package com.day;

public class Day_04_09 {

	public static void main(String[] args) {
		
//		int a = 3;
//		int b = 7;
//		int c = 11;
//		int d = 100;
//		int e = 2;
//		int f = 300;
//		
//		int[] array_int = new int [6];
//		
//		array_int[0] = a;
//		array_int[1] = b;
//		array_int[2] = c;
//		array_int[3] = d;
//		array_int[4] = e;
//		array_int[5] = f;

		
//		for (int i = 0; i < array_int.length; i++) {
//			System.out.println(array_int[0]);
//			
//		}
		int[] lotto = new int[45];
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i+1;
			//System.out.println(lotto[i]);
		}
		
//		int[] array_int2 = new int[100];
//		
//		for (int i = 0; i < array_int2.length; i++) {
//			array_int2[i] = i+1;
//			
//			System.out.print(array_int2[i]+" ");
//		}
//		System.out.println("\n===========");
//		
//		for (int i = array_int2.length-1; i >= 0; i--) {
//			System.out.print(array_int2[i]+" ");
//		}
//		System.out.println(" ");
		
		int[] array_int3 = new int[300];
		
		for (int i = 0; i < array_int3.length; i++) {
			array_int3[i] = (int)(Math.random()*300);
			//System.out.println(array_int3[i]);
		}
		
//		int count = 0;
//		for (int i = 0; i < array_int3.length; i++) {
//			for (int k = 0; k < lotto.length; k++) {
//				if(array_int3[i]==lotto[k]) {
//					count += 1;
//				}
//			}
//		}
//		System.out.println("count : "+ count);
		
		for(int i = 0; i<1000; i++) {
			int r = (int)(Math.random()*44)+1;
			int temp = lotto[0];
			lotto[0] = lotto[r];
			lotto[r] = temp;
		}
		
		for(int i = 0; i<lotto.length; i++) {
			System.out.println(lotto[i]);
		}
		
//		int[] lotto2 = new int[6];
//		for (int i = 0; i < 6; i++) {
//			lotto2[i] = lotto[i]; 
//			System.out.println(" i : "+ i + " :"+ lotto2[i]);
//		}
//			System.out.println("====오늘의 로또 번호=====");
//			
//		for (int i = 0; i < lotto2.length; i++) {
//			for (int k = i+1; k < lotto2.length; k++) {
//				if(lotto2[i] > lotto2[k]) {
//					int temp = lotto2[i];
//					lotto2[i] = lotto2[k];
//					lotto2[k] = temp;
//				}
//			}
//			System.out.println(" i : "+ i + " :"+ lotto2[i]);
//		}

//		int r = (int)(Math.random()*300);
//		System.out.println(r);
		


	}//main 메서드
	
	
	
	static void array_a() {
		int a = 100;
		int b = 50;
		int c = 200;
		int d = 23;
		
		int[] array_i = {a,b,c,d};
		
		System.out.println("배열 마지막 값 : "+array_i[array_i.length-1]);
		
		for (int i = 0; i < array_i.length; i++) {
			System.out.println((i+1)+"번 배열 값 : "+array_i[i]);
			
		}
		
		System.out.println("오름차순 정렬");
		for (int i = 0; i < array_i.length; i++) {
			for(int j = i+1; j < array_i.length; j++) {
				if(array_i[i] >= array_i[j]) {
				int temp = array_i[i];
				array_i[i] = array_i[j];
				array_i[j] = temp;
				}
			}
		}
		for (int i = 0; i < array_i.length; i++) {
			System.out.println(array_i[i]);
		}
		
//		int a = 3;
//		int b = 6;
//		int c = 4;
//		int d = 100;
//		int e = 1000;
//		
//		int[] array_int = null;
//		array_int = new int[] {a,b,c,d,e};
//		
//		for (int i = 0; i < array_int.length; i++) {
//			for (int j = i+1; j < array_int.length; j++) {
//				if(array_int[i] >= array_int[j]) {
//					
//					int temp = array_int[i];
//					array_int[i] = array_int[j];
//					array_int[j] = temp;
//					System.out.println("성공");
//					
//				}
//			}
//			
//		}
//		for (int i = 0; i < array_int.length; i++) {
//			System.out.println(array_int[i]);
//
//		}
	}
	
	static void test() {
		int a = 3;
		int b = 6;
		int c = 5;
		
		int[] array_a = {1,2,3,4,5};
		
		int[] array_b = new int[] {1,2,3,4,5,6};
		
		int[] array_c = null;
		array_c = new int[] {1,2,3,4,5,6};
		
		
		int[] array_int = new int[3];
		array_int[0] = 7;
		array_int[1] = 1;
		array_int[2] = 11;
		
		
		int[] array_int1 = new int[8];
		for (int i = 0; i < array_int1.length; i++) {
			if(i >=5)
				continue;
			array_int1[i] = i*100;
			System.out.println(array_int1[i]);
			
		}
		//System.out.println(array_int[array_int.length-1]);
		
		
		
		if(a < b) {
			int temp = a;
//			System.out.println("temp : "+temp);
			a = b;
			b = temp;
//			System.out.println("a3 :" + a);
//			System.out.println("b6 :" + b);
//			System.out.println("a :"+a+" b : "+b+" c : "+c);
			
			if(a < c) {
				int temp2 = a;
//				System.out.println("temp2 :"+temp);
				a = c;
				c = temp2;
				
				temp = b;
				b = c;
				c = temp;
//				System.out.println("b6 :" + b);
//				System.out.println("c4 :" + c);	
//				System.out.println("a :"+a+" b : "+b+" c : "+c);
//				System.out.println("a<c");

			}else {
				temp = a;
//				System.out.println("temp3 :"+temp);
				a = c;
				c = temp;
//				System.out.println("a3 :" + a);
//				System.out.println("c4 :" + c);	
//				System.out.println("a<c");
				
			}
//			System.out.println("a :"+a);
//			System.out.println("b : "+b);
//			System.out.println("c : "+c);

		}
	}

}
