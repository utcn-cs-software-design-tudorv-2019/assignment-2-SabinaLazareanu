package com.assigment2.model.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assigment2.model.entities.Student;

public class StudentRepository {

	private SessionFactory sessionFactory;

	public StudentRepository(SessionFactory sessionFactory) throws DatabaseException {
		this.sessionFactory = sessionFactory;
		if (sessionFactory == null)
			throw new DatabaseException("Session factory is null!!!");
	}

	public List<Student> getAll() throws DatabaseException {
		Session session = sessionFactory.openSession();
		List<Student> students = null;
		try {
			session.beginTransaction();
			students = session.createCriteria(Student.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		return students;
	}

	public Student getById(Integer id) throws DatabaseException {
		Session session = sessionFactory.openSession();
		Student element = null;
		try {
			session.beginTransaction();
			element = (Student) session.get(Student.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		return element;
	}

	public Student save(Student object) throws DatabaseException {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		return object;
	}

	public void update(Student object) {
		//TODO
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}

	public void delete(Student object) {
		//TODO
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
	}

}
