package com.day;

public class B  {
	
	Bs bs = null;

	String[] name = {"송가인","현빈","김수현","아이유","유재석"};
	private String[] addr = {"경기도 수원시","서울 특별시","부산 광역시","인천 광역시","대신광역시"};;
	private String[] number = {"000000-123456","000000-123456","000000-123456","000000-123456","000000-123456"};;
	private String[] phoneNum = {"010-0000-1234","010-0000-5678","010-0000-1234","010-0000-1234","010-0000-1234"};;
	private String[] email = {"123@naver.com","123@naver.com","123@naver.com","123@naver.com","123@naver.com"};;
	private String[] service = {"sk-0000-1234","kt-0000-1234","lg-0000-1234","sk-0000-1234","알뜰-0000-1234"};;
	private String[] plan = {"20000","30000","40000","50000","60000"};;
	private String[] serial = {"기계번호_0000","기계번호_0000","기계번호_0000","기계번호_0000","기계번호_0000"};
	
	public B() {
		super();
		// TODO Auto-generated constructor stub
	}



	public B(int i) {
		bs = new Bs();
		bs.setName(name[i]);
		bs.setAddr(addr[i]);
		bs.setPhoneNum(phoneNum[i]);
		bs.setEmail(email[i]);
		bs.setService(service[i]);
		bs.setPlan(plan[i]);
		bs.setSerial(serial[i]);
		
		//System.out.println(as.getName());
	
		//ArrayList<String> list = new ArrayList<String>();
		//list.add(as.getName()+" / "+as.getAge()+as.getAddr()+as.getPhone()+as.getGender());
		
		//as.getList(i);
	}

}
