package com.assigment2.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String name;
	private String address;
	private String pnc;
	private String icn;
	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
	private Student student;

	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
	private Teacher teacher;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
		return pnc;
	}

	public void setPNC(String pNC) {
		this.pnc = pNC;
	}

	public String getICN() {
		return icn;
	}

	public void setICN(String iCN) {
		this.icn = iCN;
	}

	@Override
	public String toString() {
		return "User [idUser=" + id + ", name=" + name + ", address=" + address + ", PNC=" + pnc + ", ICN=" + icn + "]";
	}

}
