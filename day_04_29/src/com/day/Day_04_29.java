package com.day;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

class Test2 extends Thread{
	
	public Test2() {
		
	}
	
	int count;
	public Test2(int count) {
		this.count = count;
		System.out.println(count);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread run");
	}
	
}

class Test implements Runnable{

	@Override
	public void run() {
		
		try {
			System.out.println("test이전");
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("test2 이후");
		}
		// TODO Auto-generated method stub
		System.out.println("Thread run");
	}
	
}

public class Day_04_29 {

	public static void main(String[] args) {

		Thread threadA = new ThreadA(30);
		threadA.start();
//		for (int i = 0; i < 100; i++) {
//			System.out.println("작업종료");
//		}
		System.out.println("완료");
		

	}

}
