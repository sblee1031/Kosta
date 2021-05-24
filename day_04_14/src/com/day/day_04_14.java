package com.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day_04_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<int[][]> list_a2= new ArrayList<int[][]>();
		int[] raay_int = {100,200,300};
		int[][] array_int2 = {raay_int,{5,6,7,8,9},{50,60,100,200,300}};
		int[][][] array_2 = {{{0,1,2},{2,3,4,},{5,6,7}},{{0,1,2},{3,4,5}},{{1,2,3},{5,67,7}}};
		//System.out.println(array_int2.length);
		//System.out.println(array_int2[0].length);
		System.out.println(array_int2[1][0]);
		list_a2.add(array_int2);
		//list_a2.add(array_int2);
		//list_a2.add(array_int2);
		
		System.out.println("list_a2 size : "+list_a2.size());
		
		for (int i = 0; i < list_a2.size(); i++) {
			// = array_int2[i].length;
			for (int j = 0; j < list_a2.get(i).length; j++) {
				for (int j2 = 0; j2 < list_a2.get(i)[j].length; j2++) {
					
					System.out.print(list_a2.get(i)[j][j2]+"/");
				}
				System.out.println();
			}
			System.out.println("==========");
		}
		System.out.println("============3차 끝");
		
		int[][][] int_a3 = new int[list_a2.size()][][];
		//list_a2.add(array_int2);
		//list_a2.add(array_int2);
		System.out.println(list_a2.size());
		System.out.println(list_a2.get(0).length);
		System.out.println(list_a2.get(0)[0].length);
		System.out.println(list_a2.get(0)[0][0]);
		System.out.println("=========Test===============");
		
		for (int i = 0; i < list_a2.size(); i++) {
			
			int_a3[i] = new int[list_a2.get(i).length][];
			System.out.println("list_a2.get(i).length"+list_a2.get(i).length);
			
			for (int j = 0; j < list_a2.get(i).length; j++) {
				
				int_a3[i][j] = new int[list_a2.get(i)[j].length];
				System.out.println("list_a2.get(i)[j].length"+list_a2.get(i)[j].length);
				
				for (int j2 = 0; j2 < list_a2.get(i)[j].length; j2++) {
					System.out.println("list_a2.get(i)[j].length"+list_a2.get(i)[j].length);
					//System.out.println("==="+list_a2.get(i)[j].length);					
					int_a3[i][j][j2] = list_a2.get(i)[j][j2];
										
					System.out.println("list_a2["+i+"]"+"["+j+"]"+"["+j2+"] : "+int_a3[i][j][j2]);
				}
				
			}
		}
		
		
		
	}//메인

	static void list_array() {
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
	static void timeCurrent(List<Integer> l) {
		double startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			l.add((i+1)*10);
			
		}
		for (int i = 0; i < 10000; i++) {
			l.remove(0);
		}
		double endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

	
}//클래스
