package com.assigment2.model.services;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import com.assigment2.model.repositories.Repository;

public class Service<T> {

	@Inject
	private Repository<T> repo;
	private Class<T> cl;

	public Service(Class<T> cl, SessionFactory sessionFactory) {
		this.cl = cl;
		repo = new Repository<T>(cl, sessionFactory);
	}

	public T get(Class<T> cl, Integer id) {
		return (T) repo.get(cl, id);
	}

	public T save(T object) {
		return (T) repo.save(object);
	}

	public void update(T object) {
		repo.update(object);
	}

	public void delete(T object) {
		repo.delete(object);
	}

	public List<T> query(String hsql, Map<String, Object> params) {
		return (List<T>) repo.query(hsql, params);
	}

	public List<T> getAll() {
		return query("from " + cl.getName(), null);
	}

	public void deleteAll() {
		query("delete from " + cl.getName(), null);

	}

}
