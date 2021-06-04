package dao.impl;

import java.util.List;

import dto.CarDTO;

public interface CarDAO_impl {
	
	// UPDATE isKey 
	public void update_Key(String carNum, int n);
	
	// SELECT ALL
	public List<CarDTO> select_All();
	
	// SELECT ONE
	public List<CarDTO> select_One(String car_Num);
	
	
}
