package com.assigment2.model.services;

import java.util.ArrayList;
import java.util.List;

import com.assigment2.model.entities.Course;
import com.assigment2.model.repositories.CourseRepository;
import com.assigment2.model.repositories.DatabaseAccesException;

public class CourseService {

	private CourseRepository courseRepo;

	public CourseService(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}

	public Course getByID(Integer id) throws DatabaseAccesException {
		return courseRepo.getById(id);
	}

	public Course save(Course object) throws DatabaseAccesException {
		return courseRepo.save(object);
	}

	public void update(Course object) throws DatabaseAccesException {
		courseRepo.update(object);
	}

	public void delete(Course object) throws DatabaseAccesException {
		courseRepo.delete(object);
	}

	public List<Course> getAll() throws DatabaseAccesException {
		return courseRepo.getAll();
	}

	public List<Course> getPossibleOptionsForCoursForStudent(List<Course> takenCourses) throws DatabaseAccesException {
		List<Course> possibleCourses = null;
		List<Course> allCourses = getAll();

		if (takenCourses.size() != 0) {
			possibleCourses = new ArrayList<>();
			for (Course possibleCours : allCourses) {
				if (!takenCourses.contains(possibleCours)) {
					possibleCourses.add(possibleCours);
				}
			}
		} else {
			possibleCourses = new ArrayList<Course>(allCourses);
		}
		return possibleCourses;
	}

	public Course getCourseByName(String name) throws DatabaseAccesException {
		Course result = null;
		List<Course> allCourses = getAll();
		for (Course course : allCourses) {
			if (name.equals(course.getCourseName())) {
				result = course;
				break;
			}
		}
		return result;
	}
	

}
