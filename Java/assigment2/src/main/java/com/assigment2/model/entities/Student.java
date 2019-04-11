package com.assigment2.model.entities;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String userName;
	private String password;
	private String group;

	@OneToOne
	@JoinColumn(name = "user.id")
	private Long user_idUser;

	public Long getId() {
		return id;
	}

	public void setId(Long idStudent) {
		this.id = idStudent;
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

	public Long _getIdUser() {
		return user_idUser;
	}

	public void _setIdUser(Long idUser) {
		this.user_idUser = idUser;
	}

	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Student [idStudent=" + id + ", userName=" + userName + ", password=" + password + ", group=" + group
				+ ", user_idUser=" + user_idUser + "]";
	}

}
