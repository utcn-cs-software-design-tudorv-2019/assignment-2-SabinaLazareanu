package com.assigment2.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan (basePackages = {"assigment2.business","assigment2.controller","assigment2.model"})
//@EnableMongoRepositories(basePackages = "assigment2.model.repo")
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
		
	}

}
