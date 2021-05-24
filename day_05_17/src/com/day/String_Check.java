package com.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_Check {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		String S = str1;
		String T = str2;
		
		if(str1.length() != str2.length()) {
			int len = LCM(str1.length(), str1.length());
			
			while(S.length() != len) {
				S += str1;
			}
			
			while(T.length() != len) {
				T +=str2;
				
			}
		}
		if(S.equals(T)) System.out.print(1);
		else System.out.print(0);
		
	}
	static int GCD(int a,  int b) {
		while(b>0) {
			int temp = a;
			a =b;
			b= temp%b;
		}
		return a;
	}
	
	static int LCM(int a, int b) {
		return (a*b)/GCD(a,b);
	}

}
