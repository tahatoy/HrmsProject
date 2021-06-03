package com.example.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {
	private String email;
	private String password;
	private String passwordRepeat;
	private String companyName;
	private String website;
	private String phoneNumber;
}
