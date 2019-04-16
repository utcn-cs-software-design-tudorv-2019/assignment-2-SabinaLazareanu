package com.assigment2.model.services;

public class UserStudent {
	private Long id;
	private String name;
	private String address;
	private String pnc;
	private String icn;
	private String userName;
	private String password;
	private String groupF;

	public UserStudent(Long id, String name, String address, String pnc, String icn, String userName, String password,
			String groupF) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.pnc = pnc;
		this.icn = icn;
		this.userName = userName;
		this.password = password;
		this.groupF = groupF;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPnc() {
		return pnc;
	}

	public void setPnc(String pnc) {
		this.pnc = pnc;
	}

	public String getIcn() {
		return icn;
	}

	public void setIcn(String icn) {
		this.icn = icn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupF() {
		return groupF;
	}

	public void setGroupF(String groupF) {
		this.groupF = groupF;
	}

}
