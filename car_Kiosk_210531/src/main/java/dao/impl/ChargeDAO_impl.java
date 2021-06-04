package dao.impl;

import java.util.List;

import dto.ChargeDTO;

public interface ChargeDAO_impl {
	// Charge 테이블 SELECT ONE
	public List<ChargeDTO> select_One(String car_Size);
}
