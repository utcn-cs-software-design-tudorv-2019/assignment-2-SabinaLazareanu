package com.assigment2.model.services;

import java.util.List;

import org.hibernate.SessionFactory;

import com.assigment2.model.entities.User;
import com.assigment2.model.repositories.DatabaseException;
import com.assigment2.model.repositories.UserRepository;

public class UserService {

	private UserRepository userRepo;

	public UserService(SessionFactory sessionFactory) throws DatabaseException {
		userRepo = new UserRepository(sessionFactory);
	}

	public User getByID(Integer id) throws DatabaseException {
		return userRepo.getById(id);
	}

	public User save(User object) throws DatabaseException {
		return userRepo.save(object);
	}

	public void update(User object) {
		userRepo.update(object);
	}

	public void delete(User object) {
		userRepo.delete(object);
	}

	public List<User> getAll() throws DatabaseException {
		return userRepo.getAll();
	}

}
