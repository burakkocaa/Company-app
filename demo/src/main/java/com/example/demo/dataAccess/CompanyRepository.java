package com.example.demo.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.concretes.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID>{

}
