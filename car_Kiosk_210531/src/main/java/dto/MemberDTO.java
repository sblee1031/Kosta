package dto;

import java.util.ArrayList;

public class MemberDTO {

	private static MemberDTO memberDTO = new MemberDTO();
	
	public static MemberDTO getInstance() {
		if(memberDTO == null)
			memberDTO = new MemberDTO();
		return memberDTO;
	}
	

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}


	public MemberDTO( String member_Id, String member_Pw,String li_num, String li_Date,  String ph_Num, int Mileage) {
		super();
		this.member_Id = member_Id;
		this.member_Pw = member_Pw;
		this.li_num = li_num;
		this.li_Date = li_Date;
		this.ph_Num = ph_Num;
		this.Mileage = Mileage;
	}
	
	String member_Id;
	String member_Pw;
	String li_num;
	String li_Date;
	String ph_Num;
	int Mileage;


	public String getMember_Id() {
		return member_Id;
	}


	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}


	public String getMember_Pw() {
		return member_Pw;
	}


	public void setMember_Pw(String member_Pw) {
		this.member_Pw = member_Pw;
	}


	public String getPh_Num() {
		return ph_Num;
	}

	public void setPh_Num(String ph_Num) {
		this.ph_Num = ph_Num;
	}


	public String getLi_Date() {
		return li_Date;
	}

	public void setLi_Date(String li_Date) {
		this.li_Date = li_Date;
	}

	public String getLi_num() {
		return li_num;
	}

	public void setLi_num(String li_num) {
		this.li_num = li_num;
	}

	public int getMileage() {
		return Mileage;
	}

	public void setMileage(int mileage) {
		Mileage = mileage;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [member_Id=" + member_Id + ", member_Pw=" + member_Pw + ", li_num=" + li_num + ", li_Date="
				+ li_Date + ", ph_Num=" + ph_Num + ", Mileage=" + Mileage + "]";
	}
}
