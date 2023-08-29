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

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.business.abstracts.UserService;
import com.example.demo.entities.dtos.request.CompanyCreateObject;
import com.example.demo.entities.dtos.request.UserCreateObject;
import com.example.demo.entities.dtos.response.CompanyResponseObject;
import com.example.demo.entities.dtos.response.UserResponseObject;
import com.example.demo.entities.results.DataResult;
import com.example.demo.entities.results.Result;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	
	private CompanyService companyService;
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@GetMapping("/getAllCompany")
	public DataResult<List<CompanyResponseObject>> getAllCompany(){
		return this.companyService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<CompanyCreateObject> add( @RequestBody CompanyCreateObject company) {
		return this.companyService.add(company);
	}
	
	@DeleteMapping("/{id}")
	  public Result deleteById(@PathVariable UUID id) {
		return companyService.delete(id);
	  }
	
	@PutMapping("/put")
	public DataResult<CompanyResponseObject> updateCompany( @RequestBody CompanyResponseObject dto){
		return companyService.update( dto);
	}

}

