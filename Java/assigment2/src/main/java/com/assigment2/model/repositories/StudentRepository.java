package com.assigment2.model.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assigment2.database.config.HibernateUtil;
import com.assigment2.model.entities.Student;

public class StudentRepository {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public StudentRepository() {
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAll() throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		List<Student> students = null;
		try {
			session.beginTransaction();
			students = session.createCriteria(Student.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return students;
	}

	public Student getById(Long id) throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		Student element = null;
		try {
			session.beginTransaction();
			element = (Student) session.get(Student.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return element;
	}

	public Student save(Student object) throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return object;
	}

	public void update(Student object) throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
	}

	public void delete(Student object) throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
	}

}
