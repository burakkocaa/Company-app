package com.example.demo.entities.dtos.response;

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

public class UserResponseObject {

	private UUID id;
	private String fullName;
	private String email;
	private Date createdAt;
	private UUID companyId;
}
