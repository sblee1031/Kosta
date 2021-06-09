package com.day.dto;

import java.util.Date;

public class Customer {
	private String id;
	private String pwd;
	private String name;
	private String buildingno;
	private int enabled;
	
	
	
	public Customer(String id, String pwd, String name, String buildingno, int enabled) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.buildingno = buildingno;
		this.enabled = enabled;
	}

	public Customer(String id, String pwd, String name) {
		this(id,pwd,name,null);
	}
	
	public Customer(String id, String pwd, String name, String buildingno) {
		
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.buildingno = buildingno;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingno == null) ? 0 : buildingno.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (buildingno == null) {
			if (other.buildingno != null)
				return false;
		} else if (!buildingno.equals(other.buildingno))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", pwd=" + pwd + ", name=" + name + ", buildingno=" + buildingno + ", enabled="
				+ enabled + "]";
	}
	

	
	
	
}
