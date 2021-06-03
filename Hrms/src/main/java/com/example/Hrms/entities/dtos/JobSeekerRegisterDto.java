package com.example.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerRegisterDto {
	private String email;
	private String password;
	private String passwordRepeat;
	private String firstName;
	private String lastName;
	private String nationalId;
	private String birthYear;
}
