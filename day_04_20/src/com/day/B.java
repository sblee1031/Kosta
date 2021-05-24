package com.day;

import java.util.ArrayList;
import java.util.HashMap;

public class B implements I {

	String[] name = {"�۰���","����","�����","������","���缮"};
	private String[] addr = {"��⵵ ������","���� Ư����","�λ� ������","��õ ������","��ű�����"};;
	private String[] number = {"000000-123456","000000-123456","000000-123456","000000-123456","000000-123456"};;
	private String[] phoneNum = {"010-0000-1234","010-0000-5678","010-0000-1234","010-0000-1234","010-0000-1234"};;
	private String[] email = {"123@naver.com","123@naver.com","123@naver.com","123@naver.com","123@naver.com"};;
	private String[] service = {"sk-0000-1234","kt-0000-1234","lg-0000-1234","sk-0000-1234","�˶�-0000-1234"};;
	private String[] plan = {"20000","30000","40000","50000","60000"};;
	private String[] serial = {"����ȣ_0000","����ȣ_0000","����ȣ_0000","����ȣ_0000","����ȣ_0000"};
	
	
	@Override
	public ArrayList<String> GetList() {
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < name.length; i++) {
			list.add(name[i]+" / "+addr[i]+" / "+number[i]+" / "+phoneNum[i]+" / "+email[i]+" / "+service[i]+" / "+plan[i]+" / "+serial[i]);
		}
		
		return list;
	}


	@Override
	public HashMap<String, String> GetHash2() {
		ArrayList<String> list = new ArrayList<String>();

		HashMap<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i < name.length; i++) {
			list.add(name[i]+" / "+addr[i]+" / "+number[i]+" / "+phoneNum[i]+" / "+email[i]+" / "+service[i]+" / "+plan[i]+" / "+serial[i]);
			//System.out.println("list.get"+list.get(i));
			map.put(name[i], list.get(i));
		}
		
		//System.out.println("list : "+list);

		//System.out.println("2 : "+map.toString());
		//System.out.println("str : "+map.get(str));
		return map;
	}

}
