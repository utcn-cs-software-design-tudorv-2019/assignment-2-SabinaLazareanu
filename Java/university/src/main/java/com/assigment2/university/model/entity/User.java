package com.assigment2.university.model.entity;

import javax.persistence.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Entity
public class User {

	@Id
	public ObjectId _id;
	private Long id;
	private String name;
	private String address;
	private String pNC;
	private String iCN;

	public User(ObjectId _id, Long id, String name, String address, String pNC, String iCN) {
		this._id = _id;
		this.id = id;
		this.name = name;
		this.address = address;
		this.pNC = pNC;
		this.iCN = iCN;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idUser) {
		this.id = idUser;
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

	public String getPNC() {
		return pNC;
	}

	public void setPNC(String pNC) {
		this.pNC = pNC;
	}

	public String getICN() {
		return iCN;
	}

	public void setICN(String iCN) {
		this.iCN = iCN;
	}

	@Override
	public String toString() {
		return "User [idUser=" + id + ", name=" + name + ", address=" + address + ", PNC=" + pNC + ", ICN=" + iCN + "]";
	}

}
