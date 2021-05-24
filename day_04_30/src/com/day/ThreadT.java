package com.day;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ThreadT extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String text = "helloworld";
		String path = "";
		File file = null;
		FileWriter writer = null;
		
		for (int i = 0; i < 10; i++) {
			try {
				path = ".\\IMAGE_"+i;
				file = new File(path);
				System.out.println(file.exists());
				if(file.exists()) {
					System.out.println("폴더가 존재 합니다.");
				}else {
					file.mkdir();
					System.out.println("폴더가 생성되었습니다.");
				}
				
				path = ".\\IMAGE_"+i+"\\t.txt";
				file = new File(path);
				writer = new FileWriter(file);
				writer.write(text);
				BufferedWriter w = new BufferedWriter(writer);
				w.close();
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
	}

	
}
