package com.example.demo.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.dataAccess.CompanyRepository;
import com.example.demo.dataAccess.UserRepository;
import com.example.demo.entities.concretes.Company;
import com.example.demo.entities.concretes.User;
import com.example.demo.entities.dtos.request.UserCreateObject;
import com.example.demo.entities.dtos.response.UserResponseObject;
import com.example.demo.entities.results.DataResult;
import com.example.demo.entities.results.Result;
import com.example.demo.entities.results.SuccessDataResult;
import com.example.demo.entities.results.SuccessResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserBusiness implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	private final ModelMapper modelMapper;
	
	
	@Autowired
	private ObjectMapper mapper;


	@Override
	public DataResult<UserCreateObject> add(UserCreateObject user) {
		
		User createUser =modelMapper.map(user, User.class);
		createUser.setCreatedBy(createUser.getCreatedBy());
		createUser.setCreatedAt(new Date());
		Company company = this.companyRepository.getById(user.getCompanyId());
		createUser.setCompany(company);

		return new SuccessDataResult<UserCreateObject>(modelMapper.map
				(this.userRepository.save(createUser), UserCreateObject.class), "data added");
	}


	@Override
	public Result delete(UUID userId) {
		this.userRepository.deleteById(userId);
		return new SuccessResult("user deleted");
	}


	@Override
	public DataResult<UserResponseObject> update(UserResponseObject user) {
		User userEntity = this.userRepository.getById(user.getId());
		
		userEntity.setUpdatedAt(new Date());
		userEntity.setEmail(user.getEmail());
		userEntity.setFullName(user.getFullName());
		userEntity.setUpdatedBy(user.getId());
		
		User newUser = this.userRepository.save(userEntity);
		
		return new SuccessDataResult<UserResponseObject>(user,"data updated");
		
		
	}


	@Override
	public DataResult<List<UserResponseObject>> getAll() {
		
		List<User> userList = this.userRepository.findAll();
		
		List<UserResponseObject> userObjects = userList.stream()
				.map(user -> modelMapper.map(user, UserResponseObject.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<UserResponseObject>>(userObjects, "data listed");
	}


	@Override
	public DataResult<UserResponseObject> findById(UUID userId) {
		return null;
	}
	
}
