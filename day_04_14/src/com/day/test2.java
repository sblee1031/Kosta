package com.day;

import java.util.ArrayList;
import java.util.LinkedList;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<Integer> list_i	 = new LinkedList<Integer>(list);
		
		ArrayList<int[]> int_alist = new ArrayList<int[]>();
		int[] array_int = new int[10];
		for (int i = 0; i < array_int.length; i++) {
			array_int[i] = i;
		}
		//System.out.println(array_int[8]);
		int_alist.add(array_int);
		int_alist.add(array_int);
		int_alist.add(array_int);
		int_alist.add(array_int);
		System.out.println(int_alist.size());
		//System.out.println("array_int 사이즈 : "+int_alist.get(0).length);
		
		int[][] list2 = new int[int_alist.size()][];
		
		for (int i = 0; i < int_alist.size(); i++) {//list2 개수
			
			list2[i] = new int[int_alist.get(i).length]; // list[i] 개수
			
			for (int j = 0; j < int_alist.get(i).length; j++) {
				
				list2[i][j] = int_alist.get(i)[j];
				
				System.out.println("list2["+i+"]"+"["+j+"] : "+list2[i][j]);
			}
			
		}
		System.out.println("======");
		
		for (int i = 0; i < int_alist.size(); i++) {
			System.out.println(int_alist.get(i));
			for (int j = 0; j < int_alist.get(i).length; j++) {
				System.out.println(int_alist.get(i)[j]);
			}
		}
		
	}

}
