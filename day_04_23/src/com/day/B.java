package com.day;

import java.util.ArrayList;

public class B  implements I{
	
	public String text = "";
	
	String[] name = {"�۰���","����","�����","������","���缮"};
	private String[] addr = {"��⵵ ������","���� Ư����","�λ� ������","��õ ������","��ű�����"};;
	private String[] number = {"000000-123456","000000-123456","000000-123456","000000-123456","000000-123456"};;
	private String[] phoneNum = {"010-0000-1234","010-0000-5678","010-0000-1234","010-0000-1234","010-0000-1234"};;
	private String[] email = {"123@naver.com","123@naver.com","123@naver.com","123@naver.com","123@naver.com"};;
	private String[] service = {"sk-0000-1234","kt-0000-1234","lg-0000-1234","sk-0000-1234","�˶�-0000-1234"};;
	private String[] plan = {"20000","30000","40000","50000","60000"};;
	private String[] serial = {"����ȣ_0000","����ȣ_0000","����ȣ_0000","����ȣ_0000","����ȣ_0000"};
	
	public B() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public B(int i) {
		text = name[i]+" / "+addr[i]+" / "+number[i]+ " / " +phoneNum[i]+ " / " +email[i]+ " / " +service[i]+ " / "+plan[i]+ " / "+serial[i]+"\n";
	}


	@Override
	public String data_text() {
		// TODO Auto-generated method stub
		String text = "";
		for (int i = 0; i < name.length; i++) {
			text += name[i]+" / "+addr[i]+" / "+number[i]+ " / " +phoneNum[i]+ " / " +email[i]+ " / " +service[i]+ " / "+plan[i]+ " / "+serial[i]+"\n";
		}
		
		return text;
	}

	

}
