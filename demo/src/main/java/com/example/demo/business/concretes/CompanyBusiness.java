package com.example.demo.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.dataAccess.CompanyRepository;
import com.example.demo.entities.concretes.Company;
import com.example.demo.entities.concretes.User;
import com.example.demo.entities.dtos.request.CompanyCreateObject;
import com.example.demo.entities.dtos.request.UserCreateObject;
import com.example.demo.entities.dtos.response.CompanyResponseObject;
import com.example.demo.entities.dtos.response.UserResponseObject;
import com.example.demo.entities.results.DataResult;
import com.example.demo.entities.results.Result;
import com.example.demo.entities.results.SuccessDataResult;
import com.example.demo.entities.results.SuccessResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyBusiness implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	private final ModelMapper modelMapper;
	
	
	@Autowired
	private ObjectMapper mapper;


	@Override
	public DataResult<CompanyCreateObject> add(CompanyCreateObject company) {
		
		Company createCompany =modelMapper.map(company, Company.class);
		createCompany.setCreatedBy(createCompany.getCreatedBy());
		createCompany.setCreatedAt(new Date());
		createCompany.setName(company.getFullName());

		return new SuccessDataResult<CompanyCreateObject>(modelMapper.map
				(this.companyRepository.save(createCompany), CompanyCreateObject.class), "data added");
	}

	@Override
	public Result delete(UUID companyId) {
		this.companyRepository.deleteById(companyId);
		return new SuccessResult("user deleted");
	}

	@Override
	public DataResult<CompanyResponseObject> findById(UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CompanyResponseObject> update(CompanyResponseObject company) {
        Company companyEntity = this.companyRepository.getById(company.getId());
		
        companyEntity.setUpdatedAt(new Date());
		companyEntity.setName(company.getFullName());
		companyEntity.setUpdatedBy(company.getId());
		
		Company newCompany = this.companyRepository.save(companyEntity);
		
		return new SuccessDataResult<CompanyResponseObject>(company,"data updated");
	}

	@Override
	public DataResult<List<CompanyResponseObject>> getAll() {
		List<Company> companyList = this.companyRepository.findAll();
		
		List<CompanyResponseObject> companyObjects = companyList.stream()
				.map(company -> modelMapper.map(company, CompanyResponseObject.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<CompanyResponseObject>>(companyObjects, "data listed");
	}

}
