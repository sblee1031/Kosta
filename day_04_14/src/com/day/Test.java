package com.day;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<int[][]> list = new ArrayList<int[][]>();
		
		int[][] array = new int[3][4];
		System.out.println("::"+array[2].length);
		
	}//메인

	static void array_test1() {
		ArrayList<int[][]> list = new ArrayList<int[][]>();
		
		int[][] array = new int[3][];
		System.out.println("::"+array.length);
		
		for (int i = 0; i < array.length; i++) {
			array[i] = new int[array.length];
			System.out.println("array[i]:"+array[i]);
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = j;
			System.out.println(array[i][j]);
			}
		}
		
		list.add(array);
		list.add(array);
		list.add(array);
		
		System.out.println("list.get(0) : "+list.get(0)[0][0]);
		
		for (int i = 0; i < list.size(); i++) {
			
			for (int j = 0; j < list.get(i).length; j++) {
				
				for (int j2 = 0; j2 < list.get(i)[j].length; j2++) {
					
					System.out.println("list["+j+"]"+"["+j2+"] : "+list.get(i)[j][j2]);
				}
			}
			
		}
	}
}//클래스
