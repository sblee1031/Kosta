package com.day.security.dto;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class RepBoardFile {
	private RepBoard repBoard;
	private List<MultipartFile> foodFiles;
	private MultipartFile drinkFile;
	private List<Product> products;
	
	
	public RepBoard getRepBoard() {
		return repBoard;
	}
	public void setRepBoard(RepBoard repBoard) {
		this.repBoard = repBoard;
	}
	public MultipartFile getDrinkFile() {
		return drinkFile;
	}
	public void setDrinkFile(MultipartFile drinkFile) {
		this.drinkFile = drinkFile;
	}
	public List<MultipartFile> getFoodFiles() {
		return foodFiles;
	}
	public void setFoodFiles(List<MultipartFile> foodFiles) {
		this.foodFiles = foodFiles;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "RepBoardFile [repBoard=" + repBoard + ", foodFiles=" + foodFiles + ", drinkFile=" + drinkFile
				+ ", products=" + products + "]";
	}
	
	
	

	
	
}
