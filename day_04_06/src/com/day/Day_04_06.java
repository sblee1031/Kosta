package com.day;

public class Day_04_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���������
		//�񱳿�����
		//���Կ�����
		
//		int c = 0;
//		c = 300;
//		c = c + 300;
//		System.out.println(c);
//		c += 300;
//		System.out.println(c);
//		c = c -100;
//		System.out.println(c);
//		c -= 100;
//		System.out.println(c);
//		c = c * 2;
//		System.out.println(c);
//		c *=2;
//		System.out.println(c);
//		c = c /2;
//		System.out.println(c);
//		c /=2;
//		System.out.println(c);
//		
//		System.out.println(100==200);
//		c = c*10;
//		System.out.println(c);
//		System.out.println(c % 2==1);
//		System.out.println(c % 1 ==0);
//		
//		System.out.println(300 >= 300);
//		System.out.println(300 < 300);
//		System.out.println("-----------");
//		boolean is_b = 300 < 300;
//		System.out.println(is_b);
//		System.out.println("------aa\n-----");
//		
//		int a = 100-50;
//		int b = 200-150;
//		
//		
//		System.out.println("100-50" != "200-150");
//		System.out.println(l_f() == r_f());
		
		
//		System.out.println(true&&true);
//		System.out.println("************************");
//		System.out.println(l_f()||r_f());
//		System.out.println("------------");
//		System.out.println(l_f()&&r_f());
		
//		System.out.println(l_f()||(m_f()&&r_f()));
//		int c = 0;
//		System.out.println(c++);
//		System.out.println(c);
//		System.out.println(c++);
//		System.out.println(c = c+1);

//		int c = 0;
//		int c2 = c++;
//		System.out.println("c2 :"+c2);
//		int c3 = ++c;
//		System.out.println(c3);
		

//		if(false) {
//			System.out.println("�ȳ��ϼ���.");
//			
//		} else {
//			System.out.println("������");
//		}
		
//		int c = 75;
//		
//		if(c >= 90) {
//			System.out.println(c);
//		}else if(c >= 80) {
//			System.out.println(c);
//		}else if(c >= 70) {
//			System.out.println(c);
//		}else if(c >= 60) {
//			System.out.println(c);
//		}else
//			System.out.println(c);
		
//		int id = 1234;
//		int pw = 5678;
//		
//		if(id == 1234 & pw == 567) {
//			System.out.println("ȸ���� �ȳ��ϼ���");
//		}
//		if(id == 123) {
//			if(pw == 567) {
//				System.out.println("ȸ���� �ȳ��ϼ���");
//			}else {
//				System.out.println("�н����尡 Ʋ�Ƚ��ϴ�.");
//			}
//		}else {
//				System.out.println("���̵� Ȯ�����ּ���.");
//		}
		
		
		
		
		if(login(123)==1) {
			System.out.println("ȸ���� �ȳ��ϼ���.");
		}else if(login(123)==2) {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
		}
		
		System.out.println("************");
		System.out.println(sum("100","200")+"��");
		
				
	}// main ���ȣ 
	
//-----------��������	
	static String sum(String a, String b) {
		return a+b;
	}
	
	static int login(int p) {
		if(p == 1234) {
			return 1;
		}else {
			return 2;
		}
	}
	
	
	
	
	
	
	//Ŀ���� �Լ�
	static boolean l_f() {
		System.out.println("����l_f �Լ� �Դϴ�.");
		return true;
		
	}
	
	static boolean m_f() {
		System.out.println("�߰�m_f �Լ� �Դϴ�.");
		return true;
	}
	
	static boolean r_f() {
		System.out.println("������r_f �Լ� �Դϴ�.");
		return true;
	}
	

}
