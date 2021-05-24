package com.day;

import java.util.ArrayList;

public class day_04_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Gugudan gugudan = new Gugudan();
		Gugudan_inner gugudan_i = new Gugudan_inner();
		//gugudan.Gugudan_method(2);
		gugudan.Gugudan_method(2,4,5);
		
		
		System.out.println("===시작.");
		//System.out.println("시작"+gugudan.save.lastIndexOf(gugudan));
		
		for (int j = 0; j < gugudan.save.size(); j++) {
			
			for (int i = 0; i < gugudan.gugu_i; i++) {
				System.out.println("j : "+j+" / i : "+i+" : "+gugudan.save.get(j).gugudan_array[i]);
			}
		}
		System.out.println("==끝.");
		
		//System.out.println("gugu_i :"+gugudan.save.get(9).gugudan_array[0]);
		System.out.println("000 : "+gugudan.gugu_i);
		System.out.println("1111::"+gugudan.save.get(0).gugudan_array[0]);
		
		
		
		
		//gugudan.save.get(0).gugudan_array[0];
		//System.out.println(gugudan.save.get(0));

//		Gugudan gugudan = new Gugudan();
//		gugudan.Gugudan_method(6);
		
		
		
		
		
	}//메인
	
	static void class_test() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list.clear();
		list.add(200);
		list.add(300);
		list2.add(200);
		list2.add(300);
		
		list.equals(list);
		System.out.println(list.equals(list2));
		System.out.println(list.contains(200));

		//A a = new A();
		
		//String[] text_data = new String[] {"유니티","홍길동","서울시 강남구","010-1234-5456","남여","123456789","28"};
		
		//A ac = new A();
		ArrayList<A> list_a = new ArrayList<A>();
		
		A a = new A();
		//Data data = new Data();
		//A ac = new A(data.text_data[0],data.text_data[1],data.text_data[2],data.text_data[3],
		//		data.text_data[4],data.text_data[5],data.text_data[6]);
		
		//list_a.add(ac);		
		//String[] ac1 = data.text_data;
		
		
		System.out.println("list_a: "+list_a.get(0).id);
		
		System.out.println(list_a.get(0).id);
		System.out.println(list_a.get(0).name);
		System.out.println(list_a.get(0).addr);
		System.out.println(list_a.get(0).phone);
		System.out.println(list_a.get(0).age);
		System.out.println(list_a.get(0).number);
		//System.out.println(ac.name);
	}

}//클래스
