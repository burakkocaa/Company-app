package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.entities.dtos.request.UserCreateObject;
import com.example.demo.entities.dtos.response.UserResponseObject;
import com.example.demo.entities.results.DataResult;
import com.example.demo.entities.results.Result;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAllUser")
	public DataResult<List<UserResponseObject>> getAllUser(){
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<UserCreateObject> add( @RequestBody UserCreateObject user) {
		return this.userService.add(user);
	}
	
	@DeleteMapping("/{id}")
	  public Result deleteById(@PathVariable UUID id) {
		return userService.delete(id);
	  }
	
	@PutMapping("/put")
	public DataResult<UserResponseObject> updateUser( @RequestBody UserResponseObject dto){
		return userService.update( dto);
	}

}
