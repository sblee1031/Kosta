package com.day;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//이등변 삼각형 
		int h = 7;
		for (int i = 1; i <=h; i++) {
			for (int j = 1; j <=h-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <=i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
			
		}
	}

}
