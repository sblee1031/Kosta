package com.day;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class Day_04_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<String> calender = new ArrayList<String>();
		try {
			
			//버퍼 Writer 이용
			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				String path = "E:\\JAVA_WORK\\Work\\day_04_28\\text\\202"+i+".txt";
				File file = new File(path);
				
				for (int j = 1; j < 13; j++) {
					Calender_test.printCalender(2020+i, j);
					//Thread.sleep(10);
					calender.add(Calender_test.test);
					FileWriter writer = new FileWriter(file,true);
					writer.write(calender.get(cnt*12+j-1));
					BufferedWriter w = new BufferedWriter(writer);
					w.close();
				}
				
				cnt +=1;
			}//============

			
			
		

			
			
			
//			for (int j = 1; j < 13; j++) {
//				Calender_test.printCalender(2020, j);
//				calender.add(Calender_test.test);
//				
//			}
//			System.out.println(calender.get(3));

			
			//파일 스트림
//			for (int i = 0; i < 10; i++) {
//				String path = "E:\\JAVA_WORK\\Work\\day_04_28\\text\\202"+i+".txt";
//				File file = new File(path);
//				FileOutputStream output = new FileOutputStream(file);
//				
//				for (int j = 1; j < 13; j++) {
//					Calender_test.printCalender(2020+i, j);
//					//Thread.sleep(10);
//					calender.add(Calender_test.test);
//					byte[] b =Calender_test.test.getBytes();
//					output.write(b);
//				}
//			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
