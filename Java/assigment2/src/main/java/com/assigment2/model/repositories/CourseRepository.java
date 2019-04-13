package com.assigment2.model.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assigment2.model.entities.Course;

public class CourseRepository {
	private SessionFactory sessionFactory;

	public CourseRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Course> getAll() throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		List<Course> teachers = null;
		try {
			session.beginTransaction();
			teachers = session.createCriteria(Course.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return teachers;
	}

	public Course getById(Integer id) throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		Course course = null;
		try {
			session.beginTransaction();
			course = (Course) session.get(Course.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return course;
	}

	public Course save(Course object) throws DatabaseAccesException {
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

	public void update(Course object) throws DatabaseAccesException {
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

	public void delete(Course object) throws DatabaseAccesException {
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