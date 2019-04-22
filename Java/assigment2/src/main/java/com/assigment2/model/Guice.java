package com.assigment2.model;

import com.assigment2.model.services.CourseService;
import com.assigment2.model.services.EnrollementService;
import com.assigment2.model.services.StudentService;
import com.assigment2.model.services.TeacherService;
import com.assigment2.model.services.UserService;
import com.google.inject.AbstractModule;

public class Guice extends AbstractModule {

	@Override
	protected void configure() {
		bind(UserService.class);
		bind(StudentService.class);
		bind(TeacherService.class);
		bind(CourseService.class);
		bind(EnrollementService.class);
	}

}
