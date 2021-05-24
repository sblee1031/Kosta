package com.day;

public class Test {

	public static void main(String[] args) {
		
		int i = 2;
		
		while(i<10) {
			int j = 1;
				while( j<10	) {
					System.out.println(i+"*"+j+"="+i*j);
					j++;
				}
			i++;
		}
		
		
	}//main ´ë°ýÈ£
	
	static void gugudan2(int m) {
		if(m<10)
			m=10;
		else if(m>=19)
			m=19;
		//System.out.println(m);
		
		//String name = "helloworld";
		//System.out.println(name.length());
		//int max = m;
		
			//gugudan(m);
		
			for (int i = 2; i < m+1 ; i++) {
				for (int j2 = 1; j2 < 10 || j2<=i; j2++) {
					System.out.println(i+"*"+j2+"="+i*j2+" ");

				}
				System.out.println("-----------");
			}
	}
	
	static void gugudan(int i) {
			for (int j = 2; j < 10; j++) {
				for (int j2 = 1; j2 < 10; j2++) {
					System.out.print(j+"*"+j2+"="+j*j2+" ");
				}
				System.out.println("==========");
				
			}
	}
	

}//Å¬·¡½º ´ë°ýÈ£
