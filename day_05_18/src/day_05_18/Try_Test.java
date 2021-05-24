package day_05_18;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Try_Test {//트라이문 테스트

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "홍길동/이수홍/박연수/";
		StringTokenizer st = new StringTokenizer(text, "/");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		
		while(st.hasMoreTokens()){
			String token = st.nextToken();
//			System.out.println(token);
		}
		
		//		Object obj = new Object();
//		System.out.println(obj.toString());
//
//		String a = null;
//		ArrayList arr = new ArrayList();
//		
//		try {
//			System.out.println(a.toString());
//			System.out.println(arr.get(3));
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("메세지 :"+e.getMessage());
//			System.out.println("에러발생");
//		}finally{
//			System.out.println("finally");
//		}
		
	}

}
