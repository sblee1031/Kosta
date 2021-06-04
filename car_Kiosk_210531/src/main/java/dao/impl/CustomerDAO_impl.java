package dao.impl;

import java.util.List;

import dto.CustomerDTO;

public interface CustomerDAO_impl {
	
	// INSERT 
	public void insert_Table(CustomerDTO dto);
	
	// UPDATE
	public void update_Table(CustomerDTO dto);
	
	// SELECT ALL
	public List<CustomerDTO> select_All();
	
	// SELECT ONE
	public List<CustomerDTO> select_One(String car_Num);
}
