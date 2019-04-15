package com.assigment2.model.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assigment2.model.entities.Enrollement;

public class EnrollementRepository {
	private SessionFactory sessionFactory;

	public EnrollementRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Enrollement> getAll() throws DatabaseAccesException {
		//TODO here is the problem
		Session session = sessionFactory.openSession();
		List<Enrollement> enrollements = null;
		try {
			session.beginTransaction();
			enrollements = session.createCriteria(Enrollement.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return enrollements;
	}

	public Enrollement getById(Integer id) throws DatabaseAccesException {
		Session session = sessionFactory.openSession();
		Enrollement enrollement = null;
		try {
			session.beginTransaction();
			enrollement = (Enrollement) session.get(Enrollement.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseAccesException(e.getMessage());
		} finally {
			session.close();
		}
		return enrollement;
	}

	public Enrollement save(Enrollement object) throws DatabaseAccesException {
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

	public void update(Enrollement object) throws DatabaseAccesException {
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

	public void delete(Enrollement object) throws DatabaseAccesException {
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
