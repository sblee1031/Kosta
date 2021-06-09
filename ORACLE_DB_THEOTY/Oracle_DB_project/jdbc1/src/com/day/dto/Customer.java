package com.day.dto;

public class Customer {
	private String id;
	private String pwd;
	private String name;
	private String buildingno;//???
	private int enabled;
	
	public Customer() {
		super();
	}	
	public Customer(String id, String pwd, String name) {
		this(id,pwd,name, null);
	}
	public Customer(String id, String pwd, String name, String buildingno) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.buildingno = buildingno;
	}
	
	public Customer(String id, String pwd, String name, String buildingno, int enabled) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.buildingno = buildingno;
		this.enabled = enabled;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuildingno() {
		return buildingno;
	}
	public void setBuildingno(String buildingno) {
		this.buildingno = buildingno;
	}
	
	
	
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", pwd=" + pwd + ", name=" + name + ", buildingno=" + buildingno + ", enabled="
				+ enabled + "]";
	}
	
	
	
	
}
