package com.example.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {
	
	
	@Column(name="name")
	private String firstName;
	
	@Column(name="surname")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalId;
	
	@Column(name="birth_year")
	private Date birthDate;
	
	@Column(name="verify")
	private boolean verify=false;

	public JobSeeker(String email, String password, String firstName, String lastName, String nationalId,
			Date birthDate, boolean verify) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.birthDate = birthDate;
		this.verify = verify;
	}
	
	
	
	
	
	
}
