package com.assigment2.university.business;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.assigment2.university.model.entity.User;
import com.assigment2.university.model.repo.UserRepository;

@Service
public class UserService {

	@Inject
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User insertUser(User user) {
		return userRepo.save(user);
	}

	public User getUserById(Long id) {
		return userRepo.findByid(id);
	}

}
