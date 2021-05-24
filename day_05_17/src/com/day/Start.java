package com.day;

import java.util.Scanner;

public class Start {
	
	public Start() {
		super();
		// TODO Auto-generated constructor stub

	}
	public static int input(int b) {
		 int input = b;
		while(true){
			System.out.println("배달할 Kg을 입력해주세요.(3<= N <=5000)");
			Scanner input_scanner = new Scanner(System.in);
			input = input_scanner.nextInt();
			if(input<3) {
				System.out.println("입력한 숫자가 3보다 작습니다.");
				}
			else if(input>5000) {
				System.out.println("입력한 숫자가 5000보다 큽니다.");
				}
			else {
				break;
			}
		}
		return input;
	}

	
	
}
