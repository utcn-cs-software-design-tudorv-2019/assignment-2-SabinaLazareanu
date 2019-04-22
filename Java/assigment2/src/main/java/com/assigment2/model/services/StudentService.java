package com.assigment2.model.services;

import java.util.List;

import javax.inject.Inject;

import com.assigment2.model.entities.Student;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.StudentRepository;

public class StudentService {

	private StudentRepository studentRepo;

	@Inject
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	public Student getByID(Long id) throws DatabaseAccesException {
		return studentRepo.getById(id);
	}

	public Student save(Student object) throws DatabaseAccesException {
		return studentRepo.save(object);
	}

	public void update(Student object) throws DatabaseAccesException {
		studentRepo.update(object);
	}

	public void delete(Student object) throws DatabaseAccesException {
		studentRepo.delete(object);
	}

	public List<Student> getAll() throws DatabaseAccesException {
		return studentRepo.getAll();
	}

	public Student login(String userName, String password) throws DatabaseAccesException {
		Student currentUser = null;
		List<Student> students = (List<Student>) studentRepo.getAll();
		for (Student student : students) {
			if (student.getUserName().equals(userName) && student.getPassword().equals(password)) {
				currentUser = student;
				break;
			}
		}

		return currentUser;
	}


}
