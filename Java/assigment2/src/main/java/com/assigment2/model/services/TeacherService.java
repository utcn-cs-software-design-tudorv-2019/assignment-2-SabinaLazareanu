package com.assigment2.model.services;

import java.util.List;

import com.assigment2.model.entities.Teacher;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.TeacherRepository;

public class TeacherService {
	private TeacherRepository teacherRepo;

	public TeacherService(TeacherRepository teacherRepo) {
		this.teacherRepo = teacherRepo;
	}

	public Teacher getByID(Integer id) throws DatabaseAccesException {
		return teacherRepo.getById(id);
	}

	public Teacher save(Teacher object) throws DatabaseAccesException {
		return teacherRepo.save(object);
	}

	public void update(Teacher object) throws DatabaseAccesException {
		teacherRepo.update(object);
	}

	public void delete(Teacher object) throws DatabaseAccesException {
		teacherRepo.delete(object);
	}

	public List<Teacher> getAll() throws DatabaseAccesException {
		return teacherRepo.getAll();
	}

}
