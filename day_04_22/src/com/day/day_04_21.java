package com.day;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.ArrayList;

public class day_04_21 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = null;
		String text = "helloworld11133";
		File file = new File("E:/JAVA_WORK/Work/day_04_22/text/t.txt");
		
		
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(text);
			BufferedWriter w = new BufferedWriter(writer);
			w.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			System.out.println("¼º°ø");

		}
		
	}
	
	static void test() {
ArrayList<I> list = new ArrayList<I>();
		
		ArrayList<ArrayList<I>> list2 = new ArrayList<ArrayList<I>>();
		
		A a = new A();
		B b = new B();
		C c = new C();
		list.add(a);
		list.add(b);
		list.add(c);
//		System.out.println(b.getLength());
//		System.out.println(list.get(0).getLength());
//		System.out.println(list.get(1).getLength());
//		System.out.println(list.get(2).getLength());
		
		
		for (int i = 0; i < list.size(); i++) {
			ArrayList<I> list_a = new ArrayList<I>();
			for (int j = 0; j < list.get(i).getLength(); j++) {
			
				if(i==0) {
					I a2 = new A(j);
					list_a.add(a2);
				}else if(i==1) {
					I a2 = new B(j);
					list_a.add(a2);
				}else if(i==2) {
					I a2 = new C(j);
					list_a.add(a2);
				}
				//System.out.println(list2.get(i).get(i).getList().get(0));
			}
			list2.add(list_a);
			
		}
		for (int i = 0; i < list2.size(); i++) {
			for (int j = 0; j < list2.get(i).size(); j++) {
				System.out.println(list2.get(i).get(j).getList().get(0));
			}
			System.out.println("================");
		}
		
		
	}

}
