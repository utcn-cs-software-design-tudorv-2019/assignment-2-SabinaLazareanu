package com.assigment2.university.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.assigment2.university.business.StudentService;
import com.assigment2.university.model.entity.Student;
import com.assigment2.university.model.entity.User;

@RestController
public class StudentController {

	@Inject
	private StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ModelAndView getUsers() {
		List<Student> studentsList = studentService.getAllStudents();
		System.out.println(studentsList.toString());
		ModelAndView mav = new ModelAndView("student");
		mav.addObject("students", studentsList);
		return mav;
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public Student createUser(@Valid @RequestBody Student student) {
		student.set_id(ObjectId.get());
		User user= new User(null, 1l, "Sabina", "Odfg", "123654789", "789632145");
		user.set_id(ObjectId.get());
		studentService.insertStudent(student);
		return student;
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Student getUserById(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}

}
