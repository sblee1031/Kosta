package com.day;

import java.util.ArrayList;
import java.util.HashMap;

public class B implements I {

	String[] name = {"송가인","현빈","김수현","아이유","유재석"};
	private String[] addr = {"경기도 수원시","서울 특별시","부산 광역시","인천 광역시","대신광역시"};;
	private String[] number = {"000000-123456","000000-123456","000000-123456","000000-123456","000000-123456"};;
	private String[] phoneNum = {"010-0000-1234","010-0000-5678","010-0000-1234","010-0000-1234","010-0000-1234"};;
	private String[] email = {"123@naver.com","123@naver.com","123@naver.com","123@naver.com","123@naver.com"};;
	private String[] service = {"sk-0000-1234","kt-0000-1234","lg-0000-1234","sk-0000-1234","알뜰-0000-1234"};;
	private String[] plan = {"20000","30000","40000","50000","60000"};;
	private String[] serial = {"기계번호_0000","기계번호_0000","기계번호_0000","기계번호_0000","기계번호_0000"};
	
	
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
