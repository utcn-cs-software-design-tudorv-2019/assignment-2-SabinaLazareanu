package com.assigment2.controller;

public class Validator {

	public boolean validatePassword(String password, String confirmedPassword) {
		return password.equals(confirmedPassword);
	}

}
