package com.assigment2.university.model.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assigment2.university.model.entity.Student;

public interface StudentRepository extends MongoRepository<Student, Long> {

	public List<Student> findAll();

	public Student save(Student student);

	public Student findByid(Long id);
}
