package com.assigment2.model.services;

import java.util.List;

import javax.inject.Inject;

import com.assigment2.model.entities.User;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.UserRepository;

public class UserService {

	private UserRepository userRepo;

	@Inject
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User getByID(Integer id) throws DatabaseAccesException {
		return userRepo.getById(id);
	}

	public User save(User object) throws DatabaseAccesException {
		return userRepo.save(object);
	}

	public void update(User object) throws DatabaseAccesException {
		userRepo.update(object);
	}

	public void delete(User object) throws DatabaseAccesException {
		userRepo.delete(object);
	}

	public List<User> getAll() throws DatabaseAccesException {
		return userRepo.getAll();
	}

}
