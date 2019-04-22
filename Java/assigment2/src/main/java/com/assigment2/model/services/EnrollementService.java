package com.assigment2.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.assigment2.model.entities.Course;
import com.assigment2.model.entities.Enrollement;
import com.assigment2.model.entities.Student;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.EnrollementRepository;

public class EnrollementService {

	private EnrollementRepository enrollementRepo;

	@Inject
	public EnrollementService(EnrollementRepository enrollementRepo) {
		this.enrollementRepo = enrollementRepo;
	}

	public Enrollement getByID(Integer id) throws DatabaseAccesException {
		return enrollementRepo.getById(id);
	}

	public Enrollement save(Enrollement object) throws DatabaseAccesException {
		return enrollementRepo.save(object);
	}

	public void update(Enrollement object) throws DatabaseAccesException {
		enrollementRepo.update(object);
	}

	public void delete(Enrollement object) throws DatabaseAccesException {
		enrollementRepo.delete(object);
	}

	public List<Enrollement> getAll() throws DatabaseAccesException {
		return enrollementRepo.getAll();
	}

	public List<Enrollement> getStudentEnrollements(Long idStudent) throws DatabaseAccesException {
		List<Enrollement> studentEnrollements = new ArrayList<Enrollement>();
		List<Enrollement> enrollments = getAll();
		for (Enrollement enrollement : enrollments) {
			Long studentId = enrollement.getStudent().getId();
			if (idStudent.equals(studentId)) {
				studentEnrollements.add(enrollement);
			}
		}
		return studentEnrollements;
	}

	public void unenrollStudent(Enrollement selectedEnrollment) throws DatabaseAccesException {
		Enrollement enrollement = getEnrollementByStudentAndCourse(selectedEnrollment.getStudent(),
				selectedEnrollment.getCourse());
		enrollementRepo.delete(enrollement);
	}

	public Enrollement getEnrollementByStudentAndCourse(Student student, Course coures) throws DatabaseAccesException {
		List<Enrollement> enrollements = getAll();
		for (Enrollement enrollement : enrollements) {
			if (coures.getIdCours().equals(enrollement.getCourse().getIdCours())
					&& student.getId().equals(enrollement.getStudent().getId())) {
				return enrollement;
			}
		}
		return null;
	}

}
