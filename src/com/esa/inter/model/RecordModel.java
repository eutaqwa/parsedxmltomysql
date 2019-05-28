package com.esa.inter.model;

public class RecordModel {
	private int recordsid;
	private String name;
	private String phone;
	private String email;
	private String city;
	private String parent;
	private String child;
	public RecordModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecordModel(int recordsid, String name, String phone, String email, String city, String parent,
			String child) {
		super();
		this.recordsid = recordsid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.parent = parent;
		this.child = child;
	}
	public int getRecordsid() {
		return recordsid;
	}
	public void setRecordsid(int recordsid) {
		this.recordsid = recordsid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	
	
	
}
