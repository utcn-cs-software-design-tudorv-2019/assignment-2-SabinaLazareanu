package com.assigment2.university.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.assigment2.university.business.UserService;
import com.assigment2.university.model.entity.User;

@RestController
public class UserController {

	@Inject
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView getCourses() {
		List<User> usersList = userService.getAllUsers();
		System.out.println(usersList.toString());
		ModelAndView mav = new ModelAndView("users");
		mav.addObject("urers", usersList);
		return mav;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		user.set_id(ObjectId.get());
		userService.insertUser(user);
		return user;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
}
