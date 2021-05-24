package com.day;

public class Day_05_17 extends Start {

	
	public static void main(String[] args) {//설탕 배달 예제
		// TODO Auto-generated method stub
		int bongJi = 0;
		int input = 0;
		
		input = input(input); //값을 입력 받는 Scanner 후 input값 반환
		
		while(input > 0){
			if(input % 5 == 0){
				input -=5;
				bongJi++;
			}
			else if(input % 3 ==0){
				input -=3;
				bongJi++;
			}
			else if(input > 5){
				input -=5;
				bongJi++;
			}
			else{
				bongJi = -1;
				break;
			}
			
		}
		System.out.println("결과 값 : "+bongJi);
		System.out.println("종료");
	}

}
