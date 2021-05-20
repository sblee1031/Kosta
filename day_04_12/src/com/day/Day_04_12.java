package com.day;

public class Day_04_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "hello/world/best/city";
		String[] array_text = text.split("/");
		
		//System.out.println(array_text.length);
		
		char[][] c = new char[array_text.length][];
		System.out.println(c.length);
		for (int i = 0; i < c.length; i++) {
			c[i] = new char [array_text[i].length()];
			System.out.print(c[i].length);
			
			for (int j = 0; j < array_text[i].length(); j++) {
				c[i][j] = array_text[i].charAt(j);
				System.out.print(c[i][j]);
			}
			System.out.println(" ");
		}
		
		
		
	}//main 클래스
	
	static void char_text2() {
		boolean[] is_array = new boolean[2];
		boolean[][] is_array2 = new boolean[2][];
		is_array2[0] = new boolean[2];
		
		
		System.out.println(is_array2[0][0]);
		is_test(is_array2[0]);
		//is_array2[0][0] = true;
		System.out.println(is_array2[0][0]);
		
		int[] array_int = new int[2];
		int[][] array_int2 = new int[2][];
		array_int2[0] = new int[2];
		array_int2[1] = new int[2];
		array_int2[0] = array_int2[1];
		
//		System.out.println(array_int2[0]);
//		System.out.println(array_int2[1]);
		array_int2[0][0] = 300;
		int[] s = new int[1];
		s = array_int2[0];
		System.out.println(array_int2[0]);
		System.out.println(array_int2[1]);
		System.out.println(s);
		s[0] = 800;
		System.out.println(array_int2[1][0]);
		
		
		
		String texts = "hello world test count";
		String[] array_string = texts.split("\s");
		char[][] c_text = new char[array_string.length][];
		//System.out.println(array_string.length);
		for (int i = 0; i < array_string.length; i++) {
			//System.out.println(array_string[i].length());
			//System.out.println(array_string[i]);
			
		}
		System.out.println("=====");
		
		for (int i = 0; i < array_string.length; i++) {
			
				c_text[i] = new char[array_string[i].length()];
				//System.out.println(array_string[i].length());
				//System.out.println("======");
				
				for (int j = 0; j < c_text[i].length; j++) {
					c_text[i][j] = array_string[i].charAt(j);
					System.out.print(c_text[i][j]);
				}
				System.out.print(" ");
		}
	}
	
	static void is_test(boolean b) {
		System.out.println("첫b: "+b);
		b = true;
		System.out.println("둘b : "+b);
	}
	static void is_test(boolean[] b) {
		b[0] = true;
	}
	
	static String string_text3(String[] n) {
		n[0] = "change";
		return "";
	}
	static String string_text3(String n) {
		n = "change";
		return "";
	}
	
	static char char_text3(char[] n) {
		n[0] = 'a';
		return '1';
	}
	static char char_text3(char n) {
		n = 'a';
		return '1';
	}
	
	static String text;
	static String text_f() {
		return new String ("helloworld");
	}
	static String text_t() {
		return text;
	}
	
	static void array_test() {
		int[] array = new int[3];
		int[] array_1 = new int[3];
		int[] array_2 = new int[3];

		for (int i = 0; i < array.length; i++) {
			array[i] = (i+1)*100;
			array_1[i] = (i+1)*100;
			array_2[i] = (i+1)*100;
			
		}
		
		
		int[][] array2 = new int[3][];
		array2[0] = new int[3];
		array2[1] = new int[3];
		array2[2] = new int[3];
		array2[0][0] = 100;
		array2[0][1] = 100;
		array2[0][2] = 100;
		
		
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				array2[i][j] = ((i+1)+j)*100;
				
				System.out.println(array2[i][j]);

			}
		}
	}

	static int toString_test(int n) {
		n = 600;
		return n;
	}
	
	static int toString_test(int[] n) {
		n[0] = 500;
		return n[0];
	}
	
	static void toString_test() {

		String text = "helloworld";
		char[] cs = new char[text.length()];
		for (int i = 0; i < text.length(); i++) {
			cs[i] = text.charAt(i);
			if(text.contains("he")) {
				//System.out.println("text");
			}
		}
	
		int[] a = {100, 200};
		toString_test(a);
		System.out.println("int배열 " + a[0]);
		toString_test(a[0]);
		System.out.println("int 입니다 " + a[0]);
	}

	static void char_test() {
		int[][] array2 = new int[3][];
		array2[0] = new int[3];
		array2[1] = new int[3];
		array2[2] = new int[3];
		
		String[] ns = new String[2];
		//ns[0] = "100";
		string_text3(ns[0]); //value 타입
		System.out.println("String : "+ns[0]);
		
		//System.out.println(ns[0]);
		
		string_text3(ns); //참조 타입
		System.out.println("String[] : "+ ns[0]);
		
		System.out.println("=======");
		
		char[] ns1 = new char[2];
		//ns1[0] = '9';
		char_text3(ns1[0]); //value 타입
		System.out.println("char : " +ns1[0]);
		
		//System.out.println(ns[0]);
		
		char_text3(ns1); //참조 타입
		System.out.println("char[] : " + ns1[0]);
	}
	
	
}//클래스
