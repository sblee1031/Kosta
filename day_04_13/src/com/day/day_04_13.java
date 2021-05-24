package com.day;

import java.util.ArrayList;

public class day_04_13 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<int[][]> list_array = new ArrayList<int[][]>();
		ArrayList<String> string_list = new ArrayList<String>();
		
		list_array.add(new int[3][3]);
		System.out.println(list_array.size());
		System.out.println(list_array.get(0)[0][0]);
		
		list.add(100);
		list.add(200);
		list.add(300);
		string_list.add("test_0");
		string_list.add("test_1");
		string_list.add("test_2");
		string_list.add(0, "test_3");
		for (int i = 0; i < string_list.size(); i++) {
			System.out.println(string_list.get(i));
		}
		
		//System.out.println("list.size : "+ list.size());
		
		//System.out.println(list.get(0));
		for (int i = 0; i < 100; i++) {
			list.add(10*(i+1));
		}
		
		int a = list.size();
		for (int i = 0; i < a; i++ ) {
			list.remove(0);
			//System.out.println(list.size());
			//System.out.println("i : "+i);
		}
		//System.out.println("size : "+list.size());
		
		for (int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i));
		}
		

		
//		for (int i = string_list.size()-1; i >= 0;  i--) {
//			string_list.remove(i);
//		}
		//System.out.println("====");
		//System.out.println(string_list.size());

		
	}//메인
	
	static int test(int c) {
		
		System.out.println(c);
		
		if(c == 0) {
			
			return c;
		}
		
		test(c-1);
		
		return c;
		
	}
	
	static void for_test() {
		for (int j = 1; j < 5; j++) {
			for (int j2 = 0; j2 < j; j2++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1;i<5;i++){
			
			for(int j=5;j>0;j--){
				
				if(i<j){
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		System.out.println("====");
		
		for(int i=1;i<5;i++){
			
			for(int j=5;j>0;j--){
				
				if(i<j){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	
	static void string_split() {
		String text = "hello=2aaa;world=3aaa;test=5;counts=7";
		String[] n_text = text.split(";");
		for (int i = 0; i < n_text.length; i++) {
			//System.out.println(n_text[i].charAt(n_text[i].length()-1));
			//int n = Integer.parseInt(n_text[i].charAt(n_text[i].length()-1)+"");
			//int j = n_text[i].indexOf("=");
			//System.out.println(j);
			int ni = Integer.parseInt(n_text[i].charAt(n_text[i].indexOf("=")+1)+"");
			
			System.out.println(ni);
			
			//System.out.println(n*10);
			
			//System.out.println(n_text[i].indexOf("="));
		}
	}
	
	static void lotto_test() {
		int[] lotto = new int [45];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i+1;
			//System.out.println(lotto[i]);
		}
		
		for (int i = 0; i < 1000; i++) {
			int r = (int)(Math.random()*44)+1;
			int temp = lotto[0];
			lotto[0] = lotto[r];
			lotto[r] = temp;
			
		}
		int[] lotto2 = new int[6];
		for (int i = 0; i < lotto2.length; i++) {
			lotto2[i] = lotto[i+20];
			//System.out.println(lotto[i]);
		}
		
		for (int i = 0; i < lotto2.length; i++) {
			for (int j = i+1; j < lotto2.length; j++) {
				if(lotto2[i] > lotto2[j]) {
					int temp = lotto2[i];
					lotto2[i] = lotto2[j];
					lotto2[j] = temp;
					
				}
			}
			System.out.println(lotto2[i]);
		}
	}
	
	static void text_test() {
		String text = "위키백과는 종이 기반 참고 자료와는 아주 다르게 실시간으로 함께 편집합니다. "
				+ "위키백과는 끊임없이 새로 만들어지고 갱신되므로 역사적 "
				+ "사건에 관한 항목은 수분 내에 생성됩니다. 반면에 종이 기반 "
				+ "백과사전에서는 이와 같은 과정이 수개월이나 수년이 걸립니다. "
				+ "오래 전에 생성된 항목은 시간이 가면서 점점 더 일반화되고 "
				+ "중립적 시각으로 변합니다. 새로 만들어진 항목은 잘못된 정보, "
				+ "백과사전에 싣기에 부적절한 내용 또는 문서를 훼손하는 "
				+ "내용을 포함할 수 있습니다. 이 점을 주의하면 유용한 정보를 취하고 "
				+ "잘못된 정보를 피하는 데 도움이 됩니다";

				String t = text.trim();
				t= t.replace(" ", "");
				char[] ca = new char[t.length()];
				String ns ="";
				for (int i = 0; i < ca.length; i++) {
					ca[i] = t.charAt(i);
					ns += ca[i];
					//System.out.println(ca[i]);
				}
				char[] ca2 = t.toCharArray();
				System.out.println(ca2);
				for (int i = 0; i < ca2.length; i++) {
					for (int j = 1+i; j < ca2.length; j++) {
						if(ca2[i] == ca2[j]) {
							ca2[j] = ' ';
							//System.out.println(ca2[i]);
						}
					}
				}
				for (int i = 0; i < ca2.length; i++) {
					ns += ca2[i];
				}
				t = ns.replace(" ", "");
				char[] c3 = t.toCharArray();
				for (int i = 0; i < c3.length; i++) {
					System.out.println(c3[i]);
				}
				
				
				
//				char[] ca = new char[text.length()];
//				int count_e = 0;
//				int count_n = 0;
//				for (int i = 0; i < text.length(); i++) {
//					ca[i] = text.charAt(i);
//						if(ca[i] == '는') {
//							count_n +=1;
//						}else if(ca[i] == '으') {
//							count_e +=1;
//						}
//				}
//				System.out.println("으 : "+count_e+" / 는 : "+ count_n);
	}

}//클래스
