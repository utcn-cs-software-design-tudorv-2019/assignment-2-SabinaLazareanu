package com.assigment2.university.business;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.assigment2.university.model.entity.Student;
import com.assigment2.university.model.repo.StudentRepository;

@Service
public class StudentService {

	@Inject
	private StudentRepository studentRepo;

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	public Student insertStudent(Student student) {
		return studentRepo.save(student);
	}

	public Student getStudentById(Long id) {
		return studentRepo.findByid(id);
	}
}
