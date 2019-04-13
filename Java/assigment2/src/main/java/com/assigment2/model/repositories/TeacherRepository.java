package com.assigment2.model.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assigment2.model.entities.Teacher;

public class TeacherRepository {
	private SessionFactory sessionFactory;

	public TeacherRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getAll() throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		List<Teacher> teachers = null;
		try {
			session.beginTransaction();
			teachers = session.createCriteria(Teacher.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return teachers;
	}

	public Teacher getById(Integer id) throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		Teacher teacher = null;
		try {
			session.beginTransaction();
			teacher = (Teacher) session.get(Teacher.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return teacher;
	}

	public Teacher save(Teacher object) throws DatabaseAccesException {
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

	public void update(Teacher object) throws DatabaseAccesException {
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

	public void delete(Teacher object) throws DatabaseAccesException {
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
