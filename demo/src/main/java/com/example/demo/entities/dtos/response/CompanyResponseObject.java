package com.example.demo.entities.dtos.response;


import com.example.demo.entities.dtos.request.CompanyCreateObject;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponseObject {

	private UUID id;
	private String fullName;
	private Date createdAt;
}
