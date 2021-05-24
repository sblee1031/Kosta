package com.day;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class day_04_23 {
	
	static void test() {
		A a = new A();
		B b = new B();
		C c = new C();
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list_b = new ArrayList<String>();
		ArrayList<String> list_c = new ArrayList<String>();
		for (int i = 0; i < a.name.length; i++) {
			
			list.add(a.name[i]+" / "+a.age[i]+" / "+a.address[i]+" / "+a.phone[i]+" / "+a.gender[i]+"\n");
			//list.add("\n");
		}
		for (int i = 0; i < b.name.length; i++) {
			B b2 = new B(i);
			list_b.add(b2.text);
			//System.out.print(list_b.get(i));
		}
		for (int i = 0; i < c.title.length; i++) {
			
			list_c.add(c.title[i]+" / "+c.director[i]+" / "+c.genre[i]+" / "+c.count[i]+" / "+c.actor[i]+" / "+c.actress[i]+" / "+c.time[i]+"\n");
			//list.add("\n");
			//System.out.println(list_c.get(i));
		}
		
		String text = "------helloworld-----\n";
		String file_path = "E:/JAVA_WORK/Work/day_04_23/text/t_";
		File file = new File("E:/JAVA_WORK/Work/day_04_23/text/t_1.txt");
		File file2 = new File("E:/JAVA_WORK/Work/day_04_23/text/t_2.txt");
		File file3 = new File("E:/JAVA_WORK/Work/day_04_23/text/t_3.txt");
		String test = "";
		
		
		try {
			FileWriter writer = new FileWriter(file);
			//writer.write(text);
			//System.out.println("list size : "+list.size());
				for (int i = 0; i < list.size(); i++) {
					writer.write(list.get(i));
	//				writer.write(list.get(2));
				}
			BufferedWriter w = new BufferedWriter(writer);
			w.close();
			
			
			FileWriter writer2 = new FileWriter(file2);
			//writer.write(text);
				for (int i = 0; i < list_b.size(); i++) {
					writer2.write(list_b.get(i));
				}
			BufferedWriter w2 = new BufferedWriter(writer2);
			w2.close();
			
			
			//writer.write(text);
			FileWriter writer3 = new FileWriter(file3);
				for (int i = 0; i < list_c.size(); i++) {
					//System.out.println(list_c.get(i));
					writer3.write(list_c.get(i));
				}
			
			BufferedWriter w3 = new BufferedWriter(writer3);
			w3.close();
			test = "정상적으로 처리되었습니다.";
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			test = "비정상적으로 처리되었습니다." + e.getMessage();
		}finally {
			System.out.println(test);
		}
		System.out.println("도달");
	}

	static void test2() {
		A a = new A();
		B b = new B();
		C c = new C();
		
		ArrayList<String> list_t = new ArrayList<String>();
		
		list_t.add(a.data_text());
		
		list_t.add(b.data_text());
		
		list_t.add(c.data_text());

		
		File file = null;
		String test = "";
		
		try {
			
			
			FileWriter writer = null;
			BufferedWriter w = null;;
			char ch = 65;
			System.out.println(ch);
			//writer.write(text);
			//System.out.println("list size : "+list.size());
				for (int i = 0; i < list_t.size(); i++) {
					file =new File("E:/JAVA_WORK/Work/day_04_23/text/"+(char)(ch+i)+".txt");
					writer = new FileWriter(file);
					writer.write(list_t.get(i));
					w = new BufferedWriter(writer);
	//				writer.write(list.get(2));
					w.close();
				}
			
			
			
			
			
			test = "정상적으로 처리되었습니다.";
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			test = "비정상적으로 처리되었습니다." + e.getMessage();
		}finally {
			System.out.println(test);
		}
		System.out.println("도달");
	}
	public static void main(String[] args)  {
		char ch = 65;
		String file = "";
		
//		for (int i = 0; i < 3; i++) {
//			file ="E:/JAVA_WORK/Work/day_04_23/text/"+(char)(ch+i)+".txt";
//		}
		
		File file2 = new File("E:\\JAVA_WORK\\Work\\day_04_23\\text\\d.txt");
		
		try {
			
			
			for (int i = 0; i < 3; i++) {
				file ="E:/JAVA_WORK/Work/day_04_23/text/"+(char)(ch+i)+".txt";
			
			FileReader reader = new FileReader(file);
//			int c = reader.read();
//			System.out.println(c);
			BufferedReader r = new BufferedReader(reader);
			
			
			int c = 0;
			
			while((c = r.read()) != -1) {
			
			System.out.print((char)c);
			
		}
		System.out.println(file+"//==끝=="+"\n");
			
//			String rc = "";
//			
//				while((rc = r.readLine()) != null) {
//					
//					System.out.println(rc);
//					
//				}
//				System.out.println(file+"//==끝=="+"\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

}
