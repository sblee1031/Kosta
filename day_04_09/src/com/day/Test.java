package com.day;

class Calculator{
	
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] lotto = new int[45]; //1���� 45���� �迭
		
		for (int i = 0; i < lotto.length; i++) {
			
			lotto[i] = (i+1);
			
			//System.out.println(lotto[i]);
		}
		
		int [] lotto2 = new int[6]; //6�� ��÷ �迭
		
		
		
		
		for(int i = 0; i < 1000; i++) {
			
			int r = (int)((Math.random()*44)+1);
			int temp = lotto[0];
			lotto[0] = lotto[r];
			lotto[r] = temp;
			
			
		}
		
//		for(int i = 0; i <lotto.length; i ++) {
//			
//			System.out.println(lotto[i]);
//		}
		
		System.out.println("======�α� �α� ������ ��÷��ȣ=====");
		
		for(int i = 0; i < lotto2.length; i++) {
			lotto2[i] = lotto[i];
			System.out.println(lotto2[i]);
		}
		
		System.out.println("=======���� ���ġ�=======");
		
		for(int i = 0; i < lotto2.length; i++) {
			for(int j = i+1; j < lotto2.length; j++) {
				if(lotto2[i] > lotto2[j]) {
					int temp = lotto2[i];
					lotto2[i] = lotto2[j];
					lotto2[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < lotto2.length; i++) {
			System.out.println(lotto2[i]);
		}
		
		System.out.println("=======���� ���ġ�=======");
		
		for(int i = 0; i < lotto2.length; i++) {
			for(int j = i+1; j < lotto2.length; j++) {
				if(lotto2[i] < lotto2[j]) {
					int temp = lotto2[i];
					lotto2[i] = lotto2[j];
					lotto2[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < lotto2.length; i++) {
			System.out.println(lotto2[i]);
		}
		
		
//		int r = (int)(Math.random()*100);
//		
//		System.out.println(r);
//		
//		System.out.println((int)(Math.random()*10));

	}//���� �޼���
	
	static void oreum() {
		
//		for(int i = 0; i < lotto.length; i++) {
//			for(int j = i+1; j<lotto.length; j ++) {
//				if(lotto[i]<lotto[j]) {
//
//					int temp = lotto[i];
//					lotto[i] = lotto[j];
//					lotto[j] = temp;
//				}
//			}
//			System.out.println(lotto[i]);
//		}
	}

}//Ŭ���� �޼���
