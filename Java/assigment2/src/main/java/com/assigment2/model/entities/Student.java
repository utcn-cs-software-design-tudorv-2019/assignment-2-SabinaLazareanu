package com.assigment2.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "user_name")
	private String userName;
	private String password;
	private String groupF;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private List<Enrollement> enrollement;

	public List<Enrollement> getEnrollement() {
		return enrollement;
	}

	public void setEnrollement(List<Enrollement> enrollement) {
		this.enrollement = enrollement;
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

	public String getGroupF() {
		return groupF;
	}

	public void setGroupF(String group) {
		this.groupF = group;
	}

	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Student [idStudent=" + id + ", userName=" + userName + ", password=" + password + ", group=" + groupF
				+ ", user_idUser=";
	}

}
