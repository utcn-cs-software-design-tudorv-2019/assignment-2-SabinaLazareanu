package com.assigment2.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollement")
public class Enrollement {

	@ManyToOne
	@JoinColumn(name = "student")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course")
	private Course course;

	@Id
	private float grade;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course cours) {
		this.course = cours;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Enrollement [Student_id=" + student + ", Cours_id=" + course + ", grade=" + grade + "]";
	}

}
