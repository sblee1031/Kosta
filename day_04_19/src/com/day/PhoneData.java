package com.day;

import java.util.ArrayList;
import java.util.Comparator;

public class PhoneData implements Comparable<PhoneData>{
	public PhoneS s;
	

	String[] name = {"송가인","현빈","김수현","아이유","유재석"};
	private String[] addr = {"경기도 수원시","서울 특별시","부산 광역시","인천 광역시","대신광역시"};;
	private String[] number = {"000000-123456","000000-123456","000000-123456","000000-123456","000000-123456"};;
	private String[] phoneNum = {"010-0000-1234","010-0000-5678","010-0000-1234","010-0000-1234","010-0000-1234"};;
	private String[] email = {"123@naver.com","123@naver.com","123@naver.com","123@naver.com","123@naver.com"};;
	private String[] service = {"sk-0000-1234","kt-0000-1234","lg-0000-1234","sk-0000-1234","알뜰-0000-1234"};;
	private String[] plan = {"20000","30000","40000","50000","60000"};;
	private String[] serial = {"기계번호_0000","기계번호_0000","기계번호_0000","기계번호_0000","기계번호_0000"};
	
	public PhoneData(int index) {
		super();
		s = new PhoneS(name[index],addr[index],number[index],
						phoneNum[index],email[index],service[index],
						plan[index],serial[index]);
		//System.out.println(s);
		// TODO Auto-generated constructor stub
	}

	public PhoneData(String n,String a,String num, String phNum,String e,String se, String p, String seri) {
		super();
		s = new PhoneS(n,a,num,phNum,e,se,p,seri);
		// TODO Auto-generated constructor stub
	}



	@Override
	public int compareTo(PhoneData o) {
		// TODO Auto-generated method stub
		return this.s.name.compareTo(o.s.name);
	}
	
	public boolean is_true(String names) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < name.length; i++) {
			list.add(name[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(names)) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<String> getList(){
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < name.length; i++) {
			list.add(name[i]);
		}
		return list;
	}

}
