package com.example.demo.business.abstracts;

import java.util.List;
import java.util.UUID;

import com.example.demo.entities.dtos.request.CompanyCreateObject;
import com.example.demo.entities.dtos.response.CompanyResponseObject;
import com.example.demo.entities.dtos.response.UserResponseObject;
import com.example.demo.entities.results.DataResult;
import com.example.demo.entities.results.Result;

public interface CompanyService {

	DataResult<	CompanyCreateObject> add(CompanyCreateObject company);
	
	Result delete(UUID companyId);
	
	DataResult<CompanyResponseObject> findById(UUID companyId);
	
	DataResult<CompanyResponseObject>update(CompanyResponseObject company);
	
	DataResult<List<CompanyResponseObject>> getAll();

}
