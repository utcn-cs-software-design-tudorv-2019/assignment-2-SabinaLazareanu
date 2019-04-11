package com.assigment2.university.model.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assigment2.university.model.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {

	public List<User> findAll();

	public User save(User user);

	public User findByid(Long id);
}
