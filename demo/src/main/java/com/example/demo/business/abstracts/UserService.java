package com.example.demo.business.abstracts;

import java.util.List;
import java.util.UUID;

import com.example.demo.entities.dtos.request.UserCreateObject;
import com.example.demo.entities.dtos.response.UserResponseObject;
import com.example.demo.entities.results.DataResult;
import com.example.demo.entities.results.Result;

public interface UserService {

	DataResult<UserCreateObject> add(UserCreateObject user);
	
	Result delete(UUID userId);
	
	DataResult<UserResponseObject> findById(UUID userId);
	
	DataResult<UserResponseObject>update(UserResponseObject user);
	
	DataResult<List<UserResponseObject>> getAll();
}
