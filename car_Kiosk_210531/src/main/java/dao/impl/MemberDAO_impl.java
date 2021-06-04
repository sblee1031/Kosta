package dao.impl;

import java.util.ArrayList;

import dto.MemberDTO;

public interface MemberDAO_impl {
	public ArrayList<String> MemberMatch(String id, String pw);
	
	public void member_Add();
	
	//member테이블 ID검증 메서드
	public boolean member_Id_Check(String id);
	
	// UPDATE 마일리지
	public void update_Mileage(MemberDTO memberDTO);
	
}
