package com.assigment2.model.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assigment2.model.entities.User;

public class UserRepository {

	private SessionFactory sessionFactory;

	public UserRepository(SessionFactory sessionFactory) throws DatabaseException {
		this.sessionFactory = sessionFactory;
		if (sessionFactory == null)
			throw new DatabaseException("Session factory is null!!!");
	}

	public List<User> getAll() throws DatabaseException {
		Session session = sessionFactory.openSession();
		List<User> users = null;
		try {
			session.beginTransaction();
			users = session.createCriteria(User.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		return users;
	}

	public User getById(Integer id) throws DatabaseException {
		Session session = sessionFactory.openSession();
		User user = null;
		try {
			session.beginTransaction();
			user = (User) session.get(User.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		return user;
	}

	public User save(User object) throws DatabaseException {
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

	public void update(User object) {
		// TODO
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}

	public void delete(User object) {
		// TODO
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
	}

}
