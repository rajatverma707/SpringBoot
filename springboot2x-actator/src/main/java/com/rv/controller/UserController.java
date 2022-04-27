package com.rv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rv.repository.UserRepository;
import com.rv.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/loadusers")
	public List<User> getAllUsers(){
		
		return repository.getAllUser();
	}

}
