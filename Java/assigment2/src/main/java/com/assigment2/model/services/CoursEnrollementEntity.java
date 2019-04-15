package com.assigment2.model.services;

public class CoursEnrollementEntity {
	private String cours;
	private String teacher;
	private String examDate;
	private String grade;

	public CoursEnrollementEntity(String cours, String teacher, String examDate, String grade) {
		this.cours = cours;
		this.teacher = teacher;
		this.examDate = examDate;
		this.grade = grade;
	}

	public String getCours() {
		return cours;
	}

	public void setCours(String cours) {
		this.cours = cours;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Row [cours=" + cours + ", teacher=" + teacher + ", examDate=" + examDate + ", grade=" + grade + "]";
	}

}
