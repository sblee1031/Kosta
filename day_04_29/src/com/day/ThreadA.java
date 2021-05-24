package com.day;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ThreadA extends Thread{
	int m ;
	public ThreadA(int m) {
		
		this.m = m;
	}

	@Override
	public void run() {
		ArrayList<String> calender = new ArrayList<String>();
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				Thread.sleep(500);
			}
			String text = "helloworld";
			File file = new File(".\\FileDays\\t.txt");
			File file2 = new File(".\\FileDays");
			
			try {
				if(file2.exists()) {
					System.out.println("폴더있음");
				}else {
					System.out.println("폴더없음");
					file2.mkdir();
				}
				
				FileWriter writer = new FileWriter(file);
				writer.write(text);
				BufferedWriter w = new BufferedWriter(writer);
				w.close();
			} catch (Exception e) {
				// TODO: handle exception
			}		
			
			
//				System.out.println("출력이전");
//				//버퍼 Writer 이용
//					int cnt = 0;
//					for (int i = 0; i < m; i++) {
//						String path = "E:\\JAVA_WORK\\Work\\day_04_29\\text\\"+(2000+i)+".txt";
//						File file = new File(path);
//						
//						for (int j = 1; j < 13; j++) {
//							Calender_test.printCalender(2000+i, j);
//							Thread.sleep(500);
//							calender.add(Calender_test.test);
//							FileWriter writer = new FileWriter(file,true);
//							writer.write(calender.get(cnt*12+j-1));
//							BufferedWriter w = new BufferedWriter(writer);
//							w.close();
//						}
//						cnt +=1;
//					}//============
		} catch (Exception e) {
			// TODO: handle exception
		}

	
	
	}
	

}
