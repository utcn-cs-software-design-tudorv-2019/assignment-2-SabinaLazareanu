package com.assigment2.model.repositories;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Repository<T> {

	private SessionFactory sessionFactory;

	public Repository(Class<T> cl, SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		if (sessionFactory == null)
			throw new RuntimeException("Session factory is null!!!");
	}

	public T get(Class<T> cl, Integer id) {
		Session session = sessionFactory.openSession();
		T element = null;
		try {
			session.beginTransaction();
			element = (T) session.get(cl, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return element;
	}

	public T save(T object) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return object;
	}

	public void update(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}

	public void delete(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<T> query(String hsql, Map<String, Object> params) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(hsql);
			if (params != null) {
				for (String i : params.keySet()) {
					query.setParameter(i, params.get(i));
				}
			}
			
			if ((hsql.toUpperCase().indexOf("DELETE") == -1) && (hsql.toUpperCase().indexOf("UPDATE") == -1)
					&& (hsql.toUpperCase().indexOf("INSERT") == -1)) {
				result = query.list();
			} else {
			}
			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return result;
	}

}
