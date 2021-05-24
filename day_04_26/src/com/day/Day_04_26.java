package com.day;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;



public class Day_04_26 {
	
	public static void main(String[] args) {

//		Calendar calender = Calendar.getInstance();
//		Calendar calender2 = Calendar.getInstance();
//		
//		System.out.println(calender.get(Calendar.YEAR));
//		System.out.println(calender.get(Calendar.MONTH)+1);
//		System.out.println(calender.get(Calendar.WEEK_OF_YEAR));
//		System.out.println(calender.get(Calendar.DATE));
//		System.out.println(calender.get(Calendar.HOUR));
//		System.out.println(calender.get(Calendar.MINUTE));
//		System.out.println(calender.get(Calendar.SECOND));
//		System.out.println("=============");
		
		Calendar calender_s = Calendar.getInstance();
		Calendar calender_e = Calendar.getInstance();
		
		
//		System.out.println("원하시는 2021년도 월을 입력하시오");
		//Scanner sc = new Scanner(System.in);
		
		int year = 2021;
		//int month = Integer.parseInt(sc.nextLine());
		int month = 4;
		
		int Start_Day = 0;
		int End_Day = 0;
		
		calender_s.set(year, month-1, 1);
		calender_e.set(year, month, 1);
		calender_e.add(Calendar.DATE, -1);
		
		Start_Day = calender_s.get(Calendar.DAY_OF_WEEK);
		End_Day = calender_e.get(Calendar.DATE);
		//System.out.println("star_day : "+Start_Day);
		//System.out.println("end_day : "+End_Day);
//		System.out.println("===>"+End_Day);
//		System.out.println("===>"+calender_e.get(Calendar.DATE));
//		System.out.println("===>"+Calendar.DAY_OF_YEAR);
		System.out.println("\t\t*"+year+"년 "+month+"월 달력*\n"+"\n"
                + "일\t월\t화\t수\t목\t금\t토");
		
		for (int i = 1; i < Start_Day; i++) {
			System.out.print("\t");
		}
		
		int cnt = Start_Day -1;
		for (int i = 1; i <= End_Day; i++) {
			System.out.print(i+"\t");
			cnt++;
			if(cnt==7) {
				cnt = 0;
				System.out.println("\n");
			}
		}
		System.out.println("\n"+"======================");
		
//		try {
//			String path = "E:\\JAVA_WORK\\Work\\day_04_26\\text\\time.txt";
//			
//			File file = new File(path);
//			FileOutputStream output = new FileOutputStream(file,true);
//			
//			while(true) {
//				
//				Thread.sleep(1000);
//				
//				Calendar calender = Calendar.getInstance();
//				
//				System.out.println(calender.get(Calendar.YEAR)+"년 "+(calender.get(Calendar.MONTH)+1)
//						+"월 "+calender.get(Calendar.DATE)+"일 "+calender.get(Calendar.HOUR)+"시 "
//						+calender.get(Calendar.MINUTE)+"분 "+calender.get(Calendar.SECOND)+"초");
//
//				
//				Thread.sleep(1000);
//				
//				String text = calender.get(Calendar.YEAR)+"년 "+(calender.get(Calendar.MONTH)+1)
//						+"월 "+calender.get(Calendar.DATE)+"일 "+calender.get(Calendar.HOUR)+"시 "
//						+calender.get(Calendar.MINUTE)+"분 "+calender.get(Calendar.SECOND)+"초"+"\n";
//				
//				
//				byte[] b =text.getBytes();
//				output.write(b);
//				
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}// Thread Writer case2
		
		try {
			String path = "E:\\JAVA_WORK\\Work\\day_04_26\\text\\time.java";
			
			File file = new File(path);
			
			
			while(true) {
				
				Thread.sleep(1000);
				
				Calendar calender = Calendar.getInstance();
				
				System.out.println(calender.get(Calendar.YEAR)+"년 "+(calender.get(Calendar.MONTH)+1)
						+"월 "+calender.get(Calendar.DATE)+"일 "+calender.get(Calendar.HOUR)+"시 "
						+calender.get(Calendar.MINUTE)+"분 "+calender.get(Calendar.SECOND)+"초");

				
				Thread.sleep(1000);
				
				String text = calender.get(Calendar.YEAR)+"년 "+(calender.get(Calendar.MONTH)+1)
						+"월 "+calender.get(Calendar.DATE)+"일 "+calender.get(Calendar.HOUR)+"시 "
						+calender.get(Calendar.MINUTE)+"분 "+calender.get(Calendar.SECOND)+"초"+"\n";
				
				FileWriter writer = new FileWriter(file,true);
				writer.write(text);
				BufferedWriter w = new BufferedWriter(writer);
				w.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}// Thread Writer case2
		
		
		
//		Date date = new Date();
//		
//		System.out.println(date);
//		String format = "yyyy : mm : dd : HH:mm:ss";
//		SimpleDateFormat s = new SimpleDateFormat(format);
//		String datedata = s.format(date.getTime());
//		System.out.println(datedata);
		
	}
	static void file_stream() {
		String text = "helloworld1234";
		String path = "E:\\JAVA_WORK\\Work\\day_04_26\\text\\t.txt";
		File file = new File(path);

		try {
			FileOutputStream output = new FileOutputStream(file);
			
			byte[] b =text.getBytes();
			output.write(b);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			FileInputStream input = new FileInputStream(file);
			
//			System.out.println(input.available());
//			System.out.println(input.read());
//			System.out.println(input.available());
			int n ;
			
			byte[] b2 ;
			String text2 ="";
			String path2 = "E:\\JAVA_WORK\\Work\\day_04_26\\text\\t2.txt";
			File file2 = new File(path2);
			FileOutputStream output2 = new FileOutputStream(file2);
			
			while ((n = input.read())>0) {
				System.out.println((char)n);
				//byte[] b = input.readAllBytes();
				//output2.write(b);
				//byte b = input.read();
				text2 = (char)n+"";
				b2 = text2.getBytes();
				output2.write(b2);
				
				
			}
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("도달");
	}
	
	static void file_test() {
		String text = "helloworld";
		String path = "E:\\JAVA_WORK\\Work\\day_04_26\\text\\t.txt";
		
		File file = new File(path);
		FileWriter writer = null;
		
		
			try {
				writer = new FileWriter(file);
				writer.write(text);
				BufferedWriter w = new BufferedWriter(writer);
				w.close();
				System.out.println("test");
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
			
			try {
				FileReader reader = new FileReader(file);
				BufferedReader r = new BufferedReader(reader);
				System.out.println((char)r.read());
				System.out.println(r.readLine());
				
			} catch (Exception e) {
				
				
			}
	}

}
