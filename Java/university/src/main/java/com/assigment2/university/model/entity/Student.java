package com.assigment2.university.model.entity;

import javax.persistence.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Entity
public class Student {

	@Id
	private ObjectId _id;
	private Long id;
	private String userName;
	private String password;
	private String group;
	@DBRef
	private User user;

	public Student(ObjectId _id, Long id, String userName, String password, String group, User user) {
		this._id = _id;
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.group = group;
		this.user = user;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Student [idStudent=" + id + ", userName=" + userName + ", password=" + password + ", group=" + group
				+ "]";
	}

}
