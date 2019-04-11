package com.assigment2.model.services;

import java.util.List;

import org.hibernate.SessionFactory;

import com.assigment2.model.entities.Student;
import com.assigment2.model.repositories.DatabaseException;
import com.assigment2.model.repositories.StudentRepository;

public class StudentService {

	private StudentRepository studentRepo;

	public StudentService(SessionFactory sessionFactory) throws DatabaseException {
		studentRepo = new StudentRepository(sessionFactory);
	}

	public Student getByID(Integer id) throws DatabaseException {
		return studentRepo.getById(id);
	}

	public Student save(Student object) throws DatabaseException {
		return studentRepo.save(object);
	}

	public void update(Student object) {
		studentRepo.update(object);
	}

	public void delete(Student object) {
		studentRepo.delete(object);
	}

	public List<Student> getAll() throws DatabaseException {
		return studentRepo.getAll();
	}

}
