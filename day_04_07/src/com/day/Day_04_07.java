package com.day;

public class Day_04_07 {

	public static void main(String[] args) {
		
		
		gugudan2(20);
		
		
	}//main 대괄호
	
	//커스텀 함수
	
	static void gugudan2(int m) {
		if(m<=9)
			m = 10;
		else if(m>=21)
			m=20;
		for(int i = 2; i<m; i++) {
			gugudan(i);
			System.out.println("-------------");
		}

	}
	
	static void gugudan(int n) {
		if(n<=9) {
		for(int i = 1; i<10; i++) {
			System.out.println(n+"*"+i+"="+i*n);
			}
		}else if(n>9) {
			for(int i = 1; i<n+1; i++) {
				System.out.println(n+"*"+i+"="+i*n);
				}
		}
			
	}
	
	
	static void gugu_1(int i) {
		int i2 = i;
		System.out.println("----------------"+i+"단 시작 입니다.-------------------");
		for (int j = 1; j < 10; j++) {
			
			System.out.println(i2+" x "+j+" = "+i2*j);
			
		}
		System.out.println("==================="+i+"단 끝입니다.===================");
	}
	
	static void gugu(int i) {
		for (int i2 = i; i2 < i+1; i2++) {
			if(i2>=1) {
			System.out.println("-------------------------"+i+"단 시작 입니다.---------");
			}
			for (int j = 0; j < 10; j++) {
				
				//2단부터 9단까지 출력하기
				if(i2>=1) {
					if(j>=1) {
				System.out.println(i+" x "+j+" = "+i*j);
					}
				}
				
			}
			if(i2>=1) {
				System.out.println("==================="+i+"단 끝입니다.=====");
				}
			break;
		}
	}
	
	
	static void sum_v(int c) {
		int sum = 0;
		switch (c) {
		case 0:
			sum =sum + c;
			c++;
			//System.out.println("c: "+c+" sum :"+sum);
			//break;
		case 1:
			sum =sum + c;
			c++;
			//System.out.println("c: "+c+" sum :"+sum);
			//break;
		case 2:
			sum =sum + c;
			c++;
			//System.out.println("c: "+c+" sum :"+sum);
			//break;
		case 3:
			sum =sum + c;
			c++;
			//System.out.println("c: "+c+" sum :"+sum);
			//break;
		case 4:
			sum =sum + c;
			c++;
			//System.out.println("c: "+c+" sum :"+sum);
			//break;
		case 5:
			sum =sum + c;
			c++;
			//System.out.println("c: "+c+" sum :"+sum);
			//break;
		case 6:
			sum =sum + c;
			c++;
			//System.out.println("c: "+c+" sum :"+sum);
			//break;
		case 7:
			sum =sum + c;
			c++;
			//break;
		case 8:
			sum =sum + c;
			c+=1;

			//break;
		case 9:
			sum =sum + c;
			c+=1;

			//break;
		case 10:
			sum =sum + c;
			c++;
			//System.out.println("Total" + sum);
			//break;
		default:
			//System.out.println("초기 C값 : "+c);
			break;
		}
		System.out.println("Total : " + sum);
		
	}
	static int sum_ib(int c) {
	
		return c;
	}

	void ex_1() {
		int c = 0;
		int d = 3;
		
		switch (c) {
		case 0:
			switch(d) {
				case 3:
					
					if(d ==3) {
						System.out.println("안에서");
						break;
					}
					System.out.println("안에서 확인");
				case 2:
					System.out.println(c);
					break;
			}
			System.out.println("확인");
			//break;

		case 1:
			System.out.println("또확인");
			break;
		case 2:
			System.out.println("또또확인");
			break;
		case 3:
			
			break;
		}
		System.out.println("최종 확인");
	}

}//클래스 대괄호

	


